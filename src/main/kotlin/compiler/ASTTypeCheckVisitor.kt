package compiler

import ast.*

/* global var initilizations that need to be done at the start of main */
data class GlobalVarInit(val ast: ASTVarDecl, val scope: ASTNodeArray<ASTNode>)

class ASTTypeCheckVisitor {
    val global_var_inits = mutableListOf<GlobalVarInit>()

    /* TODO: handle closures (they need to be emitted outside of body) */
    fun visitASTNodeArray(ast: ASTNodeArray<ASTNode>, emitter: Emit) {
        //val emit = if(ast.is_proto_decl) DummyEmit() else emitter
        val emit = emitter
        if(ast.is_proto_decl) return

        for (i in 0.until(ast.nodes.size)) {
            val node = ast.nodes[i]
            when (node) {
                is ASTFuncDecl -> visitASTFuncDecl(node, ast, emit)
                is ASTClassDeclStmnt -> visitASTClassDeclStmnt(node, ast, emit)
                is ASTVarDecl -> visitASTVarDecl(node, ast, emit)

                is ASTExpr -> {
                    visitASTExpr(node, ast, emit)
                    emit.write(";\n")
                }

                is ASTReturnStmnt -> visitASTReturnStmnt(node, ast, emit)

                is ASTIfStmnt -> visitASTIfStmnt(node, ast, emit)
                is ASTElseIfStmnt -> {
                    if(i < 1 || (ast.nodes[i-1] !is ASTIfStmnt && ast.nodes[i-1] !is ASTElseIfStmnt)){
                        compilerError("elsif is not directly preceded by if or elsif statement", node.loc)
                    }
                    visitASTElseIfStmnt(node, ast, emit)
                }
                is ASTElseStmnt -> {
                    if(i < 1 || (ast.nodes[i-1] !is ASTIfStmnt && ast.nodes[i-1] !is ASTElseIfStmnt)){
                        compilerError("else is not directly preceded by if or elsif statement", node.loc)
                    }
                    visitASTElseStmnt(node, ast, emit)
                }

                is ASTWhileStmnt -> visitASTWhileStmnt(node, ast, emit)
                is ASTDoWhileStmnt -> visitASTDoWhileStmnt(node, ast, emit)
                is ASTForStmnt -> visitASTForStmnt(node, ast, emit)
                is ASTBreakStmnt -> visitASTBreakStmnt(node, ast, emit)
                is ASTContinueStmnt -> visitASTContinueStmnt(node, ast, emit)

                is ASTNodeArray<*> -> visitASTNodeArray(node as ASTNodeArray<ASTNode>, emit)
            }
        }
    }

    fun visitASTFuncDecl(ast: ASTFuncDecl, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        /* emit body */
        val sym = scope.scope.findSymbol(ast.name)
        if(sym == null){
            compilerError("function ${ast.name} not found in symbol tables", null)
        }
        sym.is_declared = true

        if(sym.storage == Symbol.StorageType.NESTFUNC) {
            emit.write("static ")
        }
        (sym.type as FunctionType).return_type!!.emitVarTypeDecl(emit)
        ast.body.decld_ret_type = (sym.type as FunctionType).return_type

        val args = (sym.type as FunctionType).args
        emit.write(" ${sym.name}(void *_data${if (args.isNotEmpty()) ", " else ""}")

        for(i in 0.until(args.size)){
            val asym = ast.body.scope.findSymbol(ast.type.args[i].name)
            if(asym == null){
                compilerError("can't find arg ${ast.type.args[i].name} in symbol tables", ast.loc)
            }
            asym.is_declared = true
            args[i].emitVarTypeDecl(emit)
            emit.write(" ${ast.type.args[i].name}")
            if (i < args.size - 1) {
                emit.write(", ")
            }
        }

        emit.write(") {\n")

        visitASTNodeArray(ast.body, emit)

        emit.write("}\n\n")

        if(ast.body.ret_type is InferredType){
            ast.body.ret_type = VoidType()
        }

        if(!ast.body.ret_type.canImplicitConvert((sym.type as FunctionType).return_type!!)){
            compilerError("return type of ${ast.name} (${ast.body.ret_type}) does not match declared return type of ${(sym.type as FunctionType).return_type!!}", ast.loc)
        }

    }

    fun visitASTClassDeclStmnt(ast: ASTClassDeclStmnt, scope: ASTNodeArray<ASTNode>, emit: Emit){
        /* go through fields, infer types, mark as declared, handle inital values */
        for(field in ast.fields.nodes){
            val dummy_scope = ASTNodeArray<ASTNode>(mutableListOf<ASTNode>())
            dummy_scope.higher_fun_scope = null
            dummy_scope.fun_scope = null

            dummy_scope.scope = ast.scope

            visitASTVarDecl(field, dummy_scope, emit)
        }

        /* go through methods, and emit them */
        for(method in ast.methods.nodes){
            /* construct a dummy scope to hold variables - it will only be used to check higher functions scopes, which are always null b/c classes can't be nested in functions */
            val dummy_scope = ASTNodeArray<ASTNode>(mutableListOf<ASTNode>())
            dummy_scope.higher_fun_scope = null
            dummy_scope.fun_scope = null

            dummy_scope.scope = ast.scope

            visitASTFuncDecl(method, dummy_scope, emit)
        }

        /* emit class constructor */
        val cls = classTable.findSymbol(ast.name)
        if(cls == null || cls.type !is ClassType) {
            error("can't find class with name ${ast.name}")
        }

        val cons_type = scope.scope.findSymbol(ast.name)
        if(cons_type == null || cons_type.type !is FunctionType) {
            error("can't find class constructor ${ast.name}")
        }

        val func_type = cons_type.type as FunctionType

        /* emit header */
        func_type.return_type!!.emitVarTypeDecl(emit)

        emit.write(" ${emit.getID(cls.type.getTypeName())}(void * _data")

        for (i in 0.until(func_type.args.size)) {
            emit.write(", ")
            func_type.args[i].emitVarTypeDecl(emit)
            emit.write(" arg$i")
        }

        emit.write(") {\n")
        cls.type.emitVarTypeDecl(emit)
        emit.write(" _obj = _lang_gc_alloc(sizeof(struct ${emit.getID(ast.name)}));\n")
        emit.write("((struct __Object *)_obj)->_vtable = (struct __Object_vtable *)&${emit.getID(ast.name)}_vtable_inst;\n")

        /* TODO: class inline var initialization and gc_desk */
        emit.write("${emit.getID(cls.type.getTypeName())}_construct(_obj")
        for (i in 0.until(func_type.args.size)) {
            emit.write(", ")
            emit.write(" arg$i")
        }
        emit.write(");\nreturn _obj;\n}\n\n")
    }

    fun emitExprImplicitConvert(emit: Emit, to_type: Type, init_val: ASTExpr, scope: ASTNodeArray<ASTNode>): Type{
        if(to_type is BooleanType){
            emit.write("(bool)((")
            val type = visitASTExpr(init_val, scope, emit)
            if(type.isPointer()) {
                emit.write(" ) != NULL)")
            } else {
                emit.write("))")
            }
            return BooleanType()
        } else {
            emit.write("(")
            to_type.emitVarTypeDecl(emit)
            emit.write(")(")
            val typ = visitASTExpr(init_val, scope, emit)
            emit.write(")")
            return typ
        }
    }

    fun visitASTVarDecl(ast: ASTVarDecl, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        val sym = scope.scope.findSymbol(ast.name)
        if(sym == null){
            compilerError("can't find var ${ast.name}", ast.loc)
        }

        sym.is_declared = true

        when(sym.storage){
            Symbol.StorageType.LOCAL -> {
                if(ast.init_val != null) {
                    /* attempt to infer type */
                    if (sym.type is InferredType) {
                        val type = visitASTExpr(ast.init_val!!, scope, DummyEmit())
                        sym.type = type
                    }
                    if(sym.mutable == Symbol.Mutability.IMUT) {
                        emit.write("const ")
                    }
                    sym.type.emitVarTypeDecl(emit)

                    emit.write(" ${sym.name} = ")
                    val type = emitExprImplicitConvert(emit, sym.type, ast.init_val!!, scope)
                    if(!type.canImplicitConvert(sym.type)){
                        compilerError("declared type of variable ${ast.name} (${sym.type}) does not match type of initial value ($type)", ast.loc)
                    }
                    emit.write(";\n")
                } else {
                    if (sym.type is InferredType) {
                        compilerError("can not infer type of variable ${ast.name} without initial value", ast.loc)
                    }
                    if (sym.mutable == Symbol.Mutability.IMUT){
                        compilerError("immutable variable ${ast.name} needs to be initialized", ast.loc)
                    }
                    sym.type.emitVarTypeDecl(emit)
                    emit.write(" ${sym.name} = ${sym.type.getCZeroValue()};\n")
                }
            }

            Symbol.StorageType.GLOBAL -> {
                if(ast.init_val != null) {
                    /* attempt to infer type */
                    if (sym.type is InferredType) {
                        val type = visitASTExpr(ast.init_val!!, scope, DummyEmit())
                        sym.type = type
                    }
                    if(sym.mutable == Symbol.Mutability.IMUT) {
                        emit.write("const ")
                    }
                    sym.type.emitVarTypeDecl(emit)
                    emit.write(" ${sym.name};\n")
                    val type = visitASTExpr(ast.init_val!!, scope, DummyEmit())
                    if(!type.canImplicitConvert(sym.type)){
                        compilerError("declared type of variable ${ast.name} (${sym.type}) does not match type of initial value ($type)", ast.loc)
                    }
                    global_var_inits += GlobalVarInit(ast, scope)
                } else {
                    if (sym.type is InferredType) {
                        compilerError("can not infer type of variable ${ast.name} without initial value", ast.loc)
                    }
                    if (sym.mutable == Symbol.Mutability.IMUT){
                        compilerError("immutable variable ${ast.name} needs to be initialized", ast.loc)
                    }
                    sym.type.emitVarTypeDecl(emit)
                    emit.write(" ${sym.name} = ${sym.type.getCZeroValue()};\n")
                }
            }

            Symbol.StorageType.CLASSVAR -> {
                if(ast.init_val != null) {
                    val type = visitASTExpr(ast.init_val!!, scope, DummyEmit())
                    /* attempt to infer type */
                    if (sym.type is InferredType) {
                        sym.type = type
                    }
                    if(!type.canImplicitConvert(sym.type)){
                        compilerError("declared type of variable ${ast.name} (${sym.type}) does not match type of initial value ($type)", ast.loc)
                    }
                    TODO("class var inline initilization")
                } else {
                    if (sym.type is InferredType) {
                        compilerError("can not infer type of variable ${ast.name} without initial value", ast.loc)
                    }

                    /* TODO: allow immutable vars to be set in constructor, along with other vars + defualt values */
                }
            }

            Symbol.StorageType.NONLOCAL -> {
                TODO("closure variable declaration emitting")
            }

            else -> {
                error("not valid storage type")
            }
        }

    }

    fun visitASTExpr(ast: ASTExpr, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        when(ast){
            is ASTLiteralExpr -> return visitASTLiteralExpr(ast, scope, emit)
            is ASTVarExpr -> return visitASTVarExpr(ast, scope, emit)
            is ASTExprOp -> return visitASTExprOp(ast, scope, emit)
            is ASTFuncCallExpr -> return visitASTFuncCallExpr(ast, scope, emit)
            is ASTAssignExpr -> return visitASTAssignExpr(ast, scope, emit)
            is ASTDotExpr -> return visitASTDotExpr(ast, scope, emit)
        }

        return VoidType()
    }

    fun visitASTLiteralExpr(ast: ASTLiteralExpr, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        if(ast is ASTArrayLiteralExpr) {
            if(ast.lits.isEmpty()) {
                TODO("array of fully castable (potentially null) type")
            }
            val first_type = visitASTExpr(ast.lits[0], scope, DummyEmit())
            emit.write("_lang_make_array_${if(first_type.isPointer()) "pointer" else first_type.getTypeName()}(${ast.lits.size}, ")
            var type: Type? = null
            for(i in 0.until(ast.lits.size)) {
                val lit = ast.lits[i]
                val typ = visitASTExpr(lit, scope, emit)
                if(type == null) {
                    type = typ
                } else if(typ != type) {
                    /* TODO: implicit conversions of array */
                    compilerError("array literal type $typ doesn't match earlier element type of $type", lit.loc)
                }
                if(i < ast.lits.size - 1) {
                    emit.write(", ")
                }
            }
            emit.write(")")

            return ArrayType(type!!, -1)
        } else {
            if (ast.value == null) {
                compilerError("ASTLiteralExpr literal value can't be null", ast.loc)
            }
            if (ast.value[0] == '\'') {
                emit.write(ast.value)
                return CharType()
            } else if (ast.value[0] == '\"') {
                emit.write("_lang_make_string(${ast.value})")
                return ArrayType(CharType(), null)
            } else {
                emit.write(ast.value)
                return LongType()
            }
        }
    }

    fun visitASTVarExpr(ast: ASTVarExpr, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        if(ast.name == "true") {
            emit.write("true")
            return BooleanType()
        } else if(ast.name == "false") {
            emit.write("false")
            return BooleanType()
        }

        val sym = scope.scope.findSymbol(ast.name)
        if(sym == null){
            compilerError("no such variable: ${ast.name}", ast.loc)
        }

        if(!sym.is_declared && !(sym.type is FunctionType)){
            compilerError("variable ${ast.name} used before declaration", ast.loc)
        }

        /* actually emit variable access */
        when(sym.storage){
            Symbol.StorageType.LOCAL -> emit.write(sym.name)
            Symbol.StorageType.GLOBAL -> emit.write(sym.name)
            Symbol.StorageType.CLASSVAR -> {
                emit.write("(((struct ${emit.getID((sym.of_class!!).getTypeName())}*) _data)->${sym.name})")
            }
            Symbol.StorageType.NONLOCAL -> TODO("closure variable access")
            Symbol.StorageType.GLBFUNC -> emit.write(sym.name)

            else -> TODO("variable type access not implemented")
        }

        return sym.type
    }

    fun visitASTExprOp(ast: ASTExprOp, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        /* TODO: handle logical ops */
        if(ASTExprOp.ExprType.isLogical(ast.type)){
            val type1 = visitASTExpr(ast.left, scope, DummyEmit())
            if(!type1.canImplicitConvert(BooleanType())){
                compilerError("cannot convert expr to type ${BooleanType()}", ast.left.loc)
            }

            if(ast.is_unary){
                val op_str = when(ast.type){
                    ASTExprOp.ExprType.LOGICAL_NOT -> "!"
                    else -> error("no such unary logical op")
                }
                emit.write("($op_str")
                emitExprImplicitConvert(emit, BooleanType(), ast.left, scope)
                emit.write(")")

            } else {
                val type2 = visitASTExpr(ast.right!!, scope, DummyEmit())
                if(!type2.canImplicitConvert(BooleanType())){
                    compilerError("cannot convert expr to type ${BooleanType()}", ast.right.loc)
                }
                val op_str = when(ast.type){
                    ASTExprOp.ExprType.LOGICAL_AND -> "&&"
                    ASTExprOp.ExprType.LOGICAL_OR -> "||"
                    else -> error("no such unary binary op")
                }
                emit.write("(")
                emitExprImplicitConvert(emit, BooleanType(), ast.left, scope)
                emit.write(op_str)
                emitExprImplicitConvert(emit, BooleanType(), ast.right, scope)
                emit.write(")")

            }
            return BooleanType()
        } else {
            if (ast.is_unary) {
                val type = visitASTExpr(ast.left, scope, DummyEmit())
                if (!type.hasOpDefined(ast.type, null)) {
                    compilerError("Operation ${ast.type} is not defined on type $type", ast.loc)
                }
                return type.emitOp(ast.type, this, emit, ast.left, ast.right, scope)
            } else {
                val type1 = visitASTExpr(ast.left, scope, DummyEmit())
                val type2 = visitASTExpr(ast.right!!, scope, DummyEmit())
                if (!type1.hasOpDefined(ast.type, type2)) {
                    compilerError("Operation ${ast.type} is not defined on types $type1 and $type2", ast.loc)
                }
                return type1.emitOp(ast.type, this, emit, ast.left, ast.right, scope)
            }
        }
    }

    fun visitASTFuncCallExpr(ast: ASTFuncCallExpr, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        if(ast.func is ASTDotExpr) {
            val access_expr = ast.func.left
            val name = (ast.func.right as? ASTVarExpr)?.name
            if(name == null) {
                error("invalid astdotexpr name")
            }
            val type = visitASTExpr(access_expr, scope, DummyEmit())
            if(!type.hasFieldCall(name)) {
                compilerError("type $type has no method $name", ast.func.right.loc)
            }
            return type.emitFieldCall(name, this, emit, access_expr, ast, scope)
        } else {
            val left = visitASTExpr(ast.func, scope, emit)
            if (left !is FunctionType) {
                compilerError("function call performed on variable of type $left (not a function)", ast.func.loc)
            }
            emit.write("(")
            if (left.binding_type != FunctionType.Binding.GLOBAL) {
                TODO("non global function calls")
            }
            /* TODO: get function type (global, closure, class, and adjust first arg appropriately) */
            emit.write("NULL")
            if (ast.args.nodes.size > 0) emit.write(", ")
            if (ast.args.nodes.size != left.args.size) {
                compilerError("number of arguments (${ast.args.nodes.size}) doesn't match expected number of ${left.args.size}", if (ast.args.nodes.size > 0) ast.args.nodes[0].loc else ast.loc)
            }
            for (i in 0.until(ast.args.nodes.size)) {
                val type = visitASTExpr(ast.args.nodes[i], scope, DummyEmit())
                if (!type.canImplicitConvert(left.args[i])) {
                    compilerError("type of arg ($type) doesn't match expected type of ${left.args[i]}", ast.args.nodes[i].loc)
                }
                emitExprImplicitConvert(emit, left.args[i], ast.args.nodes[i], scope)
                if (i < ast.args.nodes.size - 1) {
                    emit.write(", ")
                }
            }

            emit.write(")")
            return left.return_type ?: VoidType()
        }
    }

    fun visitASTReturnStmnt(ast: ASTReturnStmnt, scope: ASTNodeArray<ASTNode>, emit: Emit){
        emit.write("return ")
        val type: Type
        if(ast.value == null){
            type = VoidType()
        } else {
            type = emitExprImplicitConvert(emit, scope.fun_scope!!.decld_ret_type!!, ast.value, scope)
        }
        emit.write(";\n")

        if(scope.fun_scope!!.ret_type is InferredType){
            scope.fun_scope!!.ret_type = type
        } else if(!type.canImplicitConvert(scope.fun_scope!!.ret_type)){
            compilerError("return type of $type conflicts with earlier type return type of ${scope.fun_scope!!.ret_type}", ast.loc)
        }
    }

    fun visitASTAssignExpr(ast: ASTAssignExpr, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        if(!ast.lvalue.isLValue()){
            compilerError("left side of assignment is not an lvalue", ast.loc)
        }
        if(ast.lvalue is ASTDotExpr) {
            val type = visitASTExpr(ast.lvalue.left, scope, DummyEmit())
            if(ast.lvalue.right !is ASTVarExpr) {
                error("right side of dot expr not a field name")
            }
            val name = ast.lvalue.right.name
            val accesstyp = type.hasField(name)
            when(accesstyp) {
                Type.FieldType.NONE -> compilerError("field $name does not exist on type $type", ast.lvalue.right.loc)
                Type.FieldType.READONLY -> compilerError("field $name is readonly on type $type", ast.lvalue.right.loc)
                Type.FieldType.READWRITE, Type.FieldType.WRITEONLY -> {
                    return type.emitFieldWrite(name, this, emit, ast.lvalue.left, ast.rvalue, scope)
                }
            }
        } else {
            val left = visitASTExpr(ast.lvalue, scope, emit)
            emit.write(" = ")
            val right = emitExprImplicitConvert(emit, left, ast.rvalue, scope)
            if (!right.canImplicitConvert(left)) {
                compilerError("type of value being assigned ($right) does not match expected type ($left)", ast.loc)
            }

            return left
        }
    }

    fun visitASTDotExpr(ast: ASTDotExpr, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        val ltype = visitASTExpr(ast.left, scope, DummyEmit())
        if(ast.right !is ASTVarExpr) {
            compilerError("right side of field access has to be a ASTVarExpr", ast.right.loc)
        }
        val name = ast.right.name
        val accesstyp = ltype.hasField(name)
        when(accesstyp) {
            Type.FieldType.NONE -> compilerError("field $name does not exist on type $ltype", ast.right.loc)
            Type.FieldType.WRITEONLY -> compilerError("field $name is write only", ast.right.loc)
            Type.FieldType.READONLY, Type.FieldType.READWRITE -> {
                return ltype.emitFieldRead(name, this, emit, ast.left, scope)
            }
        }
    }

    fun visitASTIfStmnt(ast: ASTIfStmnt, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        emit.write("if(")
        val type = emitExprImplicitConvert(emit, BooleanType(), ast.cond, scope)
        if(!type.canImplicitConvert(BooleanType())) {
            compilerError("condition cannot be converted to bool", ast.cond.loc)
        }
        emit.write(") {\n")
        visitASTNodeArray(ast.code, emit)
        emit.write("}\n")
    }

    fun visitASTElseIfStmnt(ast: ASTElseIfStmnt, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        emit.write("else if(")
        val type = emitExprImplicitConvert(emit, BooleanType(), ast.cond, scope)
        if(!type.canImplicitConvert(BooleanType())) {
            compilerError("condition cannot be converted to bool", ast.cond.loc)
        }
        emit.write(") {\n")
        visitASTNodeArray(ast.code, emit)
        emit.write("}\n")
    }

    fun visitASTElseStmnt(ast: ASTElseStmnt, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        emit.write("else {\n")
        visitASTNodeArray(ast.code, emit)
        emit.write("}\n")
    }

    fun visitASTWhileStmnt(ast: ASTWhileStmnt, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        emit.write("while (");
        val type = emitExprImplicitConvert(emit, BooleanType(), ast.cond, scope)
        if(!type.canImplicitConvert(BooleanType())) {
            compilerError("condition cannot be converted to bool", ast.cond.loc)
        }
        emit.write(") {\n");
        visitASTNodeArray(ast.code, emit)
        emit.write("}\n")
    }

    fun visitASTDoWhileStmnt(ast: ASTDoWhileStmnt, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        emit.write("do {\n");
        visitASTNodeArray(ast.code, emit)
        emit.write("} while (")
        val type = emitExprImplicitConvert(emit, BooleanType(), ast.cond, scope)
        if(!type.canImplicitConvert(BooleanType())) {
            compilerError("condition cannot be converted to bool", ast.cond.loc)
        }
        emit.write(");\n")
    }

    fun visitASTForStmnt(ast: ASTForStmnt, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        emit.write("for (")

        if (ast.inital is ASTExpr) {
            visitASTExpr(ast.inital, scope, emit)
            emit.write("; ")
        } else if (ast.inital is ASTVarDecl) {
            visitASTVarDecl(ast.inital, scope, emit)
        } else {
            error("for inital condition not var decl or expr")
        }
        if(!emitExprImplicitConvert(emit, BooleanType(), ast.cond, scope).canImplicitConvert(BooleanType())) {
            compilerError("condition cannot be converted to bool", ast.cond.loc)
        }
        emit.write("; ")
        visitASTExpr(ast.end, scope, emit)
        emit.write(") {\n")
        visitASTNodeArray(ast.code, emit)
        emit.write("}\n")
    }

    fun visitASTBreakStmnt(ast: ASTBreakStmnt, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        emit.write("break;\n")
    }

    fun visitASTContinueStmnt(ast: ASTContinueStmnt, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        emit.write("continue;\n")
    }

    fun emitMainFunc(scope: ASTNodeArray<ASTNode>, emit: Emit){
        emit.write("int main (int argc, char **argv) {\n")
        for(glb in global_var_inits){
            val sym = glb.scope.scope.findSymbol(glb.ast.name)
            if(sym == null){
                compilerError("can't find variable ${glb.ast.name}", null)
            }

            emit.write("${sym.name} = ")
            emitExprImplicitConvert(emit, sym.type, glb.ast.init_val!!, glb.scope)
            emit.write(";\n")
        }
        val main = scope.scope.findSymbol("main")
        if(main == null || main.type !is FunctionType){
            compilerError("No main function was declared", null)
        }
        emit.write("${emit.getID("main")}(NULL);\n};\n")
    }
}

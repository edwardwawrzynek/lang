package compiler

import ast.*

/* global var initilizations that need to be done at the start of main */
data class GlobalVarInit(val ast: ASTVarDecl, val scope: ASTNodeArray<ASTNode>)

class ASTTypeCheckVisitor {
    val global_var_inits = mutableListOf<GlobalVarInit>()

    /* TODO: handle closures (they need to be emitted outside of body) */
    fun visitASTNodeArray(ast: ASTNodeArray<ASTNode>, namespace: Namespace, emitter: Emit) {
        //val emit = if(ast.is_proto_decl) DummyEmit() else emitter
        val emit = emitter
        if(ast.is_proto_decl) return

        for (i in 0.until(ast.nodes.size)) {
            val node = ast.nodes[i]
            when (node) {
                is ASTFuncDecl -> visitASTFuncDecl(node, ast, namespace, emit)
                is ASTClassDeclStmnt -> visitASTClassDeclStmnt(node, ast, namespace, emit)
                is ASTVarDecl -> visitASTVarDecl(node, ast, namespace, emit)

                is ASTExpr -> {
                    visitASTExpr(node, ast, namespace, emit)
                    emit.write(";\n")
                }

                is ASTReturnStmnt -> visitASTReturnStmnt(node, ast, namespace, emit)

                is ASTIfStmnt -> visitASTIfStmnt(node, ast, namespace, emit)
                is ASTElseIfStmnt -> {
                    if(i < 1 || (ast.nodes[i-1] !is ASTIfStmnt && ast.nodes[i-1] !is ASTElseIfStmnt)){
                        compilerError("elsif is not directly preceded by if or elsif statement", node.loc)
                    }
                    visitASTElseIfStmnt(node, ast, namespace, emit)
                }
                is ASTElseStmnt -> {
                    if(i < 1 || (ast.nodes[i-1] !is ASTIfStmnt && ast.nodes[i-1] !is ASTElseIfStmnt)){
                        compilerError("else is not directly preceded by if or elsif statement", node.loc)
                    }
                    visitASTElseStmnt(node, ast, namespace, emit)
                }

                is ASTWhileStmnt -> visitASTWhileStmnt(node, ast, namespace, emit)
                is ASTDoWhileStmnt -> visitASTDoWhileStmnt(node, ast, namespace, emit)
                is ASTForStmnt -> visitASTForStmnt(node, ast, namespace, emit)
                is ASTBreakStmnt -> visitASTBreakStmnt(node, ast, namespace, emit)
                is ASTContinueStmnt -> visitASTContinueStmnt(node, ast, namespace, emit)

                is ASTNodeArray<*> -> visitASTNodeArray(node as ASTNodeArray<ASTNode>, namespace, emit)
                is ASTNamespaceStmnt -> visitASTNodeArray(node.body, Namespace(namespace, node.name, node.body.scope), emit)
            }
        }
    }

    fun visitASTFuncDecl(ast: ASTFuncDecl, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit) {
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

        visitASTNodeArray(ast.body, namespace, emit)

        emit.write("}\n\n")

        if(ast.body.ret_type is InferredType){
            ast.body.ret_type = VoidType()
        }

        if(!ast.body.ret_type.canImplicitConvert((sym.type as FunctionType).return_type!!)){
            compilerError("return type of ${ast.name} (${ast.body.ret_type}) does not match declared return type of ${(sym.type as FunctionType).return_type!!}", ast.loc)
        }

    }

    fun visitASTClassDeclStmnt(ast: ASTClassDeclStmnt, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit){
        /* go through fields, infer types, mark as declared, handle inital values */
        for(field in ast.fields.nodes){
            val dummy_scope = ASTNodeArray<ASTNode>(mutableListOf<ASTNode>())
            dummy_scope.higher_fun_scope = null
            dummy_scope.fun_scope = null

            dummy_scope.scope = ast.scope

            visitASTVarDecl(field, dummy_scope, namespace, emit)
        }

        /* go through methods, and emit them */
        for(method in ast.methods.nodes){
            /* construct a dummy scope to hold variables - it will only be used to check higher functions scopes, which are always null b/c classes can't be nested in functions */
            val dummy_scope = ASTNodeArray<ASTNode>(mutableListOf<ASTNode>())
            dummy_scope.higher_fun_scope = null
            dummy_scope.fun_scope = null

            dummy_scope.scope = ast.scope

            visitASTFuncDecl(method, dummy_scope, namespace, emit)
        }

        /* emit class constructor */
        val cls = classTable.findSymbolByNamespaceName(namespace, ast.name)
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
        emit.write(" ${(cls.type as ClassType).getName(emit)}(void * _data")

        for (i in 0.until(func_type.args.size)) {
            emit.write(", ")
            func_type.args[i].emitVarTypeDecl(emit)
            emit.write(" arg$i")
        }

        emit.write(") {\n")
        cls.type.emitVarTypeDecl(emit)
        emit.write(" _obj = _lang_gc_alloc(sizeof(struct ${(cls.type as ClassType).getName(emit)}));\n")
        emit.write("((struct __Object *)_obj)->_vtable = (struct __Object_vtable *)&${(cls.type as ClassType).getName(emit)}_vtable_inst;\n")

        /* TODO: class inline var initialization and gc_desk */
        emit.write("${(cls.type as ClassType).getName(emit)}_construct(_obj")

        for (i in 0.until(func_type.args.size)) {
            emit.write(", ")
            emit.write(" arg$i")
        }
        emit.write(");\nreturn _obj;\n}\n\n")
    }

    fun emitExprImplicitConvert(emit: Emit, to_type: Type, init_val: ASTExpr, namespace: Namespace, scope: ASTNodeArray<ASTNode>): Type{
        if(to_type is BooleanType){
            emit.write("(bool)((")
            val type = visitASTExpr(init_val, scope, namespace, emit)
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
            val typ = visitASTExpr(init_val, scope, namespace, emit)
            emit.write(")")
            return typ
        }
    }

    fun visitASTVarDecl(ast: ASTVarDecl, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit) {
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
                        val type = visitASTExpr(ast.init_val!!, scope, namespace, DummyEmit())
                        sym.type = type
                    }
                    if(sym.mutable == Symbol.Mutability.IMUT) {
                        emit.write("const ")
                    }
                    sym.type.emitVarTypeDecl(emit)

                    emit.write(" ${sym.name} = ")
                    val type = emitExprImplicitConvert(emit, sym.type, ast.init_val!!, namespace, scope)
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
                        val type = visitASTExpr(ast.init_val!!, scope, namespace, DummyEmit())
                        sym.type = type
                    }
                    if(sym.mutable == Symbol.Mutability.IMUT) {
                        emit.write("const ")
                    }
                    sym.type.emitVarTypeDecl(emit)
                    emit.write(" ${sym.name};\n")
                    val type = visitASTExpr(ast.init_val!!, scope, namespace, DummyEmit())
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
                    val type = visitASTExpr(ast.init_val!!, scope, namespace, DummyEmit())
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

    fun visitASTExpr(ast: ASTExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit): Type {
        when(ast){
            is ASTLiteralExpr -> return visitASTLiteralExpr(ast, scope, namespace, emit)
            is ASTVarExpr -> return visitASTVarExpr(ast, scope, namespace, emit)
            is ASTExprOp -> return visitASTExprOp(ast, scope, namespace, emit)
            is ASTFuncCallExpr -> return visitASTFuncCallExpr(ast, scope, namespace, emit)
            is ASTAssignExpr -> return visitASTAssignExpr(ast, scope, namespace, emit)
            is ASTDotExpr -> return visitASTDotExpr(ast, scope, namespace, emit)
            is ImplicitThisExpr -> return visitImplicitThisExpr(ast, scope, namespace, emit)
        }

        return VoidType()
    }

    fun visitImplicitThisExpr(ast: ImplicitThisExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit): Type {
        emit.write("((")
        ast.type.emitVarTypeDecl(emit)
        emit.write(")_data)")
        return ast.type
    }

    fun visitASTLiteralExpr(ast: ASTLiteralExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit): Type {
        if(ast is ASTArrayLiteralExpr) {
            if(ast.lits.isEmpty()) {
                TODO("array of fully castable (potentially null) type")
            }
            val first_type = visitASTExpr(ast.lits[0], scope, namespace, DummyEmit())
            emit.write("_lang_make_array_${if(first_type.isPointer()) "pointer" else first_type.getTypeName()}(${ast.lits.size}, ")
            var type: Type? = null
            for(i in 0.until(ast.lits.size)) {
                val lit = ast.lits[i]
                val typ = visitASTExpr(lit, scope, namespace, emit)
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
            } else if ("-?[0-9]+".toRegex().matches(ast.value)) {
                emit.write(ast.value)
                return LongType()
            } else if ("-?([0-9]*[.])?[0-9]+".toRegex().matches(ast.value)) {
                emit.write(ast.value)
                return DoubleType()
            } else if (ast.value == "true" || ast.value == "false") {
                emit.write(ast.value)
                return BooleanType()
            } else if (ast.value == "null") {
                emit.write("NULL")
                return NullType()
            } else {
                error("no such literal type")
            }
        }
    }

    fun visitASTVarExpr(ast: ASTVarExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit): Type {

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
                val cls = sym.of_class!!
                when(cls.hasField(sym.name)) {
                    Type.FieldType.NONE -> compilerError("field ${sym.name} does not exist on type $cls", ast.loc)
                    Type.FieldType.WRITEONLY -> compilerError("field ${sym.name} is write only", ast.loc)
                    else -> {
                        cls.emitFieldRead(sym.name, this, emit, ImplicitThisExpr(ast.loc!!, cls), scope, namespace)
                    }
                }
            }
            Symbol.StorageType.CLASS -> {
                /* this or super ref */
                if(sym.name == "this") {
                    emit.write("((")
                    sym.of_class!!.emitVarTypeDecl(emit)
                    emit.write(")_data)")
                    return sym.of_class!!
                } else {
                    error("invalid class var expr")
                }
            }
            Symbol.StorageType.NONLOCAL -> TODO("closure variable access")
            Symbol.StorageType.GLBFUNC -> emit.write(sym.name)

            else -> TODO("variable type access not implemented")
        }

        return sym.type
    }

    fun visitASTExprOp(ast: ASTExprOp, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit): Type {
        /* TODO: handle logical ops */
        if(ASTExprOp.ExprType.isLogical(ast.type)){
            val type1 = visitASTExpr(ast.left, scope, namespace, DummyEmit())
            if(!type1.canImplicitConvert(BooleanType())){
                compilerError("cannot convert expr to type ${BooleanType()}", ast.left.loc)
            }

            if(ast.is_unary){
                val op_str = when(ast.type){
                    ASTExprOp.ExprType.LOGICAL_NOT -> "!"
                    else -> error("no such unary logical op")
                }
                emit.write("($op_str")
                emitExprImplicitConvert(emit, BooleanType(), ast.left, namespace, scope)
                emit.write(")")

            } else {
                val type2 = visitASTExpr(ast.right!!, scope, namespace, DummyEmit())
                if(!type2.canImplicitConvert(BooleanType())){
                    compilerError("cannot convert expr to type ${BooleanType()}", ast.right.loc)
                }
                val op_str = when(ast.type){
                    ASTExprOp.ExprType.LOGICAL_AND -> "&&"
                    ASTExprOp.ExprType.LOGICAL_OR -> "||"
                    else -> error("no such unary binary op")
                }
                emit.write("(")
                emitExprImplicitConvert(emit, BooleanType(), ast.left, namespace, scope)
                emit.write(op_str)
                emitExprImplicitConvert(emit, BooleanType(), ast.right, namespace, scope)
                emit.write(")")

            }
            return BooleanType()
        } else {
            if (ast.is_unary) {
                val type = visitASTExpr(ast.left, scope, namespace, DummyEmit())
                if (!type.hasOpDefined(ast.type, null)) {
                    compilerError("Operation ${ast.type} is not defined on type $type", ast.loc)
                }
                return type.emitOp(ast.type, this, emit, ast.left, ast.right, scope, namespace)
            } else {
                val type1 = visitASTExpr(ast.left, scope, namespace, DummyEmit())
                val type2 = visitASTExpr(ast.right!!, scope, namespace, DummyEmit())
                if (!type1.hasOpDefined(ast.type, type2)) {
                    compilerError("Operation ${ast.type} is not defined on types $type1 and $type2", ast.loc)
                }
                return type1.emitOp(ast.type, this, emit, ast.left, ast.right, scope, namespace)
            }
        }
    }

    fun visitASTFuncCallExpr(ast: ASTFuncCallExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit): Type {
        if(ast.func is ASTDotExpr) {
            val access_expr = ast.func.left
            val name = (ast.func.right as? ASTVarExpr)?.name
            if(name == null) {
                error("invalid astdotexpr name")
            }
            val type = visitASTExpr(access_expr, scope, namespace, DummyEmit())
            if(!type.hasFieldCall(name)) {
                compilerError("type $type has no method $name", ast.func.right.loc)
            }
            return type.emitFieldCall(name, this, emit, access_expr, ast, scope, namespace)
        } else if (ast.func is ASTVarExpr && scope.scope.findSymbol(ast.func.name)?.storage == Symbol.StorageType.CLASSFUNC) {
            val sym = scope.scope.findSymbol(ast.func.name)!!
            if(!sym.of_class!!.hasFieldCall(sym.name)) {
                compilerError("type ${sym.of_class} has no method ${sym.name}", ast.func.loc)
            }
            return sym.of_class!!.emitFieldCall(sym.name, this, emit, ImplicitThisExpr(ast.func.loc!!, sym.of_class!!), ast, scope, namespace)
        } else {
            val left = visitASTExpr(ast.func, scope, namespace, emit)
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
                val type = visitASTExpr(ast.args.nodes[i], scope, namespace, DummyEmit())
                if (!type.canImplicitConvert(left.args[i])) {
                    compilerError("type of arg ($type) doesn't match expected type of ${left.args[i]}", ast.args.nodes[i].loc)
                }
                emitExprImplicitConvert(emit, left.args[i], ast.args.nodes[i], namespace, scope)
                if (i < ast.args.nodes.size - 1) {
                    emit.write(", ")
                }
            }

            emit.write(")")
            return left.return_type ?: VoidType()
        }
    }

    fun visitASTReturnStmnt(ast: ASTReturnStmnt, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit){
        emit.write("return ")
        val type: Type
        if(ast.value == null){
            type = VoidType()
        } else {
            type = emitExprImplicitConvert(emit, scope.fun_scope!!.decld_ret_type!!, ast.value, namespace, scope)
        }
        emit.write(";\n")

        if(scope.fun_scope!!.ret_type is InferredType){
            scope.fun_scope!!.ret_type = type
        } else if(!type.canImplicitConvert(scope.fun_scope!!.ret_type)){
            compilerError("return type of $type conflicts with earlier type return type of ${scope.fun_scope!!.ret_type}", ast.loc)
        }
    }

    fun visitASTAssignExpr(ast: ASTAssignExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit): Type {
        if(!ast.lvalue.isLValue()){
            compilerError("left side of assignment is not an lvalue", ast.loc)
        }
        if(ast.lvalue is ASTDotExpr) {
            val type = visitASTExpr(ast.lvalue.left, scope, namespace, DummyEmit())
            if(ast.lvalue.right !is ASTVarExpr) {
                error("right side of dot expr not a field name")
            }
            val name = ast.lvalue.right.name
            val accesstyp = type.hasField(name)
            when(accesstyp) {
                Type.FieldType.NONE -> compilerError("field $name does not exist on type $type", ast.lvalue.right.loc)
                Type.FieldType.READONLY -> compilerError("field $name is readonly on type $type", ast.lvalue.right.loc)
                Type.FieldType.READWRITE, Type.FieldType.WRITEONLY -> {
                    return type.emitFieldWrite(name, this, emit, ast.lvalue.left, ast.rvalue, scope, namespace)
                }
            }
        } else if (ast.lvalue is ASTVarExpr && scope.scope.findSymbol(ast.lvalue.name)?.storage == Symbol.StorageType.CLASSVAR) {
            val sym = scope.scope.findSymbol(ast.lvalue.name)
            val cls = sym!!.of_class!!
            when(cls.hasField(sym.name)) {
                Type.FieldType.NONE -> compilerError("field ${sym.name} does not exist on type $cls", ast.loc)
                Type.FieldType.READONLY -> compilerError("field ${sym.name} is read only", ast.loc)
                else -> {
                    return cls.emitFieldWrite(sym.name, this, emit, ImplicitThisExpr(ast.loc!!, cls), ast.rvalue, scope, namespace)
                }
            }
        } else {
            val left = visitASTExpr(ast.lvalue, scope, namespace, emit)
            emit.write(" = ")
            val right = emitExprImplicitConvert(emit, left, ast.rvalue, namespace, scope)
            if (!right.canImplicitConvert(left)) {
                compilerError("type of value being assigned ($right) does not match expected type ($left)", ast.loc)
            }

            return left
        }
    }

    fun visitASTDotExpr(ast: ASTDotExpr, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit): Type {
        val ltype = visitASTExpr(ast.left, scope, namespace, DummyEmit())
        if(ast.right !is ASTVarExpr) {
            compilerError("right side of field access has to be a ASTVarExpr", ast.right.loc)
        }
        val name = ast.right.name
        val accesstyp = ltype.hasField(name)
        when(accesstyp) {
            Type.FieldType.NONE -> compilerError("field $name does not exist on type $ltype", ast.right.loc)
            Type.FieldType.WRITEONLY -> compilerError("field $name is write only", ast.right.loc)
            Type.FieldType.READONLY, Type.FieldType.READWRITE -> {
                return ltype.emitFieldRead(name, this, emit, ast.left, scope, namespace)
            }
        }
    }

    fun visitASTIfStmnt(ast: ASTIfStmnt, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit) {
        emit.write("if(")
        val type = emitExprImplicitConvert(emit, BooleanType(), ast.cond, namespace, scope)
        if(!type.canImplicitConvert(BooleanType())) {
            compilerError("condition cannot be converted to bool", ast.cond.loc)
        }
        emit.write(") {\n")
        visitASTNodeArray(ast.code, namespace, emit)
        emit.write("}\n")
    }

    fun visitASTElseIfStmnt(ast: ASTElseIfStmnt, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit) {
        emit.write("else if(")
        val type = emitExprImplicitConvert(emit, BooleanType(), ast.cond, namespace, scope)
        if(!type.canImplicitConvert(BooleanType())) {
            compilerError("condition cannot be converted to bool", ast.cond.loc)
        }
        emit.write(") {\n")
        visitASTNodeArray(ast.code, namespace, emit)
        emit.write("}\n")
    }

    fun visitASTElseStmnt(ast: ASTElseStmnt, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit) {
        emit.write("else {\n")
        visitASTNodeArray(ast.code, namespace, emit)
        emit.write("}\n")
    }

    fun visitASTWhileStmnt(ast: ASTWhileStmnt, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit) {
        emit.write("while (");
        val type = emitExprImplicitConvert(emit, BooleanType(), ast.cond, namespace, scope)
        if(!type.canImplicitConvert(BooleanType())) {
            compilerError("condition cannot be converted to bool", ast.cond.loc)
        }
        emit.write(") {\n");
        visitASTNodeArray(ast.code, namespace, emit)
        emit.write("}\n")
    }

    fun visitASTDoWhileStmnt(ast: ASTDoWhileStmnt, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit) {
        emit.write("do {\n");
        visitASTNodeArray(ast.code, namespace, emit)
        emit.write("} while (")
        val type = emitExprImplicitConvert(emit, BooleanType(), ast.cond, namespace, scope)
        if(!type.canImplicitConvert(BooleanType())) {
            compilerError("condition cannot be converted to bool", ast.cond.loc)
        }
        emit.write(");\n")
    }

    fun visitASTForStmnt(ast: ASTForStmnt, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit) {
        emit.write("for (")

        if (ast.inital is ASTExpr) {
            visitASTExpr(ast.inital, scope, namespace, emit)
            emit.write("; ")
        } else if (ast.inital is ASTVarDecl) {
            visitASTVarDecl(ast.inital, scope, namespace, emit)
        } else {
            error("for inital condition not var decl or expr")
        }
        if(!emitExprImplicitConvert(emit, BooleanType(), ast.cond, namespace, scope).canImplicitConvert(BooleanType())) {
            compilerError("condition cannot be converted to bool", ast.cond.loc)
        }
        emit.write("; ")
        visitASTExpr(ast.end, scope, namespace, emit)
        emit.write(") {\n")
        visitASTNodeArray(ast.code, namespace, emit)
        emit.write("}\n")
    }

    fun visitASTBreakStmnt(ast: ASTBreakStmnt, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit) {
        emit.write("break;\n")
    }

    fun visitASTContinueStmnt(ast: ASTContinueStmnt, scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit) {
        emit.write("continue;\n")
    }

    fun emitMainFunc(scope: ASTNodeArray<ASTNode>, namespace: Namespace, emit: Emit){
        emit.write("int main (int argc, char **argv) {\n")
        for(glb in global_var_inits){
            val sym = glb.scope.scope.findSymbol(glb.ast.name)
            if(sym == null){
                compilerError("can't find variable ${glb.ast.name}", null)
            }

            emit.write("${sym.name} = ")
            emitExprImplicitConvert(emit, sym.type, glb.ast.init_val!!, namespace, glb.scope)
            emit.write(";\n")
        }
        val main = scope.scope.findSymbol("main")
        if(main == null || main.type !is FunctionType){
            compilerError("No main function was declared", null)
        }
        emit.write("${emit.getID("main")}(NULL);\n};\n")
    }
}

package compiler

import ast.*

/* global var initilizations that need to be done at the start of main */
data class GlobalVarInit(val ast: ASTVarDecl, val scope: ASTNodeArray<ASTNode>)

class ASTTypeCheckVisitor {
    val global_var_inits = mutableListOf<GlobalVarInit>()

    /* TODO: handle closures (they need to be emitted outside of body */
    fun visitASTNodeArray(ast: ASTNodeArray<ASTNode>, emitter: Emit) {
        val emit = if(ast.is_proto_decl) DummyEmit() else emitter

        for (node in ast.nodes) {
            when (node) {
                is ASTFuncDecl -> visitASTFuncDecl(node, ast, emit)
                is ASTClassDeclStmnt -> visitASTClassDeclStmnt(node, ast, emit)
                is ASTVarDecl -> visitASTVarDecl(node, ast, emit)

                is ASTExpr -> {
                    visitASTExpr(node, ast, emit)
                    emit.write(";\n")
                }

                is ASTReturnStmnt -> visitASTReturnStmnt(node, ast, emit)

                is ASTNodeArray<*> -> visitASTNodeArray(node as ASTNodeArray<ASTNode>, emit)
            }
        }
    }
    
    fun visitASTFuncDecl(ast: ASTFuncDecl, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        /* emit body */
        val sym = scope.scope.findSymbol(ast.name)
        if(sym == null){
            compilerError("function ${ast.name} not found in symbol tables", null)
            return
        }
        sym.is_declared = true

        if(sym.storage == Symbol.StorageType.NESTFUNC) {
            emit.write("static ")
        }
        (sym.type as FunctionType).return_type!!.emitVarTypeDecl(emit)

        val args = (sym.type as FunctionType).args
        emit.write(" ${sym.name}(void *_data${if (args.isNotEmpty()) ", " else ""}")

        for(i in 0.until(args.size)){
            val sym = ast.body.scope.findSymbol(ast.type.args[i].name)
            if(sym == null){
                compilerError("can't find arg ${ast.type.args[i].name} in symbol tables", ast.loc)
            }
            sym!!.is_declared = true
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
    }

    fun emitAssigmentImplicitConvert(emit: Emit, to_type: Type, init_val: ASTExpr, scope: ASTNodeArray<ASTNode>): Type{
        if(to_type is BooleanType){
            emit.write("(")
            val type = visitASTExpr(init_val, scope, emit)
            if(type.isPointer()) {
                emit.write(" != NULL)")
            } else {
                emit.write(")")
            }
            return BooleanType()
        } else {
            emit.write("(")
            to_type.emitVarTypeDecl(emit)
            emit.write(")")
            return visitASTExpr(init_val, scope, emit)
        }
    }

    fun visitASTVarDecl(ast: ASTVarDecl, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        val sym = scope.scope.findSymbol(ast.name)
        if(sym == null){
            compilerError("can't find var ${ast.name}", ast.loc)
        }

        sym!!.is_declared = true

        when(sym.storage){
            Symbol.StorageType.LOCAL -> {
                if(ast.init_val != null) {
                    /* attempt to infer type */
                    if (sym.type is InferredType) {
                        val type = visitASTExpr(ast.init_val!!, scope, DummyEmit())
                        sym.type = type
                    }
                    sym.type.emitVarTypeDecl(emit)

                    emit.write(" ${sym.name} = ")
                    val type = emitAssigmentImplicitConvert(emit, sym.type, ast.init_val!!, scope)
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
        }

    }

    fun visitASTExpr(ast: ASTExpr, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        when(ast){
            is ASTArrayLiteralExpr -> return VoidType()
            is ASTLiteralExpr -> return visitASTLiteralExpr(ast, scope, emit)
            is ASTVarExpr -> return visitASTVarExpr(ast, scope, emit)
            is ASTExprOp -> return visitASTExprOp(ast, scope, emit)
            is ASTFuncCallExpr -> return visitASTFuncCallExpr(ast, scope, emit)
        }

        return VoidType()
    }

    fun visitASTLiteralExpr(ast: ASTLiteralExpr, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        if(ast.value == null){
            compilerError("ASTLiteralExpr literal value can't be null", ast.loc)
        }
        if(ast.value!![0] == '\''){
            emit.write(ast.value!!)
            return CharType()
        }
        if(ast.value!![0] == '\"'){
            TODO("make string literals")
            emit.write(ast.value!!)
            return ArrayType(CharType(), null)
        }
        else {
            emit.write(ast.value!!)
            return LongType()
        }
    }

    fun visitASTVarExpr(ast: ASTVarExpr, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        val sym = scope.scope.findSymbol(ast.name)
        if(sym == null){
            compilerError("no such variable: ${ast.name}", ast.loc)
        }

        if(!sym!!.is_declared){
            compilerError("variable ${ast.name} used before declaration", ast.loc)
        }

        /* actually emit variable access */
        when(sym.storage){
            Symbol.StorageType.LOCAL -> emit.write(sym.name)
            Symbol.StorageType.GLOBAL -> emit.write(sym.name)
            Symbol.StorageType.CLASSVAR -> {
                emit.write("(((${emit.getID((sym.of_class!!).getTypeName())}*) _data)->${sym.name})")
            }
            Symbol.StorageType.NONLOCAL -> TODO("closure variable access")
            Symbol.StorageType.GLBFUNC -> emit.write(sym.name)
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
                emitAssigmentImplicitConvert(emit, BooleanType(), ast.left, scope)
                emit.write(")")

            } else {
                val type2 = visitASTExpr(ast.right!!, scope, DummyEmit())
                if(!type2.canImplicitConvert(BooleanType())){
                    compilerError("cannot convert expr to type ${BooleanType()}", ast.right!!.loc)
                }
                val op_str = when(ast.type){
                    ASTExprOp.ExprType.LOGICAL_AND -> "&&"
                    ASTExprOp.ExprType.LOGICAL_OR -> "||"
                    else -> error("no such unary binary op")
                }
                emit.write("(")
                emitAssigmentImplicitConvert(emit, BooleanType(), ast.left, scope)
                emit.write(op_str)
                emitAssigmentImplicitConvert(emit, BooleanType(), ast.right!!, scope)
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
        val left = visitASTExpr(ast.func, scope, emit)
        if(left !is FunctionType){
            compilerError("function call performed on variable of type $left", ast.func.loc)
        }
        emit.write("(")
        /* TODO: get function type (global, closure, class, and adjust first arg appropriately */
        emit.write("NULL, ")
        for(i in 0.until(ast.args.nodes.size)) {
            val type = visitASTExpr(ast.args.nodes[i], scope, DummyEmit())
            if(!type.canImplicitConvert((left as FunctionType).args[i])){
                compilerError("type of arg ($type) doesn't match expected type of ${(left as FunctionType).args[i]}", ast.args.nodes[i].loc)
            }
            emitAssigmentImplicitConvert(emit, (left as FunctionType).args[i], ast.args.nodes[i], scope)
            if(i < ast.args.nodes.size - 1) {
                emit.write(", ")
            }
        }

        emit.write(")")
        return (left as FunctionType).return_type ?: VoidType()
    }

    fun visitASTReturnStmnt(ast: ASTReturnStmnt, scope: ASTNodeArray<ASTNode>, emit: Emit){
        emit.write("return ")
        val type: Type
        if(ast.value == null){
            type = VoidType()
        } else {
            type = visitASTExpr((ast.value as ASTExpr), scope, emit)
        }
        emit.write(";\n")

        if(scope.fun_scope!!.ret_type is InferredType){
            scope.fun_scope!!.ret_type = type
        } else if(!type.canImplicitConvert(scope.fun_scope!!.ret_type)){
            compilerError("return type of $type conflicts with earlier type return type of ${scope.fun_scope!!.ret_type}", ast.loc)
        }
    }

    fun emitMainFunc(scope: ASTNodeArray<ASTNode>, emit: Emit){
        emit.write("void main (int argc, char **argv) {\n")
        for(glb in global_var_inits){
            val sym = glb.scope.scope.findSymbol(glb.ast.name)
            if(sym == null){
                compilerError("can't find variable ${glb.ast.name}", null)
            }

            emit.write("${sym!!.name} = ")
            emitAssigmentImplicitConvert(emit, sym.type, glb.ast.init_val!!, glb.scope)
            emit.write(";\n")
        }
        val main = scope.scope.findSymbol("main")
        if(main == null || main.type !is FunctionType){
            compilerError("No main function was declared", null)
        }
        emit.write("${emit.getID("main")}(NULL);\n};\n")
    }
}
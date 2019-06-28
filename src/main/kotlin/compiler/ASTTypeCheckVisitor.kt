package compiler

import ast.*

/* global var initilizations that need to be done at the start of main */
data class GlobalVarInit(val ast: ASTVarDecl, val scope: ASTNodeArray<ASTNode>)

class ASTTypeCheckVisitor {
    val global_var_inits = mutableListOf<GlobalVarInit>()


    /* TODO: handle closures (they need to be emitted outside of body */
    fun visitASTNodeArray(ast: ASTNodeArray<ASTNode>, emit: Emit) {
        for(node in ast.nodes) {
            when (node) {
                is ASTFuncDecl -> visitASTFuncDecl(node, ast, emit)
                is ASTClassDeclStmnt -> visitASTClassDeclStmnt(node, ast, emit)
                is ASTVarDecl -> visitASTVarDecl(node, ast, emit)

                is ASTReturnStmnt -> visitASTReturnStmnt(node, ast, emit)
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

        if(sym.storage == Symbol.StorageType.NESTFUNC){
            emit.write("static ")
        }
        (sym.type as FunctionType).return_type!!.emitVarTypeDecl(emit)

        val args = (sym.type as FunctionType).args
        emit.write(" ${sym.name}(void *_data${if (args.isNotEmpty()) ", " else ""}")

        for(i in 0.until(args.size)){
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

        if(ast.body.ret_type != (sym.type as FunctionType).return_type){
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
                    val type = visitASTExpr(ast.init_val!!, scope, emit)
                    if(type != sym.type){
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
                    sym.type.emitVarTypeDecl(emit)
                    emit.write(" ${sym.name};\n")
                    val type = visitASTExpr(ast.init_val!!, scope, DummyEmit())
                    /* attempt to infer type */
                    if (sym.type is InferredType) {
                        sym.type = type
                    }
                    if(type != sym.type){
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
                    if(type != sym.type){
                        compilerError("declared type of variable ${ast.name} (${sym.type}) does not match type of initial value ($type)", ast.loc)
                    }
                    TODO("class var inline initilization")
                } else {
                    if (sym.type is InferredType) {
                        compilerError("can not infer type of variable ${ast.name} without initial value", ast.loc)
                    }
                    /* TODO: allow imutable vars to be set in constructor */
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
            return NumberType()
        }
        return VoidType()
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
                emit.write("((${emit.getID((sym.of_class!!).getTypeName())}*) _data)->${sym.name}")
            }
            Symbol.StorageType.NONLOCAL -> TODO("closure variable access")
        }

        return sym.type
    }

    fun visitASTExprOp(ast: ASTExprOp, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        if(ast.is_unary){
            val type = visitASTExpr(ast.left, scope, emit)
            /* TODO: check if op is defined, emit */
            return type
        } else {
            /* TODO: check if op is defined, emit */
            val type1 = visitASTExpr(ast.left, scope, emit)
            val type2 = visitASTExpr(ast.right!!, scope, emit)

            return type1
        }
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
        } else if(scope.fun_scope!!.ret_type != type){
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
            visitASTExpr(glb.ast.init_val!!, glb.scope, emit)
            emit.write(";\n")
        }
        val main = scope.scope.findSymbol("main")
        if(main == null || main?.type !is FunctionType){
            compilerError("No main function was declared", null)
        }
        emit.write("${emit.getID("main")}();\n};\n")
    }
}
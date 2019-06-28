package compiler

import ast.*

class ASTTypeCheckVisitor {
    /* TODO: handle closures (they need to be emitted outside of body */
    fun visitASTNodeArray(ast: ASTNodeArray<ASTNode>, emit: Emit) {
        for(node in ast.nodes) {
            when (node) {
                is ASTFuncDecl -> visitASTFuncDecl(node, ast, emit)
                is ASTClassDeclStmnt -> visitASTClassDeclStmnt(node, ast, emit)

                is ASTReturnStmnt -> visitASTReturnStmnt(node, ast, emit)
            }
        }
    }

    fun visitASTFuncDecl(ast: ASTFuncDecl, scope: ASTNodeArray<ASTNode>, emit: Emit) {
        /* emit body */
        val sym = scope.scope.findSymbol(ast.name)
        if(sym == null){
            compiler_error("function ${ast.name} not found in symbol tables", null)
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
            compiler_error("return type of ${ast.name} (${ast.body.ret_type}) does not match declared return type of ${(sym.type as FunctionType).return_type!!}", ast.loc)
        }

    }

    fun visitASTClassDeclStmnt(ast: ASTClassDeclStmnt, scope: ASTNodeArray<ASTNode>, emit: Emit){
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

    fun visitASTExpr(ast: ASTExpr, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        when(ast){
            is ASTArrayLiteralExpr -> return VoidType()
            is ASTLiteralExpr -> return visitASTLiteralExpr(ast, scope, emit)
            is ASTVarExpr -> return visitASTVarExpr(ast, scope, emit)
        }

        return VoidType()
    }

    fun visitASTLiteralExpr(ast: ASTLiteralExpr, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        /* TODO: find type */
        return VoidType()
    }

    fun visitASTVarExpr(ast: ASTVarExpr, scope: ASTNodeArray<ASTNode>, emit: Emit): Type {
        val sym = scope.scope.findSymbol(ast.name)
        if(sym == null){
            compiler_error("no such variable: ${ast.name}", ast.loc)
        }

        /* actually emit variable access */
        when(sym!!.storage){
            Symbol.StorageType.LOCAL -> emit.write(sym.name)
            Symbol.StorageType.GLOBAL -> emit.write(emit.getID(sym.name))
            Symbol.StorageType.CLASSVAR -> {
                emit.write("((${(sym.of_class!!).getTypeName()}*) _data)->${sym.name}")
            }
        }

        return sym!!.type
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
            type = visitASTExpr(ast.value, scope, emit)
        }
        emit.write(";\n")

        if(scope.fun_scope!!.ret_type is InferredType){
            scope.fun_scope!!.ret_type = type
        } else if(scope.fun_scope!!.ret_type != type){
            compiler_error("return type of $type conflicts with earlier type return type of ${scope.fun_scope!!.ret_type}", ast.loc)
        }
    }
}
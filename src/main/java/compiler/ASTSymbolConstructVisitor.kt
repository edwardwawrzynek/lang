package compiler

import ast.*

/* general arguments to visit functions:
ast: ast node to be visited
fun_ast: ASTNodeArray of function statements are in, or null
parent_scope: SymbolTable of parent scope to link to current scope
classTable: global table of classes
 */

/* pass to construct symbol tables, and mark variable types (TODO: including finding escaping variables and marking them) */
/* also emits some function headers */
class ASTSymbolConstructVisitor {
    fun visitASTNodeArray(ast: ASTNodeArray<ASTNode>, fun_ast: ASTNodeArray<ASTNode>?, parent_scope: SymbolTable?, classTable: SymbolTable, emit: Emit) {
        /* link scope of objects */
        ast.setParentScope(parent_scope)

        for(node in ast.nodes){
            when(node) {
                is ASTFuncDecl -> visitASTFuncDecl(node, fun_ast, ast.scope, classTable, false, null, emit)
                is ASTVarDecl -> visitASTVarDecl(node, fun_ast, ast.scope, classTable, false, emit)
                is ASTBlockStmnt -> visitASTBlockStmnt(node, fun_ast, ast.scope, classTable, emit)
                is ASTClassDeclStmnt -> visitASTClassDeclStmnt(node, fun_ast, ast.scope, classTable, emit)
            }
        }
    }

    fun visitASTFuncDecl(ast: ASTFuncDecl, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable, is_class_var: Boolean, encl_class: ASTClassDeclStmnt?, emit: Emit) {
        ast.enclosing_func = fun_ast

        if(scope.findSymbolNoParent(ast.name) != null){
            error("Redefinition of function ${ast.name}", ast.loc)
        }
        if(scope.findSymbol(ast.name) != null){
            warning("Function ${ast.name} shadows higher variable\n", ast.loc)
        }

        val storage: Symbol.StorageType

        if(is_class_var){
            if(fun_ast != null){
                error("Functions marked with is_class_var can't be in a function", null)
            }
            storage = Symbol.StorageType.CLASSFUNC
        } else {
            if(fun_ast == null){
                storage = Symbol.StorageType.GLBFUNC
            } else {
                storage = Symbol.StorageType.NESTFUNC
            }
        }

        val symbol = Symbol(ast.name, Symbol.Mutability.IMUT, Type.fromASTType(ast.type, classTable), storage)
        scope.addSymbol(ast.name, symbol)

        /* emit header */
        val args = (symbol.type as FunctionType).args
        (symbol.type as FunctionType).return_type!!.emitVarTypeDecl(emit)
        val name = if(is_class_var) "${emit.getID(encl_class!!.name)}_${ast.getEmitName()}" else emit.getID(ast.getEmitName())
        emit.write(" ${name} (void * _data${if (args.isNotEmpty()) ", " else ""}")

        for (i in 0.until(args.size)) {
            args[i].emitVarTypeDecl(emit)
            emit.write(" ${ast.type.args[i].name}")
            if (i < args.size - 1) {
                emit.write(", ")
            }
        }

        emit.write(");\n")



        /* add args to function scope */
        for(arg in ast.type.args){
            ast.body.setParentScope(scope)
            visitASTVarDecl(arg, ast.body, ast.body.scope, classTable, false, emit)
        }

        visitASTNodeArray(ast.body, ast.body, scope, classTable, emit)
    }

    fun visitASTVarDecl(ast: ASTVarDecl, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable, is_class_var: Boolean, emit: Emit) {
        /* TODO: infer type */
        if(scope.findSymbolNoParent(ast.name) != null){
            error("Redefinition of variable ${ast.name}", ast.loc)
        }
        if(scope.findSymbol(ast.name) != null){
            warning("Variable ${ast.name} shadows higher variable\n", ast.loc)
        }

        val storage: Symbol.StorageType

        if(is_class_var){
            if(fun_ast != null){
                error("Variables marked with is_class_var can't be in a function", null)
            }
            storage = Symbol.StorageType.CLASSVAR
        } else {
            if(fun_ast == null){

                storage = Symbol.StorageType.GLOBAL
            } else {
                storage = Symbol.StorageType.LOCAL
            }
        }

        val symbol = Symbol(ast.name, Symbol.fromASTMut(ast.mutable), Type.fromASTType(ast.type, classTable), storage)

        scope.addSymbol(ast.name, symbol)
    }

    fun visitASTBlockStmnt(ast: ASTBlockStmnt, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable, emit: Emit) {
        if(ast is ASTForStmnt && ast.inital is ASTVarDecl) {
            /* TODO: put var in scope inside of for loop, but where it can be seen by conditions. May need to be in CSTToAST */
            visitASTVarDecl(ast.inital as ASTVarDecl, fun_ast, scope, classTable, false, emit)
        }
        visitASTNodeArray(ast.getBlock(), fun_ast, scope, classTable, emit)
    }

    fun visitASTClassDeclStmnt(ast: ASTClassDeclStmnt, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable, emit: Emit) {
        ast.setParentScope(scope)

        for(field in ast.fields.nodes){
            visitASTVarDecl(field, fun_ast, ast.scope, classTable, true, emit)
        }

        for(method in ast.methods.nodes){
            /* emit header */
            visitASTFuncDecl(method, fun_ast, ast.scope, classTable, true, ast, emit)
        }
    }
}
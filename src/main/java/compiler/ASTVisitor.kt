package compiler

import ast.*

/* general arguments to visit functions:
ast: ast node to be visited
fun_ast: ASTNodeArray of function statements are in, or null
parent_scope: SymbolTable of parent scope to link to current scope
classTable: global table of classes
 */

/* pass to construct symbol tables, and mark variable types (TODO: including finding escaping variables and marking them) */
/* no code gen, b/c we need to do type inference in a separate pass later once we have all symbols in scope recorded */
class ASTVisitor {
    fun visitASTNodeArray(ast: ASTNodeArray<ASTNode>, fun_ast: ASTNodeArray<ASTNode>?, parent_scope: SymbolTable?, classTable: SymbolTable) {
        /* link scope of objects */
        ast.setParentScope(parent_scope)

        for(node in ast.nodes){
            when(node) {
                is ASTFuncDecl -> visitASTFuncDecl(node, fun_ast, ast.scope, classTable, false)
                is ASTVarDecl -> visitASTVarDecl(node, fun_ast, ast.scope, classTable, false)
                is ASTBlockStmnt -> visitASTBlockStmnt(node, fun_ast, ast.scope, classTable)
                is ASTClassDeclStmnt -> visitASTClassDeclStmnt(node, fun_ast, ast.scope, classTable)
            }
        }
    }

    fun visitASTFuncDecl(ast: ASTFuncDecl, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable, is_class_var: Boolean) {
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

        /* add args to function scope */
        for(arg in ast.type.args){
            ast.body.setParentScope(scope)
            visitASTVarDecl(arg, ast.body, ast.body.scope, classTable, false)
        }

        visitASTNodeArray(ast.body, ast.body, scope, classTable)
    }

    fun visitASTVarDecl(ast: ASTVarDecl, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable, is_class_var: Boolean) {
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

    fun visitASTBlockStmnt(ast: ASTBlockStmnt, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable) {
        if(ast is ASTForStmnt && ast.inital is ASTVarDecl) {
            /* TODO: put var in scope inside of for loop, but where it can be seen by conditions. May need to be in CSTToAST */
            visitASTVarDecl(ast.inital as ASTVarDecl, fun_ast, scope, classTable, false)
        }
        visitASTNodeArray(ast.getBlock(), fun_ast, scope, classTable)
    }

    fun visitASTClassDeclStmnt(ast: ASTClassDeclStmnt, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable) {
        ast.setParentScope(scope)

        for(field in ast.fields.nodes){
            visitASTVarDecl(field, fun_ast, ast.scope, classTable, true)
        }

        for(method in ast.methods.nodes){
            visitASTFuncDecl(method, fun_ast, ast.scope, classTable, true)
        }
    }
}
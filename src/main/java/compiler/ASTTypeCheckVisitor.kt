package compiler

import ast.*

class ASTTypeCheckVisitor {
    /* note: if fun_ast isn't null, and we come across an ASTFuncDecl, it will be treated as a closure and emitted later */
    fun visitASTNodeArray(ast: ASTNodeArray<ASTNode>, fun_ast: ASTNodeArray<ASTNode>?, parent_scope: SymbolTable?, classTable: SymbolTable, emit: Emit) {
        for(node in ast.nodes) {
            when (node) {
                is ASTFuncDecl -> visitASTFuncDecl(node, fun_ast, ast.scope, classTable, emit)
            }
        }
    }

    fun visitASTFuncDecl(ast: ASTFuncDecl, fun_ast: ASTNodeArray<ASTNode>?, scope: SymbolTable, classTable: SymbolTable, emit: Emit) {

    }
}
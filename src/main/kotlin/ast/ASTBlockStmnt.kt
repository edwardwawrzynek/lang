package ast

interface ASTBlockStmnt {
    fun getBlock(): ASTNodeArray<ASTNode>
}
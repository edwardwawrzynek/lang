package ast

class ASTReturnStmnt(loc: ASTFileLocation, var `val`: ASTExpr) : ASTNode(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTReturnStmnt:")
        `val`.print(i + 1)
    }
}
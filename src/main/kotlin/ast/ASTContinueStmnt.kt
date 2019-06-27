package ast

class ASTContinueStmnt(loc: ASTFileLocation) : ASTNode(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTContinueStmnt")
    }
}
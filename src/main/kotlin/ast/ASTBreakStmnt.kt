package ast

class ASTBreakStmnt(loc: ASTFileLocation) : ASTNode(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTBreakStmnt")
    }
}
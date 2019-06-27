package ast

open class ASTExpr(loc: ASTFileLocation) : ASTNode(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTExpr")
    }
}
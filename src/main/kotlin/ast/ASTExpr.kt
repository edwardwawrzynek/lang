package ast

open class ASTExpr(loc: ASTFileLocation) : ASTNode(loc) {

    open fun isLValue(): Boolean {
        return false
    }

    override fun print(i: Int) {
        printIndent(i)
        println("ASTExpr")
    }
}
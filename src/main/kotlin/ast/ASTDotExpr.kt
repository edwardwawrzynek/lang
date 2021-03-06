package ast

class ASTDotExpr(loc: ASTFileLocation, val left: ASTExpr, val right: ASTExpr) : ASTExpr(loc) {

    override fun isLValue(): Boolean {
        return true
    }

    override fun print(i: Int) {
        printIndent(i)
        println("ASTDotExpr:")
        left.print(i + 1)
        right.print(i + 1)
    }
}
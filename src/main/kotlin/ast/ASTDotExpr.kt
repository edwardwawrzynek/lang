package ast

class ASTDotExpr(loc: ASTFileLocation, var left: ASTExpr, var right: ASTExpr) : ASTExpr(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTDotExpr:")
        left.print(i + 1)
        right.print(i + 1)
    }
}
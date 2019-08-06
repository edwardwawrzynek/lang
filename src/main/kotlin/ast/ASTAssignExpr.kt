package ast

class ASTAssignExpr(loc: ASTFileLocation, val lvalue: ASTExpr, val rvalue: ASTExpr) : ASTExpr(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTAssignExpr:")
        lvalue.print(i + 1)
        rvalue.print(i + 1)
    }
}
package ast

class ASTArrayExpr(loc: ASTFileLocation, var array: ASTExpr, var subscript: ASTExpr) : ASTExpr(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTArrayExpr: (array, subscript):")
        array.print(i + 1)
        subscript.print(i + 1)
    }
}
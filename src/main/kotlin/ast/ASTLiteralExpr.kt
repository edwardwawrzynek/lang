package ast

open class ASTLiteralExpr(loc: ASTFileLocation, val value: String?) : ASTExpr(loc) {

    override fun print(i: Int) {
        printIndent(i)
        print("ASTLiteralExpr: ")
        println(value)
    }
}
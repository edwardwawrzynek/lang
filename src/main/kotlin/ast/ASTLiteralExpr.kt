package ast

open class ASTLiteralExpr(loc: ASTFileLocation, var value: String?) : ASTExpr(loc) {

    override fun print(i: Int) {
        printIndent(i)
        print("ASTLiteralExpr: ")
        println(value)
    }
}
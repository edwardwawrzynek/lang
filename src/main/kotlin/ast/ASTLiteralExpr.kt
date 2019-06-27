package ast

open class ASTLiteralExpr(loc: ASTFileLocation, var `val`: String?) : ASTExpr(loc) {

    override fun print(i: Int) {
        printIndent(i)
        print("ASTLiteralExpr: ")
        println(`val`)
    }
}
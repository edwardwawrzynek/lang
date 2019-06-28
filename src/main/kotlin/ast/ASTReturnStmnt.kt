package ast

class ASTReturnStmnt(loc: ASTFileLocation, var value: ASTExpr?) : ASTNode(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTReturnStmnt:")
        value?.print(i + 1)
    }
}
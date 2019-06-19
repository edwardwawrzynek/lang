package ast

class ASTElseIfStmnt(loc: ASTFileLocation, var cond: ASTExpr, var code: ASTNodeArray<ASTNode>) : ASTNode(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTElseIfStmnt: (cond, code)")
        cond.print(i + 1)
        code.print(i + 1)
    }
}
package ast

class ASTElseIfStmnt(loc: ASTFileLocation, val cond: ASTExpr, val code: ASTNodeArray<ASTNode>) : ASTNode(loc), ASTBlockStmnt {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTElseIfStmnt: (cond, code)")
        cond.print(i + 1)
        code.print(i + 1)
    }

    override fun getBlock(): ASTNodeArray<ASTNode> {
        return code
    }
}
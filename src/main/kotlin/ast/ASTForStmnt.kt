package ast

class ASTForStmnt(loc: ASTFileLocation, val inital: ASTNode, val cond: ASTExpr, val end: ASTExpr, val code: ASTNodeArray<ASTNode>) : ASTNode(loc), ASTBlockStmnt {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTForStmnt: (initial, cond, end, code)")
        inital.print(i + 1)
        cond.print(i + 1)
        end.print(i + 1)
        code.print(i + 1)
    }

    override fun getBlock(): ASTNodeArray<ASTNode> {
        return code
    }
}
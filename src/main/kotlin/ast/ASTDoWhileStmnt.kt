package ast

class ASTDoWhileStmnt(loc: ASTFileLocation, internal var cond: ASTExpr, internal var code: ASTNodeArray<ASTNode>) : ASTNode(loc), ASTBlockStmnt {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTDoWhileStmnt: (cond, code)")
        cond.print(i + 1)
        code.print(i + 1)
    }

    override fun getBlock(): ASTNodeArray<ASTNode> {
        return code
    }
}
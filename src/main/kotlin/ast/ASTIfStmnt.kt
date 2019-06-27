package ast

class ASTIfStmnt(loc: ASTFileLocation, var cond: ASTExpr, var code: ASTNodeArray<ASTNode>) : ASTNode(loc), ASTBlockStmnt {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTIfStmnt: (cond, code)")
        cond.print(i + 1)
        code.print(i + 1)
    }

    override fun getBlock(): ASTNodeArray<ASTNode> {
        return code
    }
}
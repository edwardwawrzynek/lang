package ast

class ASTForStmnt(loc: ASTFileLocation, internal var inital: ASTNode, internal var cond: ASTExpr, internal var end: ASTExpr, internal var code: ASTNodeArray<ASTNode>) : ASTNode(loc), ASTBlockStmnt {

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
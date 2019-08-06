package ast

class ASTElseStmnt(loc: ASTFileLocation, val code: ASTNodeArray<ASTNode>) : ASTNode(loc), ASTBlockStmnt {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTElseStmnt: ")
        code.print(i + 1)
    }

    override fun getBlock(): ASTNodeArray<ASTNode> {
        return code
    }
}
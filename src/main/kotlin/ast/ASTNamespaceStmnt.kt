package ast

class ASTNamespaceStmnt (loc: ASTFileLocation, val name: String, val body: ASTNodeArray<ASTNode>): ASTNode(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTNamespaceStmnt:")
        body.print(i+1)
    }
}
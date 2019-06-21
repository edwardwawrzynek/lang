package ast

class ASTFuncDecl(loc: ASTFileLocation, var name: String, var type: ASTFuncType, var body: ASTNodeArray<ASTNode>) : ASTNode(loc) {

    override fun print(i: Int) {
        printIndent(i)
        println("ASTFuncDecl: (name, type, body)")
        printIndent(i + 1)
        println(name)
        type.print(i + 1)
        body.print(i + 1)
    }

}
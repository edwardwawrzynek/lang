package ast

open class ASTType(loc: ASTFileLocation, var lit_type: String?) : ASTNode(loc) {

    override fun print(i: Int) {
        printIndent(i)
        print("ASTType: ")
        println(lit_type)
    }
}
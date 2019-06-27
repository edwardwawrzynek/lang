package ast

class ASTArrayType(loc: ASTFileLocation, lit_type: String, var length: Int) : ASTType(loc, lit_type) {

    override fun print(i: Int) {
        printIndent(i)
        print("ASTArrayType: ")
        print(lit_type)
        print("[")
        if (length != -1) {
            print(length)
        }
        println("]")
    }
}
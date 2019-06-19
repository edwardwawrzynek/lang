package ast

/* all ast nodes inherit from this */
open class ASTNode(/* start location in file */
        internal var loc: ASTFileLocation?) {

     open fun printIndent(i: Int) {
        for (n in 0 until i) {
            System.out.print("\t")
        }
    }

    open fun print(i: Int) {
        printIndent(i)
        System.out.println("ASTNode")
    }

}
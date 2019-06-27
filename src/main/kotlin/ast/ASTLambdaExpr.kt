package ast

import compiler.gen_unique_id

class ASTLambdaExpr(loc: ASTFileLocation, internal var type: ASTFuncType, internal var body: ASTNodeArray<ASTNode>) : ASTExpr(loc) {

    var enclosing_func: ASTNodeArray<ASTNode>? = null
    val id_num = gen_unique_id()

    override fun print(i: Int) {
        printIndent(i)
        println("ASTLambdaExpr: (type, body)")
        type.print(i + 1)
        body.print(i + 1)
    }

}
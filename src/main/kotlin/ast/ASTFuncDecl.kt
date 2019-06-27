package ast

import compiler.gen_unique_id

class ASTFuncDecl(loc: ASTFileLocation, var name: String, var type: ASTFuncType, var body: ASTNodeArray<ASTNode>) : ASTNode(loc) {

    var enclosing_func: ASTNodeArray<ASTNode>? = null
    val id_num = gen_unique_id()

    fun getEmitName(): String {
        if(enclosing_func == null){
            return name
        } else {
            return "_nested_func_$id_num"
        }
    }

    override fun print(i: Int) {
        printIndent(i)
        println("ASTFuncDecl: (name, type, body)")
        printIndent(i + 1)
        println(name)
        type.print(i + 1)
        body.print(i + 1)
    }

}
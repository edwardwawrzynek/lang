package ast

import ast.ASTNode
import compiler.*

class ASTNodeArray<T>(var nodes: MutableList<T>) : ASTNode(null) {
    var scope = SymbolTable(null)
    var ret_type: Type = InferredType() /* return type of function node arrays needed for type checking */
    var decld_ret_type: Type? = null
    /* if this is a function body, how many _lang_temp_this locals we need */
    var temp_this_num: Long = 0

    /* Function in which this node array is contained */
    var fun_scope: ASTNodeArray<ASTNode>? = null
    /* Function in which the function containing this array is contained */
    var higher_fun_scope: ASTNodeArray<ASTNode>? = null
    /* if the block contains code only to be treated as a prototype declaration and not actually emitted */
    var is_proto_decl = false

    fun setParentScope(pscope: SymbolTable?) {
        scope.parent = pscope
    }

    override fun print(i: Int) {
        for (n in 0 until i) {
            print("\t")
        }
        println("ASTNodeArray:")
        for (n in nodes.indices) {
            (nodes[n] as ASTNode).print(i + 1)
        }
    }
}
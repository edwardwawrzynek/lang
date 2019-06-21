package ast

import ast.ASTNode
import compiler.*

class ASTNodeArray<T>(var nodes: MutableList<T>) : ASTNode(null) {
    var scope = SymbolTable(null)

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
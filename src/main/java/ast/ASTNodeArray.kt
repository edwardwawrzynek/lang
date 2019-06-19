package ast

import ast.ASTNode

class ASTNodeArray<T>(var nodes: MutableList<T>) : ASTNode(null) {

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
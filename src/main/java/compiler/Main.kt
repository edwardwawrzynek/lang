package compiler

import parser.*
import org.antlr.v4.runtime.*

import java.io.FileInputStream
import java.io.FileReader
import java.io.InputStreamReader
import java.io.BufferedReader

object Main {
    var fileName: String = "test1.txt"
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val fileInput = BufferedReader(FileReader("test1.txt"))
        val `in` = CharStreams.fromReader(fileInput)
        val lexer = LangLexer(`in`)
        val tokens = CommonTokenStream(lexer)
        val parser = LangParser(tokens)
        val tree = parser.program()
        val visitor = CSTToASTVisitor()
        visitor.visitProgram(tree).print(0)
    }

}
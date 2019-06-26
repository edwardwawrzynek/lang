package compiler

import parser.*
import org.antlr.v4.runtime.*
import java.io.*

/* SymbolTable mapping class names to types (class type contains internal hasmap for fields) */
var classTable = SymbolTable(null)

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

        val program = visitor.visitProgram(tree)
        program.print(0)

        astToClassNames(program, classTable)
        astToClassTypes(program, classTable)

        val emit = Emit(FileWriter("out.c"))

        classTableEmitShapeDecl(emit, classTable)

        val ast_visitor = ASTVisitor()

        ast_visitor.visitASTNodeArray(program, null, null, classTable)

        emit.close()

    }

}
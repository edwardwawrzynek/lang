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

        emit.write("/* --- Output generated by lang compiler. Do Not Edit --- */\n#include \"lang_runtime.h\"\n\n")
        classTableEmitShapeDecl(emit, classTable)

        val ast_visitor = ASTSymbolConstructVisitor()

        emit.write("/* --- Function Headers --- */\n")
        ast_visitor.visitASTNodeArray(program, null, null, classTable, emit)

        emit.write("/* --- Program Body --- */\n")
        val type_visitor =  ASTTypeCheckVisitor()

        type_visitor.visitASTNodeArray(program, emit)
        emit.close()

    }

}
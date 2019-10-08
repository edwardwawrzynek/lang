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

        astToClassNames(program, classTable, null)
        astToClassTypes(program, classTable, null)

        val emit = FileEmit(FileWriter("c_out/out.c"))

        emit.write("/* --- Output generated by lang compiler. Do Not Edit --- */\n#include \"core/core.h\"\n\n")
        classTableEmitShapeDecl(emit, classTable, mutableListOf())
        val type_visitor =  ASTTypeCheckVisitor()
        val ast_visitor = ASTSymbolConstructVisitor()

        ast_visitor.visitASTNodeArray(program, null, null, classTable, Namespace(null, "", program.scope), emit)

        //classTableEmitVtableInstances(emit, classTable)
        

        type_visitor.visitASTNodeArray(program, Namespace(null, "", program.scope), emit)
        type_visitor.emitMainFunc(program, Namespace(null, "", program.scope), classTable, emit)
        emit.close()

    }

}
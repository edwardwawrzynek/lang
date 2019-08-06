package ast

import java.io.*

import compiler.Main
import org.antlr.v4.runtime.*

class ASTFileLocation(val line_num: Int, val line_pos: Int, val fileName: String) {

    fun print() {
        try {
            val file = BufferedReader(FileReader(fileName))
            for (i in 0 until line_num - 1) {
                file.readLine()
            }
            val line = file.readLine()
            System.out.println(line)

            for (i in 0 until line_pos) {
                if (line[i] == '\t') {
                    System.out.print("\t")
                } else {
                    System.out.print(" ")
                }
            }
            System.out.println("^")


        } catch (err: IOException) {
            System.out.println("IOException")
        }

    }

    companion object {

        fun fromToken(n: Token): ASTFileLocation {
            return ASTFileLocation(n.line.toInt(), n.charPositionInLine.toInt(), Main.fileName)
        }
    }
}

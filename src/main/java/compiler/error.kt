package compiler

import ast.ASTFileLocation

fun error(msg: String, loc: ASTFileLocation?) {
    if(loc == null) {
        print("An error occured at a null location:")
    } else {
        print(String.format("An error occurred in file '%s', line %d:%d:\n", loc.fileName, loc.line_num, loc.line_pos + 1))
    }

    loc?.print()

    println(msg)
    System.exit(0)
}
package compiler

import ast.ASTFileLocation

var current_id: Int = 0

fun genUniqueId(): Int {
    current_id++
    return current_id
}

fun compilerError(msg: String, loc: ASTFileLocation?) {
    print("\u001B[31m")
    if(loc == null) {
        println("An error occurred at a null location:\n")
    } else {
        print(String.format("An error occurred in file '%s', line %d:%d:\n", loc.fileName, loc.line_num, loc.line_pos + 1))
    }

    loc?.print()

    print(msg)
    println("\u001B[0m")
    System.exit(0)
}

fun warning(msg: String, loc: ASTFileLocation?) {
    print("\u001B[33m")
    if(loc == null) {
        println("A warning occurred at a null location:\n")
    } else {
        print(String.format("A warning occurred in file '%s', line %d:%d:\n", loc.fileName, loc.line_num, loc.line_pos + 1))
    }

    loc?.print()

    print(msg)
    println("\u001B[0m")
}
package compiler

import ast.ASTFileLocation
import kotlin.system.exitProcess

var current_id: Int = 0
var lang_temp_this_level = 0

fun genUniqueId(): Int {
    current_id++
    return current_id
}

fun namespaceAppend(name: String, add: String): String {
    if(name == ""){
        return add
    } else {
        return "${name}__$add"
    }
}

fun compilerError(msg: String, loc: ASTFileLocation?): Nothing {
    print("\u001B[31m")
    if(loc == null) {
        println("An error occurred at a null location:\n")
    } else {
        print(String.format("An error occurred in file '%s', line %d:%d:\n", loc.fileName, loc.line_num, loc.line_pos + 1))
    }

    loc?.print()

    print(msg)
    println("\u001B[0m")
    exitProcess(0)
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
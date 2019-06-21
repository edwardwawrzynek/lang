package compiler

import java.io.FileWriter

/* handles emitting output, output files, packages, name prefixing, etc */
class Emit (var file: FileWriter){
    fun write(msg: String) {
        file.write(msg)
    }

    /* emit an identifier in the current package (TODO: prefix with package name) */
    fun writeID(name: String) {
        /* try not to conflict with c namespace */
        write("__")
        write(name)
    }

    fun close() {
        file.close()
    }
}
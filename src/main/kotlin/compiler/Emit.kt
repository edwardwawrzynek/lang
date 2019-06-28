package compiler

import java.io.FileWriter

/* handles emitting output, output files, packages, name prefixing, etc */

interface Emit {
    fun write(msg: String)
    fun getID(name: String): String
    fun close()
}

class FileEmit (var file: FileWriter): Emit {
    override fun write(msg: String) {
        file.write(msg)
    }

    /* emit an identifier in the current package (TODO: prefix with package name) */
    override fun getID(name: String): String {
        /* try not to conflict with c namespace */
        return "__$name";
    }

    override fun close() {
        file.close()
    }
}

class DummyEmit: Emit {
    override fun write(msg: String) {
    }

    /* emit an identifier in the current package (TODO: prefix with package name) */
    override fun getID(name: String): String {
        /* try not to conflict with c namespace */
        return "__$name";
    }

    override fun close() {
    }
}
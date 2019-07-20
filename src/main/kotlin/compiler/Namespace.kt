package compiler

class Namespace (val parent: Namespace?, val name: String, val table: SymbolTable): Type() {
    fun getPrefix(): String {
        if(parent != null && parent.getPrefix() != "") {
            return "${parent.getPrefix()}__$name"
        } else {
            return name
        }
    }

    fun getName(name: String, emit: Emit): String {
        if(getPrefix() == "") {
            return emit.getID(name)
        } else {
            return "${emit.getID(getPrefix())}__$name"
        }
    }
}
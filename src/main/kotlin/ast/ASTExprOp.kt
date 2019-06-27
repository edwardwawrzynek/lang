package ast

class ASTExprOp(loc: ASTFileLocation, var type: ExprType, var left: ASTExpr?, var right: ASTExpr?) : ASTExpr(loc) {

    /* if the expr has one or two operands */
    var is_unary: Boolean = false

    enum class ExprType {
        POSTFIX_INC,
        POSTFIX_DEC,
        PREFIX_INC,
        PREFIX_DEC,
        NEGATIVE,
        LOGICAL_NOT,
        BINARY_NOT,
        MULT,
        DIV,
        MOD,
        ADD,
        SUB,
        LSHFT,
        RSHFT,
        LT,
        LTE,
        GT,
        GTE,
        EQ,
        NEQ,
        BINARY_AND,
        BINARY_OR,
        BINARY_XOR,
        LOGICAL_AND,
        LOGICAL_OR

    }

    init {
        is_unary = false

        if (type == ExprType.PREFIX_DEC || type == ExprType.PREFIX_INC
                || type == ExprType.POSTFIX_DEC || type == ExprType.POSTFIX_INC
                || type == ExprType.NEGATIVE || type == ExprType.LOGICAL_NOT
                || type == ExprType.BINARY_NOT) {
            is_unary = true
        }
    }

    override fun print(i: Int) {
        printIndent(i)
        print("ASTExprOp: ")
        println(type)
        if (left != null) {
            left!!.print(i + 1)
        }
        if (right != null) {
            right!!.print(i + 1)
        }
    }
}
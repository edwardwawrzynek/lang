package ast

class ASTExprOp(loc: ASTFileLocation, val type: ExprType, val left: ASTExpr, val right: ASTExpr?) : ASTExpr(loc) {

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
        BINARY_AND,
        BINARY_OR,
        BINARY_XOR,
        LOGICAL_AND,
        LOGICAL_OR,
        ARRAY;

        companion object {
            fun isUnary(type: ExprType): Boolean {
                return(type == PREFIX_DEC || type == PREFIX_INC
                        || type == POSTFIX_DEC || type == POSTFIX_INC
                        || type == NEGATIVE || type == LOGICAL_NOT
                        || type == BINARY_NOT)
            }

            /* logical ops require args converted to boolean first */
            fun isLogical(type: ExprType): Boolean {
                return type == LOGICAL_NOT || type == LOGICAL_AND || type == LOGICAL_OR
            }

            fun isNotOverridable(type: ExprType): Boolean {
                return isLogical(type) || type == EQ
            }
        }
    }

    init {
        is_unary = ExprType.isUnary(type)
    }

    override fun print(i: Int) {
        printIndent(i)
        print("ASTExprOp: ")
        println(type)
        left.print(i + 1)
        right?.print(i + 1)
    }

    override fun isLValue(): Boolean {
        return type == ExprType.ARRAY
    }
}
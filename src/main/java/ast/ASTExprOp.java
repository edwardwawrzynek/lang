package ast;

public class ASTExprOp extends ASTExpr {

    public enum ExprType {
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

    /* if the expr has one or two operands */
    public boolean is_unary;

    public ASTExpr left;
    public ASTExpr right;
    public ExprType type;

    public ASTExprOp(ASTFileLocation loc, ExprType type, ASTExpr left, ASTExpr right){
        super(loc);
        this.left = left;
        this.right = right;
        is_unary = false;
        this.type = type;

        if(type == ExprType.PREFIX_DEC || type == ExprType.PREFIX_INC
                || type == ExprType.POSTFIX_DEC || type == ExprType.POSTFIX_INC
                || type == ExprType.NEGATIVE || type == ExprType.LOGICAL_NOT
                || type == ExprType.BINARY_NOT){
            is_unary = true;
        }
    }

    public void print(int i){
        printIndent(i);
        System.out.print("ASTExprOp: ");
        System.out.println(type);
        if(left != null){
            left.print(i+1);
        }
        if(right != null){
            right.print(i+1);
        }
    }
}
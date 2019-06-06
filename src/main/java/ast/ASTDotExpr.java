package ast;

public class ASTDotExpr extends ASTExpr {
    public ASTExpr left;
    public ASTExpr right;

    public ASTDotExpr(ASTFileLocation loc, ASTExpr left, ASTExpr right){
        super(loc);
        this.left = left;
        this.right = right;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTDotExpr:");
        left.print(i+1);
        right.print(i+1);
    }
}
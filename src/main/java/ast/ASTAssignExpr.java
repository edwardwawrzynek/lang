package ast;

public class ASTAssignExpr extends ASTExpr {

    public ASTExpr lvalue;
    public ASTExpr rvalue;

    public ASTAssignExpr(ASTFileLocation loc, ASTExpr left, ASTExpr right){
        super(loc);
        lvalue = left;
        rvalue = right;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTAssignExpr:");
        lvalue.print(i+1);
        rvalue.print(i+1);
    }
}
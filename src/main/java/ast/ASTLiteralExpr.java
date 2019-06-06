package ast;

public class ASTLiteralExpr extends ASTExpr {
    String val;

    public ASTLiteralExpr(ASTFileLocation loc, String val){
        super(loc);
        this.val = val;
    }

    public void print(int i){
        printIndent(i);
        System.out.print("ASTLiteralExpr: ");
        System.out.println(val);
    }
}
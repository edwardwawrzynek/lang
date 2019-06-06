package ast;

public class ASTExpr extends ASTNode {

    public ASTExpr(ASTFileLocation loc){
        super(loc);
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTExpr");
    }
}
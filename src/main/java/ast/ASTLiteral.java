package ast;

public class ASTLiteral extends ASTNode {
    String val;

    public ASTLiteral(String val){
        this.val = val;
    }
}
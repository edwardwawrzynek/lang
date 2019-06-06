package ast;

public class ASTLiteral extends ASTNode {
    String val;

    public ASTLiteral(ASTFileLocation loc, String val){
        super(loc);
        this.val = val;
    }
}
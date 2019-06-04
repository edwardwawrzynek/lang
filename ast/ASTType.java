package ast;

public class ASTType extends ASTNode {
    String lit_type;

    public ASTType(String lit_type){
        this.lit_type = lit_type;
    }
}
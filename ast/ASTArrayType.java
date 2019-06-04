package ast;

public class ASTArrayType extends ASTType {
    int length;

    public ASTArrayType(String lit_type, int length){
        super(lit_type);
        this.length = length;
    }
}
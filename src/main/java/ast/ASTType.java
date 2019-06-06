package ast;

public class ASTType extends ASTNode {
    String lit_type;

    public ASTType(ASTFileLocation loc, String lit_type){
        super(loc);
        this.lit_type = lit_type;
    }

    public void print(int i){
        printIndent(i);
        System.out.print("ASTType: ");
        System.out.println(lit_type);
    }
}
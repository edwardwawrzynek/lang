package ast;

public class ASTArrayType extends ASTType {
    int length;

    public ASTArrayType(ASTFileLocation loc, String lit_type, int length){
        super(loc, lit_type);
        this.length = length;
    }

    public void print(int i){
        printIndent(i);
        System.out.print("ASTArrayType: ");
        System.out.print(lit_type);
        System.out.print("[");
        if(length != -1){
            System.out.print(length);
        }
        System.out.println("]");
    }
}
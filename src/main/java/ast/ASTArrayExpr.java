package ast;

public class ASTArrayExpr extends ASTExpr {
    public ASTExpr array;
    public ASTExpr subscript;

    public ASTArrayExpr(ASTFileLocation loc, ASTExpr array, ASTExpr subscript){
        super(loc);
        this.array = array;
        this.subscript = subscript;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTArrayExpr: (array, subscript):");
        array.print(i+1);
        subscript.print(i+1);
    }
}
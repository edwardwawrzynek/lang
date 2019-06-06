package ast;

public class ASTVarExpr extends ASTExpr {
    String name;

    public ASTVarExpr(ASTFileLocation loc, String name){
        super(loc);
        this.name = name;
    }

    public void print(int i){
        printIndent(i);
        System.out.print("ASTVarExpr: ");
        System.out.println(name);

    }
}
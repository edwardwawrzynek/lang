package ast;

public class ASTVarDecl extends ASTExpr{

    public enum VarMut {
        MUT, IMUT
    }

    public String name;
    public ASTType type;
    public ASTExpr init_val;
    public VarMut mutable;

    
    public ASTVarDecl(ASTFileLocation loc, String name, ASTType type, ASTExpr init_val, VarMut mutable){
        super(loc);
        this.name = name;
        this.type = type;
        this.init_val = init_val;
        this.mutable = mutable;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTVarDecl: (name, mutable, type, init_val)");
        printIndent(i+1);
        System.out.println(name);
        printIndent(i+1);
        System.out.println(mutable);
        if(type!=null){
            type.print(i+1);
        } else {
            printIndent(i+1);
            System.out.println("null"); 
        }
        if(init_val != null){
            init_val.print(i+1);
        } else {
            printIndent(i+1);
            System.out.println("null"); 
        }
    }
}
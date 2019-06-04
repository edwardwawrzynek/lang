package ast;

public class ASTVarDecl extends ASTNode {

    public enum VarMut {
        MUT, IMUT
    }

    String name;
    ASTType type;
    ASTExpr init_val;
    VarMut mutable;

    
    public ASTVarDecl(String name, ASTType type, ASTExpr init_val, VarMut mutable){
        this.name = name;
        this.type = type;
        this.init_val = init_val;
        this.mutable = mutable;
    }
}
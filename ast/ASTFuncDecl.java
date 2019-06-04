package ast;

public class ASTFuncDecl extends ASTNode {
    String name;
    ASTFuncType type;
    ASTNodeArray<ASTNode> body;

    public ASTFuncDecl(String name, ASTFuncType type, ASTNodeArray<ASTNode> body){
        this.name = name;
        this.type = type;
        this.body = body;
    }

}
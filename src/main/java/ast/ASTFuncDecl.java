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

    public void print(int i){
        printIndent(i);
        System.out.println("ASTFuncDecl: (name, type, body)");
        printIndent(i+1);
        System.out.println(name);
        type.print(i+1);
        body.print(i+1);
    }

}
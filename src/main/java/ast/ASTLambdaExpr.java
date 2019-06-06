package ast;

public class ASTLambdaExpr extends ASTExpr {
    ASTFuncType type;
    ASTNodeArray<ASTNode> body;

    public ASTLambdaExpr(ASTFileLocation loc, ASTFuncType type, ASTNodeArray<ASTNode> body){
        super(loc);
        this.type = type;
        this.body = body;
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTLambdaExpr: (type, body)");
        type.print(i+1);
        body.print(i+1);
    }

}
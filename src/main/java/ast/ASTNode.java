package ast;

/* all ast nodes inherit from this */
public class ASTNode {

    void printIndent(int i){
        for(var n = 0; n < i; n++){
            System.out.print("\t");
        }
    }

    public void print(int i){
        printIndent(i);
        System.out.println("ASTNode");
    }

}
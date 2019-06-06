package ast;

import ast.ASTNode;
import java.util.List;

public class ASTNodeArray<T> extends ASTNode {
    public List<T> nodes;
    public ASTNodeArray(List<T> nodes){
        super(null);
        this.nodes = nodes;
    }

    public void print(int i){
        for(var n=0;n<i;n++){
            System.out.print("\t");
        }
        System.out.println("ASTNodeArray:");
        for(var n = 0; n < nodes.size(); n++){
            ((ASTNode)nodes.get(n)).print(i+1);
        }
    }
}
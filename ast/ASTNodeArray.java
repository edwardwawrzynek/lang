package ast;

import ast.ASTNode;
import java.util.List;

public class ASTNodeArray<T> extends ASTNode {
    public List<T> nodes;
    public ASTNodeArray(List<T> nodes){
        this.nodes = nodes;
    }
}
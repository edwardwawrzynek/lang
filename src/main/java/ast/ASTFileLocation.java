package ast;

import java.io.*;

import compiler.Main;
import org.antlr.v4.runtime.*;

public class ASTFileLocation {
    public long line_num;
    public long line_pos;
    public String fileName;

    public ASTFileLocation(long line, long pos, String fileName){
        line_num = line;
        line_pos = pos;
        this.fileName = fileName;
    }

    public static ASTFileLocation fromToken(Token n){
        var l = new ASTFileLocation(n.getLine(), n.getCharPositionInLine(), Main.fileName);
        return l;
    }

    public void print(){
        try {
            var file = new BufferedReader(new FileReader(fileName));
            for(var i = 0; i < line_num-1; i++){
                file.readLine();
            }
            String line = file.readLine();
            System.out.println(line);

            for(var i = 0; i < line_pos; i++){
                if(line.charAt(i) == '\t'){
                    System.out.print("\t");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("^");


        } catch (IOException err){
            System.out.println("IOException");
        }

    }
}

import org.antlr.v4.runtime.*;

public class Main {
    public static void main(String args[]) throws Exception{
        ANTLRFileStream in = new ANTLRFileStream(args[0]);
        LangLexer lexer = new LangLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LangParser parser = new LangParser(tokens);
        LangParser.ProgramContext tree = parser.program();
        CSTToASTVisitor visitor = new CSTToASTVisitor();
        System.out.println(visitor.visitProgram(tree));
    }
}
/*
internal class Program
{
    private static void Main()
    {
        while (true)
        {
            Console.Write("> ");
            var exprText = Console.ReadLine();

            if (string.IsNullOrWhiteSpace(exprText))
                break;

            var inputStream = new AntlrInputStream(new StringReader(exprText));
            var lexer = new MathLexer(inputStream);
            var tokenStream = new CommonTokenStream(lexer);
            var parser = new MathParser(tokenStream);

            try
            {
                var cst = parser.compileUnit();
                var ast = new BuildAstVisitor().VisitCompileUnit(cst);
                var value = new EvaluateExpressionVisitor().Visit(ast);

                Console.WriteLine("= {0}", value);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            Console.WriteLine();
        }
    }
}
*/
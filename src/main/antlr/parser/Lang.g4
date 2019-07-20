grammar Lang;

@header{
	package parser;
}

@parser::members {
    /**
     * Based on code from antlr4 golang grammar https://github.com/antlr/grammars-v4
     * Returns true iff on the current index of the parser's
     * token stream a token exists on the HIDDEN channel which
     * either is a line terminator, or is a multi line comment that
     * contains a line terminator.
	 */

    private boolean lineTerminatorAhead() {
        // Get the token ahead of the current index.
        int possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 1;
        Token ahead = _input.get(possibleIndexEosToken);
        if (ahead.getChannel() != Lexer.HIDDEN) {
            // We're only interested in tokens on the HIDDEN channel.
            return false;
        }

        if (ahead.getType() == TERMINATOR) {
            // There is definitely a line terminator ahead.
            return true;
        }

        if (ahead.getType() == WS) {
            // Get the token ahead of the current whitespaces.
            possibleIndexEosToken = this.getCurrentToken().getTokenIndex() - 2;
            ahead = _input.get(possibleIndexEosToken);
        }

        // Get the token's text and type.
        String text = ahead.getText();
        int type = ahead.getType();

        // Check if the token is, or contains a line terminator.
        return (type == COMMENT && (text.contains("\r") || text.contains("\n"))) ||
                (type == TERMINATOR);

    }
}

program
    :   statement* EOF
    ;

expr
    :   '(' expr ')'                                #parenExpr
	|   varName=expr '.' sub=expr                   #dotExpr
    |   name=expr '(' args=funcArgsExpr ')'         #funcExpr
    |   varName=expr '[' sub=expr ']'               #arrayExpr
    |   varName=expr op=('++'|'--')                 #postfixExpr
    |   'fn' varName=funcBody                       #lambdaExpr

    |   op=('++'|'--') varName=expr                 #prefixExpr
    |   op=('+'|'-') varName=expr                   #prefixExpr
    |   op=('!'|'~') varName=expr                   #prefixExpr

    |   left=expr op=('*'|'/'|'%') right=expr       #infixExpr
    |   left=expr op=('+'|'-') right=expr           #infixExpr

    |   left=expr op=('<<'|'>>') right=expr         #infixExpr

    |   left=expr op=('<'|'<='|'>'|'>=') right=expr #infixExpr

    |   left=expr op=('=='|'!=') right=expr         #infixExpr

    |   left=expr op='&' right=expr                 #infixExpr
    |   left=expr op='|' right=expr                 #infixExpr
    |   left=expr op='^' right=expr                 #infixExpr

    |   left=expr op='&&' right=expr                #infixExpr
    |   left=expr op='||' right=expr                #infixExpr

    |   left=expr op=('='|'+='|'-='|'*='|'/='|'%='|'<<='|'>>='|'&='|'^='|'|=') right=expr   #assignmentExpr

    |   literal                                     #literalExpr
    |   ID                                          #idExpr
    ;

funcArgsExpr
    : (expr ',')* expr?
    ;

block
    : ('{' (statement)* '}') | statement
    ;

arrayDecl
    : '[' ']'
    ;

typeDecl
    : (array=arrayDecl)? (ID|funcType)
    ;

varType
    : (name=ID ',')* (name=ID)? ':' (typeName=typeDecl)?
    ;

funcArgVarType
    : (mut=('var'|'val'))? (name=ID ',')* (name=ID)? ':' typeName=typeDecl
    ;

varInit
    : (expr ',')* expr?
    ;

varDecl
    : (mut=('var'|'val'))? typeName=varType ('=' init=varInit)?
    ;

funcArgDecl
    : (funcArgVarType ',')* funcArgVarType?
    ;

funcType
    : '(' args=funcArgDecl ')' '->' retType=typeDecl
    ;

funcTypeWithBody
	: ('(' args=funcArgDecl ')')? ('->' retType=typeDecl)?
	;

funcBody
    : typeName=funcTypeWithBody code=block
    ;

funcDecl
    : 'fn' name=ID function=funcBody
    ;

classDecl
    : classType=('class'|'object'|'struct') name=ID (':' parentClass=ID)? body=block
    ;

forFirstExpr
    : (expr|varDecl)
    ;

statement
    : 'if' (('(' cond=expr ')')|(cond=expr)) code=block            	#ifStmnt
    | 'elsif' (('(' cond=expr ')')|(cond=expr)) code=block          #elseIfStmnt
    | 'else' code=block                                             #elseStmnt
    | 'while' (('(' cond=expr ')')|(cond=expr)) code=block          #whileStmnt
    | 'do' code=block 'while' (('(' cond=expr ')')|(cond=expr)) eos #doWhileStmnt
    | 'for' (('(' init=forFirstExpr ',' rep=expr ',' end=expr ')')
      |(init=forFirstExpr ',' rep=expr ',' end=expr)) code=block  	#forStmnt
    | ('return'|'=>') (val=expr)? eos                               #returnStmnt
    | 'continue' eos                                               	#continueStmnt
    | 'break' eos                                                  	#breakStmnt
    | function=funcDecl                                             #funcDeclStmnt
    | classType=classDecl                                           #classDeclStmnt
    | 'declare_proto' protos=block                                  #declareProtoStmnt
    | 'namespace' name=ID cont=block								#namespaceStmnt
	| decl=varDecl eos                                              #varDeclStmnt
    | expr eos                                                      #exprStmnt
    ;

OP_INC: '++';
OP_DEC: '--';
OP_DOT: '.';
OP_LNOT: '!';
OP_BNOT: '~';

OP_MUL: '*';
OP_DIV: '/';
OP_MOD: '%';
OP_LSH: '<<';
OP_RSH: '>>';
OP_LT: '<';
OP_LTE: '<=';
OP_GT: '>';
OP_GTE: '>=';
OP_EQ: '==';
OP_NEQ: '!=';

OP_BAND: '&';
OP_BOR: '|';
OP_BXOR: '^';

OP_LAND: '&&';
OP_LOR: '||';

OP_ADD: '+';
OP_SUB: '-';

OP_ASG: '=';
OP_ADD_ASG: '+=';
OP_SUB_ASG: '-=';
OP_MUL_ASG: '*=';
OP_DIV_ASG: '/=';
OP_MOD_ASG: '%=';
OP_LSH_ASG: '<<=';
OP_RSH_ASG: '>>=';
OP_BAND_ASG: '&=';
OP_BXOR_ASG: '^=';
OP_BOR_ASG: '|=';

CLASS_CLASS: 'class';
CLASS_OBJECT: 'object';
CLASS_STRUCT: 'struct';

literal
    :   NULL
    |	BOOL
    |	NUM
    | 	FLOAT
    |   STR
    |   CHR
    |   arrayLiteral
    ;

arrayLiteral: '[' (expr ',')* expr? ']';

BOOL: 	'true' | 'false';
NULL: 	'null';
NUM :   '-'?[0-9]+;
FLOAT: 	'-'?([0-9]*[.])?[0-9]+;
ID  :   [a-zA-Z_]+[a-zA-Z_0-9]*;
STR :   '"' (~'"')* '"';
CHR :   '\'' '\\'?(~'\'') '\'';

eos
    : ';'
    | EOF
    | {lineTerminatorAhead()}?
    | {_input.LT(1).getText().equals("}") }?
    ;

WS  :  [ \t]+ -> channel(HIDDEN);
COMMENT:   '/*' .*? '*/' -> channel(HIDDEN);
LINE_COMMENT: '//' ~[\n]* -> skip;
TERMINATOR: [\n]+ -> channel(HIDDEN);

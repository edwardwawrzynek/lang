grammar Lang;

@header{
	package parser;
}

program
    :   statement* EOF
    ;

expr
    :   '(' expr ')'                                #parenExpr
	|   varName=expr '.' sub=expr                   #dotExpr
    |   name=expr '(' args=funcArgsExpr ')'         #funcExpr
    |   varName=expr '[' sub=expr ']'                   #arrayExpr
    |   varName=expr op=('++'|'--')                        #postfixExpr
    |   varName=funcBody                                #lambdaExpr

    |   op=('++'|'--') varName=expr                     #prefixExpr
    |   op=('+'|'-') varName=expr                       #prefixExpr
    |   op=('!'|'~') varName=expr                       #prefixExpr

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
    : '{' (statement)* '}'
    ;

arrayDecl
    : '[' (size=NUM)? ']'
    ;

typeDecl
    : (array=arrayDecl)? (ID|funcType)
    ;

varType
    : (name=ID ','?)+ ':' (typeName=typeDecl)?
    ;

funcArgVarType
    : (mut=('var'|'val'))? (name=ID ','?)+ ':' typeName=typeDecl
    ;

varInit
    : (expr ','?)+
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
    : 'if' (('(' cond=expr ')')|(cond=expr)) code=block             #ifStmnt
    | 'elsif' (('(' cond=expr ')')|(cond=expr)) code=block           #elseIfStmnt
    | 'else' code=block                                             #elseStmnt
    | 'while' (('(' cond=expr ')')|(cond=expr)) code=block          #whileStmnt
    | 'do' code=block 'while' (('(' cond=expr ')')|(cond=expr)) '\n'                #doWhileStmnt
    | 'for' (('(' init=forFirstExpr ',' rep=expr ',' end=expr ')')|(init=forFirstExpr ',' rep=expr ',' end=expr)) code=block  #forStmnt
    | 'return' (val=expr)? '\n'                                     #returnStmnt
    | 'continue' '\n'                                               #continueStmnt
    | 'break' '\n'                                                  #breakStmnt
    | function=funcDecl                                             #funcDeclStmnt
    | classType=classDecl                                           #classDeclStmnt
    | 'declare_proto' protos=block                                  #declareProtoStmnt
    | expr '\n'                                                     #exprStmnt
    | decl=varDecl '\n'                                             #varDeclStmnt
    | '\n'                                                          #blankLineStmnt
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
    :   NUM
    |   STR
    |   CHR
    |   arrayLiteral
    ;

arrayLiteral: '[' (expr ',')* expr? ']';

NUM :   '-'?[0-9]+;
ID  :   [a-zA-Z_]+[a-zA-Z_0-9]*;
STR :   '"' (~'"')* '"';
CHR :   '\'' '\\'?(~'\'') '\'';
WS  :   [ \t\r] -> channel(HIDDEN);
COMMENT : '#' .*? '\n' -> channel(HIDDEN);
MULTICOMMENT : '##>' .*? '##<' -> channel(HIDDEN);

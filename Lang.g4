grammar Lang;

program
    :   statment* EOF
    ;

expr
    :   '(' expr ')'                                #parenExpr
    |   name=expr '(' args=funcArgsExpr ')'         #funcExpr
    |   var=expr '[' sub=expr ']'                   #arrayExpr
    |   var=expr '.' sub=expr                       #dotExpr
    |   var=expr ('++'|'--')                        #postfixExpr
    |   var=funcBody                                #lambdaExpr

    |   op=('++'|'--') var=expr                     #prefixExpr
    |   op=('+'|'-') var=expr                       #prefixExpr
    |   op=('!'|'~') var=expr                       #prefixExpr

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
    |   cond=expr '?' left=expr ':' right=expr      #ternaryExpr

    |   left=expr op=('='|'+='|'-='|'*='|'/='|'%='|'<<='|'>>='|'&='|'^='|'|=') right=expr   #assignmentExpr
    |	decl=varDecl                                #declExpr

    |   literal                                     #literalExpr
    |   ID                                          #idExpr
    ;

funcArgsExpr
    : (expr ',')* expr?
    ;

block
    : '{' (statment)* '}'
    ;

typeDecl
    : (ID|funcType) ('[' (size=literal)? ']' )?
    ;

varType
    : name=ID ':' type=typeDecl
    ;

varDecl
    : mut=('var'|'val') type=varType ('=' init=expr)?;

funcArgDecl
    : (varType ',')* varType?
    ;

funcType
    : ('(' args=funcArgDecl ')')? (':' retType=typeDecl)?
    ;

funcBody
    : type=funcType code=block
    ;

funcDecl
    : 'fn' name=ID func=funcBody
    ;

classDecl
    : type=('class'|'singelton'|'struct') name=ID (':' parent=ID)? body=block
    ;

statment
    : 'if' '(' cond=expr ')' code=block                             #ifStmnt
    | 'else' 'if' '(' cond=expr ')' code=block                      #elseIfStmnt
    | 'else' code=block                                             #elseStmnt
    | 'while' '(' cond=expr ')' code=block                          #whileStmnt
    | 'do' code=block 'while' '(' cond=expr ')' ';'                 #doWhileStmnt
    | 'for' '(' init=expr ';' rep=expr ';' end=expr ')' code=block  #forStmnt
    | 'return' val=expr ';'                                         #returnStmnt
    | 'continue' ';'                                                #continueStmnt
    | 'break' ';'                                                   #breakStmnt
    | func=funcDecl                                                 #funcDeclStmnt
    | classType=classDecl                                           #classDeclStmnt
    | expr ';'                                                      #exprStmnt
    | code=block                                                    #blockStmnt
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


literal
    :   NUM
    |   STR
    |   CHR
    ;

NUM :   [0-9]+;
ID  :   [a-zA-Z_]+[a-zA-Z_0-9]*;
STR :   '"' (~'"'|'"')* '"';
CHR :   '\'' '\\'?(~'\'') '\'';
WS  :   [ \t\r\n] -> channel(HIDDEN);
COMMENT : '#' .*? '\n' -> channel(HIDDEN);

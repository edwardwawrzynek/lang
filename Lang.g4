grammar Lang;

program
    :   statement* EOF
    ;

expr
    :   '(' expr ')'                                #parenExpr
    |   name=expr '(' args=funcArgsExpr ')'         #funcExpr
    |   varName=expr '[' sub=expr ']'                   #arrayExpr
    |   varName=expr '.' sub=expr                       #dotExpr
    |   varName=expr ('++'|'--')                        #postfixExpr
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
    : '{' (statement)* '}'
    ;

typeDecl
    : (ID|funcType) ('[' (size=literal)? ']' )?
    ;

varType
    : name=ID ':' typeName=typeDecl
    ;

varDecl
    : mut=('var'|'val') typeName=varType ('=' init=expr)?;

funcArgDecl
    : (varType ',')* varType?
    ;

funcType
    : ('(' args=funcArgDecl ')')? (':' retType=typeDecl)?
    ;

funcBody
    : typeName=funcType code=block
    ;

funcDecl
    : 'fn' name=ID function=funcBody
    ;

classDecl
    : classType=('class'|'singelton'|'struct') name=ID (':' parentClass=ID)? body=block
    ;

statement
    : 'if' '(' cond=expr ')' code=block                             #ifStmnt
    | 'else' 'if' '(' cond=expr ')' code=block                      #elseIfStmnt
    | 'else' code=block                                             #elseStmnt
    | 'while' '(' cond=expr ')' code=block                          #whileStmnt
    | 'do' code=block 'while' '(' cond=expr ')' ';'                 #doWhileStmnt
    | 'for' '(' init=expr ';' rep=expr ';' end=expr ')' code=block  #forStmnt
    | 'return' val=expr ';'                                         #returnStmnt
    | 'continue' ';'                                                #continueStmnt
    | 'break' ';'                                                   #breakStmnt
    | function=funcDecl                                             #funcDeclStmnt
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
    |   arrayLiteral
    ;

arrayLiteral: '[' (expr ',')* expr? ']';

NUM :   [0-9]+;
ID  :   [a-zA-Z_]+[a-zA-Z_0-9]*;
STR :   '"' (~'"'|'"')* '"';
CHR :   '\'' '\\'?(~'\'') '\'';
WS  :   [ \t\r\n] -> channel(HIDDEN);
COMMENT : '#' .*? '\n' -> channel(HIDDEN);

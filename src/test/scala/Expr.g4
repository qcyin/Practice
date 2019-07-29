grammar Expr;

prog : stat+;

stat
    : expr NEWLINE          # printExpr
    | ID '=' expr NEWLINE   # assign
    | NEWLINE               # blank
    ;

expr
    : expr MUL expr         # mul
    | expr DIV expr         # div
    | expr ADD expr         # add
    | expr SUB expr         # sub
    | number                # num
    | ID                    # key
    | '(' expr ')'          # parens
    ;

number
    : INT
    ;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
ID : [a-zA-Z]+ ;
INT : SUB? [0-9]+ ;
NEWLINE:'\r'? '\n' ;
WS : [ \t]+ -> skip;
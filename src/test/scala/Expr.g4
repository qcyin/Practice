grammar Expr;

prog : stat+;

stat
    : expr NEWLINE*          # printExpr
    | ID EQ expr NEWLINE    # assign
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
    : SUB? INT
    ;

EQ : '=' ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
ID : [a-zA-Z]+ ;
INT : [0-9]+ ;
NEWLINE:'\r'? '\n' ;
WS : [ \t]+ -> skip;
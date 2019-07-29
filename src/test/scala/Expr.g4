grammar Expr;

prog : stat+ EOF;

stat
    : expr NEWLINE*                 # printExpr
    | KEY EQ expr NEWLINE           # assign
    ;

expr
    : left=expr MUL right=expr      # mul
    | left=expr DIV right=expr      # div
    | left=expr ADD right=expr      # add
    | left=expr SUB right=expr      # sub
    | number                        # num
    | KEY                           # key
    | '(' expr ')'                  # parens
    ;

number
    : SUB? INT
    ;

EQ : '=' ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
KEY : [a-zA-Z]+ ;
INT : [0-9]+ ;
NEWLINE:'\r'? '\n' ;
WS : [ \t]+ -> skip;
grammar Expr;

prog : stat+ EOF;

stat
    : expr SEMICOLON                # printExpr
    | KEY EQ expr SEMICOLON         # assign
    ;

expr
    : left=expr MUL right=expr      # mul
    | left=expr DIV right=expr      # div
    | left=expr ADD right=expr      # add
    | left=expr SUB right=expr      # sub
    | number                        # base
    | KEY                           # key
    | '(' expr ')'                  # parens
    ;

number
    : SUB? INT
    ;

SEMICOLON : ';' ;
EQ : '=' ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
KEY : [a-zA-Z0-9]+ ;
INT : [0-9]+ ;
WS : [ \t\r\n]+ -> skip;
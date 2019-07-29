package com.com.yqc.gen;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class AntlrTest {
    public static void main(String[] args) {

        //https://www.cnblogs.com/sld666666/p/6145854.html

        String script = "1 + 2 + 3 * 4+ 6 / 2";

        script = "a=123-1;" + //122
                "b=a+3;" + //125
                "c=a*b;" + //15250
                "d=c+(4--6)*2;"; //15270





        ExprLexer lexer = new ExprLexer(CharStreams.fromString(script));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokenStream);
        parser.setErrorHandler(new BailErrorStrategy());
        ParseTree parseTree = parser.prog();
        ExprBaseVisitorExt visitor = new ExprBaseVisitorExt();
        Object rtn = visitor.visit(parseTree);
        System.out.println(rtn);
    }
}

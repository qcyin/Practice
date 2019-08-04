package com.com.yqc.gen;

import java.util.HashMap;
import java.util.Map;

public class ExprBaseVisitorExt extends ExprBaseVisitor<Double> {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private Map<String,Double> memory = new HashMap<>();

    @Override
    public Double visitProg(ExprParser.ProgContext ctx) {
        Double rs = null;
        int c = ctx.getChildCount();
        for(int i=0;i<c-1;i++){ //pass EOF
            rs = ctx.getChild(i).accept(this);
        }
        return rs;
    }

    @Override
    public Double visitPrintExpr(ExprParser.PrintExprContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Double visitAssign(ExprParser.AssignContext ctx) {
        String key = ctx.KEY().getText();
        Double value = visit(ctx.expr());
        memory.put(key, value);
        return value;
    }

    @Override
    public Double visitDiv(ExprParser.DivContext ctx) {
        Double l = visit(ctx.left);
        Double r = visit(ctx.right);
        return l/r;
    }

    @Override
    public Double visitAdd(ExprParser.AddContext ctx) {
        Double l = visit(ctx.left);
        Double r = visit(ctx.right);
        return l+r;
    }

    @Override
    public Double visitSub(ExprParser.SubContext ctx) {
        Double l = visit(ctx.left);
        Double r = visit(ctx.right);
        return l-r;
    }

    @Override
    public Double visitParens(ExprParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Double visitMul(ExprParser.MulContext ctx) {
        Double l = visit(ctx.left);
        Double r = visit(ctx.right);
        return l*r;
    }

    @Override
    public Double visitBase(ExprParser.BaseContext ctx) {
        return visit(ctx.number());
    }

    @Override
    public Double visitKey(ExprParser.KeyContext ctx) {
        String key = ctx.KEY().getText();
        return memory.getOrDefault(key,0.0);
    }

    @Override
    public Double visitNumber(ExprParser.NumberContext ctx) {
        return Double.valueOf(ctx.getText());
    }
}

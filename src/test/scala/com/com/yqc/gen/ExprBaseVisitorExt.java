package com.com.yqc.gen;

public class ExprBaseVisitorExt extends ExprBaseVisitor<Integer> {
    @Override
    public Integer visitProg(ExprParser.ProgContext ctx) {
        return super.visitProg(ctx);
    }

    @Override
    public Integer visitPrintExpr(ExprParser.PrintExprContext ctx) {
        return super.visitPrintExpr(ctx);
    }

    @Override
    public Integer visitAssign(ExprParser.AssignContext ctx) {
        return super.visitAssign(ctx);
    }

    @Override
    public Integer visitBlank(ExprParser.BlankContext ctx) {
        return super.visitBlank(ctx);
    }

    @Override
    public Integer visitDiv(ExprParser.DivContext ctx) {
        return super.visitDiv(ctx);
    }

    @Override
    public Integer visitAdd(ExprParser.AddContext ctx) {
        return super.visitAdd(ctx);
    }

    @Override
    public Integer visitSub(ExprParser.SubContext ctx) {
        return super.visitSub(ctx);
    }

    @Override
    public Integer visitParens(ExprParser.ParensContext ctx) {
        return super.visitParens(ctx);
    }

    @Override
    public Integer visitMul(ExprParser.MulContext ctx) {
        return super.visitMul(ctx);
    }

    @Override
    public Integer visitNum(ExprParser.NumContext ctx) {
        return super.visitNum(ctx);
    }

    @Override
    public Integer visitKey(ExprParser.KeyContext ctx) {
        return super.visitKey(ctx);
    }

    @Override
    public Integer visitNumber(ExprParser.NumberContext ctx) {
        return Integer.valueOf(ctx.getText());
    }
}

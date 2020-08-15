// generated with ast extension for cup
// version 0.8
// 15/7/2020 11:28:49


package rs.ac.bg.etf.pp1.ast;

public class Expr implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private ExprMinusPlus ExprMinusPlus;
    private ExprList ExprList;

    public Expr (ExprMinusPlus ExprMinusPlus, ExprList ExprList) {
        this.ExprMinusPlus=ExprMinusPlus;
        if(ExprMinusPlus!=null) ExprMinusPlus.setParent(this);
        this.ExprList=ExprList;
        if(ExprList!=null) ExprList.setParent(this);
    }

    public ExprMinusPlus getExprMinusPlus() {
        return ExprMinusPlus;
    }

    public void setExprMinusPlus(ExprMinusPlus ExprMinusPlus) {
        this.ExprMinusPlus=ExprMinusPlus;
    }

    public ExprList getExprList() {
        return ExprList;
    }

    public void setExprList(ExprList ExprList) {
        this.ExprList=ExprList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprMinusPlus!=null) ExprMinusPlus.accept(visitor);
        if(ExprList!=null) ExprList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprMinusPlus!=null) ExprMinusPlus.traverseTopDown(visitor);
        if(ExprList!=null) ExprList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprMinusPlus!=null) ExprMinusPlus.traverseBottomUp(visitor);
        if(ExprList!=null) ExprList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expr(\n");

        if(ExprMinusPlus!=null)
            buffer.append(ExprMinusPlus.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprList!=null)
            buffer.append(ExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Expr]");
        return buffer.toString();
    }
}

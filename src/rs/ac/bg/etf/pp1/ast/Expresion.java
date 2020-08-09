// generated with ast extension for cup
// version 0.8
// 9/7/2020 17:19:55


package rs.ac.bg.etf.pp1.ast;

public class Expresion extends Expr {

    private ExprMinusPlus ExprMinusPlus;
    private ExprList ExprList;

    public Expresion (ExprMinusPlus ExprMinusPlus, ExprList ExprList) {
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
        buffer.append("Expresion(\n");

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
        buffer.append(") [Expresion]");
        return buffer.toString();
    }
}

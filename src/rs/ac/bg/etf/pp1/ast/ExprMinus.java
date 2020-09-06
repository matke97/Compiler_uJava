// generated with ast extension for cup
// version 0.8
// 6/8/2020 2:52:6


package rs.ac.bg.etf.pp1.ast;

public class ExprMinus extends Expr {

    private MinusEx MinusEx;
    private ExprList ExprList;

    public ExprMinus (MinusEx MinusEx, ExprList ExprList) {
        this.MinusEx=MinusEx;
        if(MinusEx!=null) MinusEx.setParent(this);
        this.ExprList=ExprList;
        if(ExprList!=null) ExprList.setParent(this);
    }

    public MinusEx getMinusEx() {
        return MinusEx;
    }

    public void setMinusEx(MinusEx MinusEx) {
        this.MinusEx=MinusEx;
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
        if(MinusEx!=null) MinusEx.accept(visitor);
        if(ExprList!=null) ExprList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MinusEx!=null) MinusEx.traverseTopDown(visitor);
        if(ExprList!=null) ExprList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MinusEx!=null) MinusEx.traverseBottomUp(visitor);
        if(ExprList!=null) ExprList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprMinus(\n");

        if(MinusEx!=null)
            buffer.append(MinusEx.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprList!=null)
            buffer.append(ExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprMinus]");
        return buffer.toString();
    }
}

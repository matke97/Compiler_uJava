// generated with ast extension for cup
// version 0.8
// 6/8/2020 2:52:7


package rs.ac.bg.etf.pp1.ast;

public class CombinedOperationOne extends CombOperationFactor {

    private Designator Designator;
    private CombOperation CombOperation;
    private ExprList ExprList;

    public CombinedOperationOne (Designator Designator, CombOperation CombOperation, ExprList ExprList) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.CombOperation=CombOperation;
        if(CombOperation!=null) CombOperation.setParent(this);
        this.ExprList=ExprList;
        if(ExprList!=null) ExprList.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public CombOperation getCombOperation() {
        return CombOperation;
    }

    public void setCombOperation(CombOperation CombOperation) {
        this.CombOperation=CombOperation;
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
        if(Designator!=null) Designator.accept(visitor);
        if(CombOperation!=null) CombOperation.accept(visitor);
        if(ExprList!=null) ExprList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(CombOperation!=null) CombOperation.traverseTopDown(visitor);
        if(ExprList!=null) ExprList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(CombOperation!=null) CombOperation.traverseBottomUp(visitor);
        if(ExprList!=null) ExprList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CombinedOperationOne(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CombOperation!=null)
            buffer.append(CombOperation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprList!=null)
            buffer.append(ExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CombinedOperationOne]");
        return buffer.toString();
    }
}

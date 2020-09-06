// generated with ast extension for cup
// version 0.8
// 6/8/2020 2:52:6


package rs.ac.bg.etf.pp1.ast;

public class ExprCombined extends Expr {

    private CombOperationFactor CombOperationFactor;

    public ExprCombined (CombOperationFactor CombOperationFactor) {
        this.CombOperationFactor=CombOperationFactor;
        if(CombOperationFactor!=null) CombOperationFactor.setParent(this);
    }

    public CombOperationFactor getCombOperationFactor() {
        return CombOperationFactor;
    }

    public void setCombOperationFactor(CombOperationFactor CombOperationFactor) {
        this.CombOperationFactor=CombOperationFactor;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CombOperationFactor!=null) CombOperationFactor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CombOperationFactor!=null) CombOperationFactor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CombOperationFactor!=null) CombOperationFactor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprCombined(\n");

        if(CombOperationFactor!=null)
            buffer.append(CombOperationFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprCombined]");
        return buffer.toString();
    }
}

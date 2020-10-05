// generated with ast extension for cup
// version 0.8
// 16/8/2020 15:16:52


package rs.ac.bg.etf.pp1.ast;

public class DesigOperationCombAss extends DesigOperation {

    private CombOperation CombOperation;
    private Expr Expr;

    public DesigOperationCombAss (CombOperation CombOperation, Expr Expr) {
        this.CombOperation=CombOperation;
        if(CombOperation!=null) CombOperation.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public CombOperation getCombOperation() {
        return CombOperation;
    }

    public void setCombOperation(CombOperation CombOperation) {
        this.CombOperation=CombOperation;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CombOperation!=null) CombOperation.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CombOperation!=null) CombOperation.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CombOperation!=null) CombOperation.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesigOperationCombAss(\n");

        if(CombOperation!=null)
            buffer.append(CombOperation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesigOperationCombAss]");
        return buffer.toString();
    }
}

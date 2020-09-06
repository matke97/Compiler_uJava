// generated with ast extension for cup
// version 0.8
// 6/8/2020 2:52:7


package rs.ac.bg.etf.pp1.ast;

public class CombOperationFactorRecursive extends CombOperationFactor {

    private Designator Designator;
    private CombOperation CombOperation;
    private CombOperationFactor CombOperationFactor;

    public CombOperationFactorRecursive (Designator Designator, CombOperation CombOperation, CombOperationFactor CombOperationFactor) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.CombOperation=CombOperation;
        if(CombOperation!=null) CombOperation.setParent(this);
        this.CombOperationFactor=CombOperationFactor;
        if(CombOperationFactor!=null) CombOperationFactor.setParent(this);
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
        if(Designator!=null) Designator.accept(visitor);
        if(CombOperation!=null) CombOperation.accept(visitor);
        if(CombOperationFactor!=null) CombOperationFactor.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(CombOperation!=null) CombOperation.traverseTopDown(visitor);
        if(CombOperationFactor!=null) CombOperationFactor.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(CombOperation!=null) CombOperation.traverseBottomUp(visitor);
        if(CombOperationFactor!=null) CombOperationFactor.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CombOperationFactorRecursive(\n");

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

        if(CombOperationFactor!=null)
            buffer.append(CombOperationFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CombOperationFactorRecursive]");
        return buffer.toString();
    }
}

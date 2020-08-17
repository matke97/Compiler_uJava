// generated with ast extension for cup
// version 0.8
// 17/7/2020 21:38:34


package rs.ac.bg.etf.pp1.ast;

public class DesignStatment extends DesignatorStatement {

    private Designator Designator;
    private DesigOperation DesigOperation;

    public DesignStatment (Designator Designator, DesigOperation DesigOperation) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.DesigOperation=DesigOperation;
        if(DesigOperation!=null) DesigOperation.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public DesigOperation getDesigOperation() {
        return DesigOperation;
    }

    public void setDesigOperation(DesigOperation DesigOperation) {
        this.DesigOperation=DesigOperation;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(DesigOperation!=null) DesigOperation.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(DesigOperation!=null) DesigOperation.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(DesigOperation!=null) DesigOperation.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignStatment(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesigOperation!=null)
            buffer.append(DesigOperation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignStatment]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 1/8/2020 15:50:37


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatement implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private DesignatorLeft DesignatorLeft;
    private DesigOperation DesigOperation;

    public DesignatorStatement (DesignatorLeft DesignatorLeft, DesigOperation DesigOperation) {
        this.DesignatorLeft=DesignatorLeft;
        if(DesignatorLeft!=null) DesignatorLeft.setParent(this);
        this.DesigOperation=DesigOperation;
        if(DesigOperation!=null) DesigOperation.setParent(this);
    }

    public DesignatorLeft getDesignatorLeft() {
        return DesignatorLeft;
    }

    public void setDesignatorLeft(DesignatorLeft DesignatorLeft) {
        this.DesignatorLeft=DesignatorLeft;
    }

    public DesigOperation getDesigOperation() {
        return DesigOperation;
    }

    public void setDesigOperation(DesigOperation DesigOperation) {
        this.DesigOperation=DesigOperation;
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
        if(DesignatorLeft!=null) DesignatorLeft.accept(visitor);
        if(DesigOperation!=null) DesigOperation.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorLeft!=null) DesignatorLeft.traverseTopDown(visitor);
        if(DesigOperation!=null) DesigOperation.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorLeft!=null) DesignatorLeft.traverseBottomUp(visitor);
        if(DesigOperation!=null) DesigOperation.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatement(\n");

        if(DesignatorLeft!=null)
            buffer.append(DesignatorLeft.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesigOperation!=null)
            buffer.append(DesigOperation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatement]");
        return buffer.toString();
    }
}

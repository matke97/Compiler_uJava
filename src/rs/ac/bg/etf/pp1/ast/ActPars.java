// generated with ast extension for cup
// version 0.8
// 17/7/2020 23:35:16


package rs.ac.bg.etf.pp1.ast;

public class ActPars implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ActualParamList ActualParamList;

    public ActPars (ActualParamList ActualParamList) {
        this.ActualParamList=ActualParamList;
        if(ActualParamList!=null) ActualParamList.setParent(this);
    }

    public ActualParamList getActualParamList() {
        return ActualParamList;
    }

    public void setActualParamList(ActualParamList ActualParamList) {
        this.ActualParamList=ActualParamList;
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
        if(ActualParamList!=null) ActualParamList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActualParamList!=null) ActualParamList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActualParamList!=null) ActualParamList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActPars(\n");

        if(ActualParamList!=null)
            buffer.append(ActualParamList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActPars]");
        return buffer.toString();
    }
}

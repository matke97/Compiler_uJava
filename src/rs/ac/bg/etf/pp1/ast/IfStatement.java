// generated with ast extension for cup
// version 0.8
// 17/7/2020 23:35:16


package rs.ac.bg.etf.pp1.ast;

public class IfStatement extends Statement {

    private Condition Condition;
    private ElseOptStatement ElseOptStatement;

    public IfStatement (Condition Condition, ElseOptStatement ElseOptStatement) {
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.ElseOptStatement=ElseOptStatement;
        if(ElseOptStatement!=null) ElseOptStatement.setParent(this);
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public ElseOptStatement getElseOptStatement() {
        return ElseOptStatement;
    }

    public void setElseOptStatement(ElseOptStatement ElseOptStatement) {
        this.ElseOptStatement=ElseOptStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Condition!=null) Condition.accept(visitor);
        if(ElseOptStatement!=null) ElseOptStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(ElseOptStatement!=null) ElseOptStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(ElseOptStatement!=null) ElseOptStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfStatement(\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElseOptStatement!=null)
            buffer.append(ElseOptStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfStatement]");
        return buffer.toString();
    }
}

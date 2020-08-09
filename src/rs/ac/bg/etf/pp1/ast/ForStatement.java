// generated with ast extension for cup
// version 0.8
// 9/7/2020 17:19:55


package rs.ac.bg.etf.pp1.ast;

public class ForStatement extends Statement {

    private DesignatorStmtOpt DesignatorStmtOpt;
    private ConditionOpt ConditionOpt;
    private DesignatorStmtOpt DesignatorStmtOpt1;
    private Statement Statement;

    public ForStatement (DesignatorStmtOpt DesignatorStmtOpt, ConditionOpt ConditionOpt, DesignatorStmtOpt DesignatorStmtOpt1, Statement Statement) {
        this.DesignatorStmtOpt=DesignatorStmtOpt;
        if(DesignatorStmtOpt!=null) DesignatorStmtOpt.setParent(this);
        this.ConditionOpt=ConditionOpt;
        if(ConditionOpt!=null) ConditionOpt.setParent(this);
        this.DesignatorStmtOpt1=DesignatorStmtOpt1;
        if(DesignatorStmtOpt1!=null) DesignatorStmtOpt1.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public DesignatorStmtOpt getDesignatorStmtOpt() {
        return DesignatorStmtOpt;
    }

    public void setDesignatorStmtOpt(DesignatorStmtOpt DesignatorStmtOpt) {
        this.DesignatorStmtOpt=DesignatorStmtOpt;
    }

    public ConditionOpt getConditionOpt() {
        return ConditionOpt;
    }

    public void setConditionOpt(ConditionOpt ConditionOpt) {
        this.ConditionOpt=ConditionOpt;
    }

    public DesignatorStmtOpt getDesignatorStmtOpt1() {
        return DesignatorStmtOpt1;
    }

    public void setDesignatorStmtOpt1(DesignatorStmtOpt DesignatorStmtOpt1) {
        this.DesignatorStmtOpt1=DesignatorStmtOpt1;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStmtOpt!=null) DesignatorStmtOpt.accept(visitor);
        if(ConditionOpt!=null) ConditionOpt.accept(visitor);
        if(DesignatorStmtOpt1!=null) DesignatorStmtOpt1.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStmtOpt!=null) DesignatorStmtOpt.traverseTopDown(visitor);
        if(ConditionOpt!=null) ConditionOpt.traverseTopDown(visitor);
        if(DesignatorStmtOpt1!=null) DesignatorStmtOpt1.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStmtOpt!=null) DesignatorStmtOpt.traverseBottomUp(visitor);
        if(ConditionOpt!=null) ConditionOpt.traverseBottomUp(visitor);
        if(DesignatorStmtOpt1!=null) DesignatorStmtOpt1.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForStatement(\n");

        if(DesignatorStmtOpt!=null)
            buffer.append(DesignatorStmtOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionOpt!=null)
            buffer.append(ConditionOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStmtOpt1!=null)
            buffer.append(DesignatorStmtOpt1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForStatement]");
        return buffer.toString();
    }
}

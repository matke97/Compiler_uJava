// generated with ast extension for cup
// version 0.8
// 16/7/2020 1:1:29


package rs.ac.bg.etf.pp1.ast;

public class ReturnStatement extends Statement {

    private RetVal RetVal;

    public ReturnStatement (RetVal RetVal) {
        this.RetVal=RetVal;
        if(RetVal!=null) RetVal.setParent(this);
    }

    public RetVal getRetVal() {
        return RetVal;
    }

    public void setRetVal(RetVal RetVal) {
        this.RetVal=RetVal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RetVal!=null) RetVal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RetVal!=null) RetVal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RetVal!=null) RetVal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ReturnStatement(\n");

        if(RetVal!=null)
            buffer.append(RetVal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ReturnStatement]");
        return buffer.toString();
    }
}

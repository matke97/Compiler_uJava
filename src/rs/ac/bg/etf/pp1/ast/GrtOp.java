// generated with ast extension for cup
// version 0.8
// 17/7/2020 21:38:34


package rs.ac.bg.etf.pp1.ast;

public class GrtOp extends Relop {

    public GrtOp () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GrtOp(\n");

        buffer.append(tab);
        buffer.append(") [GrtOp]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 9/7/2020 17:19:55


package rs.ac.bg.etf.pp1.ast;

public class LesseOp extends Relop {

    public LesseOp () {
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
        buffer.append("LesseOp(\n");

        buffer.append(tab);
        buffer.append(") [LesseOp]");
        return buffer.toString();
    }
}

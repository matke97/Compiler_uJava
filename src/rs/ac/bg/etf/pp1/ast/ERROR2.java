// generated with ast extension for cup
// version 0.8
// 1/8/2020 15:50:37


package rs.ac.bg.etf.pp1.ast;

public class ERROR2 extends Statement {

    public ERROR2 () {
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
        buffer.append("ERROR2(\n");

        buffer.append(tab);
        buffer.append(") [ERROR2]");
        return buffer.toString();
    }
}

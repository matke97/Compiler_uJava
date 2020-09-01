// generated with ast extension for cup
// version 0.8
// 1/8/2020 17:56:29


package rs.ac.bg.etf.pp1.ast;

public class Suboper extends AddopLeft {

    public Suboper () {
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
        buffer.append("Suboper(\n");

        buffer.append(tab);
        buffer.append(") [Suboper]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 1/8/2020 17:30:50


package rs.ac.bg.etf.pp1.ast;

public class Modoper extends MulopLeft {

    public Modoper () {
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
        buffer.append("Modoper(\n");

        buffer.append(tab);
        buffer.append(") [Modoper]");
        return buffer.toString();
    }
}

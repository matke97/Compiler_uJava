// generated with ast extension for cup
// version 0.8
// 6/8/2020 2:52:6


package rs.ac.bg.etf.pp1.ast;

public class NoAbstractMethodList extends AbstractMethodList {

    public NoAbstractMethodList () {
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
        buffer.append("NoAbstractMethodList(\n");

        buffer.append(tab);
        buffer.append(") [NoAbstractMethodList]");
        return buffer.toString();
    }
}

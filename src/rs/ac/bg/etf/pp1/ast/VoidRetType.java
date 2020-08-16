// generated with ast extension for cup
// version 0.8
// 16/7/2020 1:1:29


package rs.ac.bg.etf.pp1.ast;

public class VoidRetType extends RetType {

    public VoidRetType () {
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
        buffer.append("VoidRetType(\n");

        buffer.append(tab);
        buffer.append(") [VoidRetType]");
        return buffer.toString();
    }
}

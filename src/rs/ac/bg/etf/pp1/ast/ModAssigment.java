// generated with ast extension for cup
// version 0.8
// 6/8/2020 2:52:7


package rs.ac.bg.etf.pp1.ast;

public class ModAssigment extends MulopRight {

    public ModAssigment () {
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
        buffer.append("ModAssigment(\n");

        buffer.append(tab);
        buffer.append(") [ModAssigment]");
        return buffer.toString();
    }
}

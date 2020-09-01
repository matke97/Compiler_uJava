// generated with ast extension for cup
// version 0.8
// 1/8/2020 17:30:49


package rs.ac.bg.etf.pp1.ast;

public class DesigOperationActPar extends DesigOperation {

    public DesigOperationActPar () {
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
        buffer.append("DesigOperationActPar(\n");

        buffer.append(tab);
        buffer.append(") [DesigOperationActPar]");
        return buffer.toString();
    }
}

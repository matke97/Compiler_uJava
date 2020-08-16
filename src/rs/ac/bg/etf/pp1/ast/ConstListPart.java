// generated with ast extension for cup
// version 0.8
// 16/7/2020 1:1:29


package rs.ac.bg.etf.pp1.ast;

public class ConstListPart extends ConstList {

    private ConstPart ConstPart;

    public ConstListPart (ConstPart ConstPart) {
        this.ConstPart=ConstPart;
        if(ConstPart!=null) ConstPart.setParent(this);
    }

    public ConstPart getConstPart() {
        return ConstPart;
    }

    public void setConstPart(ConstPart ConstPart) {
        this.ConstPart=ConstPart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstPart!=null) ConstPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstPart!=null) ConstPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstPart!=null) ConstPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstListPart(\n");

        if(ConstPart!=null)
            buffer.append(ConstPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstListPart]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 1/8/2020 15:38:14


package rs.ac.bg.etf.pp1.ast;

public class CharFactor extends Factor {

    private Character fact;

    public CharFactor (Character fact) {
        this.fact=fact;
    }

    public Character getFact() {
        return fact;
    }

    public void setFact(Character fact) {
        this.fact=fact;
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
        buffer.append("CharFactor(\n");

        buffer.append(" "+tab+fact);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CharFactor]");
        return buffer.toString();
    }
}

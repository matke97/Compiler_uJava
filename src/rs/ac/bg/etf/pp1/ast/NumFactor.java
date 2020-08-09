// generated with ast extension for cup
// version 0.8
// 9/7/2020 17:19:55


package rs.ac.bg.etf.pp1.ast;

public class NumFactor extends Factor {

    private Integer fact;

    public NumFactor (Integer fact) {
        this.fact=fact;
    }

    public Integer getFact() {
        return fact;
    }

    public void setFact(Integer fact) {
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
        buffer.append("NumFactor(\n");

        buffer.append(" "+tab+fact);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NumFactor]");
        return buffer.toString();
    }
}

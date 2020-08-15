// generated with ast extension for cup
// version 0.8
// 15/7/2020 11:28:49


package rs.ac.bg.etf.pp1.ast;

public class PrintNumConstOpt extends NumConstOpt {

    private Integer N1;

    public PrintNumConstOpt (Integer N1) {
        this.N1=N1;
    }

    public Integer getN1() {
        return N1;
    }

    public void setN1(Integer N1) {
        this.N1=N1;
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
        buffer.append("PrintNumConstOpt(\n");

        buffer.append(" "+tab+N1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintNumConstOpt]");
        return buffer.toString();
    }
}

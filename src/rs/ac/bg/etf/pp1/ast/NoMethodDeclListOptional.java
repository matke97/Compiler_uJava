// generated with ast extension for cup
// version 0.8
// 16/8/2020 15:16:51


package rs.ac.bg.etf.pp1.ast;

public class NoMethodDeclListOptional extends MethodDeclListOpt {

    public NoMethodDeclListOptional () {
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
        buffer.append("NoMethodDeclListOptional(\n");

        buffer.append(tab);
        buffer.append(") [NoMethodDeclListOptional]");
        return buffer.toString();
    }
}

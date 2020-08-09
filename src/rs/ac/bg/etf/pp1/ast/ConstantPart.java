// generated with ast extension for cup
// version 0.8
// 9/7/2020 17:19:55


package rs.ac.bg.etf.pp1.ast;

public class ConstantPart extends ConstPart {

    private String constName;
    private ConstType ConstType;

    public ConstantPart (String constName, ConstType ConstType) {
        this.constName=constName;
        this.ConstType=ConstType;
        if(ConstType!=null) ConstType.setParent(this);
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public ConstType getConstType() {
        return ConstType;
    }

    public void setConstType(ConstType ConstType) {
        this.ConstType=ConstType;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstType!=null) ConstType.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstType!=null) ConstType.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstType!=null) ConstType.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstantPart(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        if(ConstType!=null)
            buffer.append(ConstType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstantPart]");
        return buffer.toString();
    }
}

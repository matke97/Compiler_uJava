// generated with ast extension for cup
// version 0.8
// 15/7/2020 11:28:49


package rs.ac.bg.etf.pp1.ast;

public class NewTypeFactor extends Factor {

    private Type Type;
    private ArrExprOpt ArrExprOpt;

    public NewTypeFactor (Type Type, ArrExprOpt ArrExprOpt) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ArrExprOpt=ArrExprOpt;
        if(ArrExprOpt!=null) ArrExprOpt.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ArrExprOpt getArrExprOpt() {
        return ArrExprOpt;
    }

    public void setArrExprOpt(ArrExprOpt ArrExprOpt) {
        this.ArrExprOpt=ArrExprOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ArrExprOpt!=null) ArrExprOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ArrExprOpt!=null) ArrExprOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ArrExprOpt!=null) ArrExprOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NewTypeFactor(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ArrExprOpt!=null)
            buffer.append(ArrExprOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NewTypeFactor]");
        return buffer.toString();
    }
}

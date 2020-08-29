// generated with ast extension for cup
// version 0.8
// 18/7/2020 18:57:26


package rs.ac.bg.etf.pp1.ast;

public class AbsClassMethodDecl extends AbstractClassMethods {

    private AbstractMethodList AbstractMethodList;

    public AbsClassMethodDecl (AbstractMethodList AbstractMethodList) {
        this.AbstractMethodList=AbstractMethodList;
        if(AbstractMethodList!=null) AbstractMethodList.setParent(this);
    }

    public AbstractMethodList getAbstractMethodList() {
        return AbstractMethodList;
    }

    public void setAbstractMethodList(AbstractMethodList AbstractMethodList) {
        this.AbstractMethodList=AbstractMethodList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractMethodList!=null) AbstractMethodList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractMethodList!=null) AbstractMethodList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractMethodList!=null) AbstractMethodList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbsClassMethodDecl(\n");

        if(AbstractMethodList!=null)
            buffer.append(AbstractMethodList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbsClassMethodDecl]");
        return buffer.toString();
    }
}

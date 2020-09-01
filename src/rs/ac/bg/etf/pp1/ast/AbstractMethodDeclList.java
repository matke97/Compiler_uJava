// generated with ast extension for cup
// version 0.8
// 1/8/2020 17:30:49


package rs.ac.bg.etf.pp1.ast;

public class AbstractMethodDeclList extends AbstractMethodList {

    private AbstractMethodList AbstractMethodList;
    private AbsRegularMethod AbsRegularMethod;

    public AbstractMethodDeclList (AbstractMethodList AbstractMethodList, AbsRegularMethod AbsRegularMethod) {
        this.AbstractMethodList=AbstractMethodList;
        if(AbstractMethodList!=null) AbstractMethodList.setParent(this);
        this.AbsRegularMethod=AbsRegularMethod;
        if(AbsRegularMethod!=null) AbsRegularMethod.setParent(this);
    }

    public AbstractMethodList getAbstractMethodList() {
        return AbstractMethodList;
    }

    public void setAbstractMethodList(AbstractMethodList AbstractMethodList) {
        this.AbstractMethodList=AbstractMethodList;
    }

    public AbsRegularMethod getAbsRegularMethod() {
        return AbsRegularMethod;
    }

    public void setAbsRegularMethod(AbsRegularMethod AbsRegularMethod) {
        this.AbsRegularMethod=AbsRegularMethod;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractMethodList!=null) AbstractMethodList.accept(visitor);
        if(AbsRegularMethod!=null) AbsRegularMethod.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractMethodList!=null) AbstractMethodList.traverseTopDown(visitor);
        if(AbsRegularMethod!=null) AbsRegularMethod.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractMethodList!=null) AbstractMethodList.traverseBottomUp(visitor);
        if(AbsRegularMethod!=null) AbsRegularMethod.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractMethodDeclList(\n");

        if(AbstractMethodList!=null)
            buffer.append(AbstractMethodList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AbsRegularMethod!=null)
            buffer.append(AbsRegularMethod.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractMethodDeclList]");
        return buffer.toString();
    }
}

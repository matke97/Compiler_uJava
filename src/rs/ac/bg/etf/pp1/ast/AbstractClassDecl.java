// generated with ast extension for cup
// version 0.8
// 16/8/2020 15:16:51


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private AbstractClassName AbstractClassName;
    private Extend Extend;
    private VarDeclOpt VarDeclOpt;
    private AbstractClassMethods AbstractClassMethods;

    public AbstractClassDecl (AbstractClassName AbstractClassName, Extend Extend, VarDeclOpt VarDeclOpt, AbstractClassMethods AbstractClassMethods) {
        this.AbstractClassName=AbstractClassName;
        if(AbstractClassName!=null) AbstractClassName.setParent(this);
        this.Extend=Extend;
        if(Extend!=null) Extend.setParent(this);
        this.VarDeclOpt=VarDeclOpt;
        if(VarDeclOpt!=null) VarDeclOpt.setParent(this);
        this.AbstractClassMethods=AbstractClassMethods;
        if(AbstractClassMethods!=null) AbstractClassMethods.setParent(this);
    }

    public AbstractClassName getAbstractClassName() {
        return AbstractClassName;
    }

    public void setAbstractClassName(AbstractClassName AbstractClassName) {
        this.AbstractClassName=AbstractClassName;
    }

    public Extend getExtend() {
        return Extend;
    }

    public void setExtend(Extend Extend) {
        this.Extend=Extend;
    }

    public VarDeclOpt getVarDeclOpt() {
        return VarDeclOpt;
    }

    public void setVarDeclOpt(VarDeclOpt VarDeclOpt) {
        this.VarDeclOpt=VarDeclOpt;
    }

    public AbstractClassMethods getAbstractClassMethods() {
        return AbstractClassMethods;
    }

    public void setAbstractClassMethods(AbstractClassMethods AbstractClassMethods) {
        this.AbstractClassMethods=AbstractClassMethods;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AbstractClassName!=null) AbstractClassName.accept(visitor);
        if(Extend!=null) Extend.accept(visitor);
        if(VarDeclOpt!=null) VarDeclOpt.accept(visitor);
        if(AbstractClassMethods!=null) AbstractClassMethods.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AbstractClassName!=null) AbstractClassName.traverseTopDown(visitor);
        if(Extend!=null) Extend.traverseTopDown(visitor);
        if(VarDeclOpt!=null) VarDeclOpt.traverseTopDown(visitor);
        if(AbstractClassMethods!=null) AbstractClassMethods.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AbstractClassName!=null) AbstractClassName.traverseBottomUp(visitor);
        if(Extend!=null) Extend.traverseBottomUp(visitor);
        if(VarDeclOpt!=null) VarDeclOpt.traverseBottomUp(visitor);
        if(AbstractClassMethods!=null) AbstractClassMethods.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDecl(\n");

        if(AbstractClassName!=null)
            buffer.append(AbstractClassName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Extend!=null)
            buffer.append(Extend.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclOpt!=null)
            buffer.append(VarDeclOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AbstractClassMethods!=null)
            buffer.append(AbstractClassMethods.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AbstractClassDecl]");
        return buffer.toString();
    }
}

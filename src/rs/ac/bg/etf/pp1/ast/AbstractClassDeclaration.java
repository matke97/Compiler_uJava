// generated with ast extension for cup
// version 0.8
// 9/7/2020 17:19:55


package rs.ac.bg.etf.pp1.ast;

public class AbstractClassDeclaration extends AbstractClassDecl {

    private ClassName ClassName;
    private Extend Extend;
    private VarDeclOpt VarDeclOpt;
    private AbstractClassMethods AbstractClassMethods;

    public AbstractClassDeclaration (ClassName ClassName, Extend Extend, VarDeclOpt VarDeclOpt, AbstractClassMethods AbstractClassMethods) {
        this.ClassName=ClassName;
        if(ClassName!=null) ClassName.setParent(this);
        this.Extend=Extend;
        if(Extend!=null) Extend.setParent(this);
        this.VarDeclOpt=VarDeclOpt;
        if(VarDeclOpt!=null) VarDeclOpt.setParent(this);
        this.AbstractClassMethods=AbstractClassMethods;
        if(AbstractClassMethods!=null) AbstractClassMethods.setParent(this);
    }

    public ClassName getClassName() {
        return ClassName;
    }

    public void setClassName(ClassName ClassName) {
        this.ClassName=ClassName;
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassName!=null) ClassName.accept(visitor);
        if(Extend!=null) Extend.accept(visitor);
        if(VarDeclOpt!=null) VarDeclOpt.accept(visitor);
        if(AbstractClassMethods!=null) AbstractClassMethods.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassName!=null) ClassName.traverseTopDown(visitor);
        if(Extend!=null) Extend.traverseTopDown(visitor);
        if(VarDeclOpt!=null) VarDeclOpt.traverseTopDown(visitor);
        if(AbstractClassMethods!=null) AbstractClassMethods.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassName!=null) ClassName.traverseBottomUp(visitor);
        if(Extend!=null) Extend.traverseBottomUp(visitor);
        if(VarDeclOpt!=null) VarDeclOpt.traverseBottomUp(visitor);
        if(AbstractClassMethods!=null) AbstractClassMethods.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AbstractClassDeclaration(\n");

        if(ClassName!=null)
            buffer.append(ClassName.toString("  "+tab));
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
        buffer.append(") [AbstractClassDeclaration]");
        return buffer.toString();
    }
}

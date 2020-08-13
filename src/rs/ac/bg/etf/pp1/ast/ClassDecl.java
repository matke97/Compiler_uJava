// generated with ast extension for cup
// version 0.8
// 13/7/2020 12:46:51


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ClassName ClassName;
    private Extend Extend;
    private VarDeclOpt VarDeclOpt;
    private MethodDeclListOpt MethodDeclListOpt;

    public ClassDecl (ClassName ClassName, Extend Extend, VarDeclOpt VarDeclOpt, MethodDeclListOpt MethodDeclListOpt) {
        this.ClassName=ClassName;
        if(ClassName!=null) ClassName.setParent(this);
        this.Extend=Extend;
        if(Extend!=null) Extend.setParent(this);
        this.VarDeclOpt=VarDeclOpt;
        if(VarDeclOpt!=null) VarDeclOpt.setParent(this);
        this.MethodDeclListOpt=MethodDeclListOpt;
        if(MethodDeclListOpt!=null) MethodDeclListOpt.setParent(this);
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

    public MethodDeclListOpt getMethodDeclListOpt() {
        return MethodDeclListOpt;
    }

    public void setMethodDeclListOpt(MethodDeclListOpt MethodDeclListOpt) {
        this.MethodDeclListOpt=MethodDeclListOpt;
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
        if(ClassName!=null) ClassName.accept(visitor);
        if(Extend!=null) Extend.accept(visitor);
        if(VarDeclOpt!=null) VarDeclOpt.accept(visitor);
        if(MethodDeclListOpt!=null) MethodDeclListOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassName!=null) ClassName.traverseTopDown(visitor);
        if(Extend!=null) Extend.traverseTopDown(visitor);
        if(VarDeclOpt!=null) VarDeclOpt.traverseTopDown(visitor);
        if(MethodDeclListOpt!=null) MethodDeclListOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassName!=null) ClassName.traverseBottomUp(visitor);
        if(Extend!=null) Extend.traverseBottomUp(visitor);
        if(VarDeclOpt!=null) VarDeclOpt.traverseBottomUp(visitor);
        if(MethodDeclListOpt!=null) MethodDeclListOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

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

        if(MethodDeclListOpt!=null)
            buffer.append(MethodDeclListOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}

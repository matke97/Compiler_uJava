// generated with ast extension for cup
// version 0.8
// 9/7/2020 17:19:55


package rs.ac.bg.etf.pp1.ast;

public class VariablesList extends VarDeclOpt {

    private VarDeclOpt VarDeclOpt;
    private VarDecl VarDecl;

    public VariablesList (VarDeclOpt VarDeclOpt, VarDecl VarDecl) {
        this.VarDeclOpt=VarDeclOpt;
        if(VarDeclOpt!=null) VarDeclOpt.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public VarDeclOpt getVarDeclOpt() {
        return VarDeclOpt;
    }

    public void setVarDeclOpt(VarDeclOpt VarDeclOpt) {
        this.VarDeclOpt=VarDeclOpt;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclOpt!=null) VarDeclOpt.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclOpt!=null) VarDeclOpt.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclOpt!=null) VarDeclOpt.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VariablesList(\n");

        if(VarDeclOpt!=null)
            buffer.append(VarDeclOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VariablesList]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 1/8/2020 17:56:29


package rs.ac.bg.etf.pp1.ast;

public class ProgramVarDeclList extends ProgDeclList {

    private ProgDeclList ProgDeclList;
    private ProgDeclPart ProgDeclPart;

    public ProgramVarDeclList (ProgDeclList ProgDeclList, ProgDeclPart ProgDeclPart) {
        this.ProgDeclList=ProgDeclList;
        if(ProgDeclList!=null) ProgDeclList.setParent(this);
        this.ProgDeclPart=ProgDeclPart;
        if(ProgDeclPart!=null) ProgDeclPart.setParent(this);
    }

    public ProgDeclList getProgDeclList() {
        return ProgDeclList;
    }

    public void setProgDeclList(ProgDeclList ProgDeclList) {
        this.ProgDeclList=ProgDeclList;
    }

    public ProgDeclPart getProgDeclPart() {
        return ProgDeclPart;
    }

    public void setProgDeclPart(ProgDeclPart ProgDeclPart) {
        this.ProgDeclPart=ProgDeclPart;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgDeclList!=null) ProgDeclList.accept(visitor);
        if(ProgDeclPart!=null) ProgDeclPart.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgDeclList!=null) ProgDeclList.traverseTopDown(visitor);
        if(ProgDeclPart!=null) ProgDeclPart.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgDeclList!=null) ProgDeclList.traverseBottomUp(visitor);
        if(ProgDeclPart!=null) ProgDeclPart.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramVarDeclList(\n");

        if(ProgDeclList!=null)
            buffer.append(ProgDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ProgDeclPart!=null)
            buffer.append(ProgDeclPart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramVarDeclList]");
        return buffer.toString();
    }
}

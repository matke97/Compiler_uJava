// generated with ast extension for cup
// version 0.8
// 1/8/2020 17:30:49


package rs.ac.bg.etf.pp1.ast;

public class ExprMinus extends ExprMinusPlus {

    private MinusEx MinusEx;
    private Term Term;

    public ExprMinus (MinusEx MinusEx, Term Term) {
        this.MinusEx=MinusEx;
        if(MinusEx!=null) MinusEx.setParent(this);
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
    }

    public MinusEx getMinusEx() {
        return MinusEx;
    }

    public void setMinusEx(MinusEx MinusEx) {
        this.MinusEx=MinusEx;
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MinusEx!=null) MinusEx.accept(visitor);
        if(Term!=null) Term.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MinusEx!=null) MinusEx.traverseTopDown(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MinusEx!=null) MinusEx.traverseBottomUp(visitor);
        if(Term!=null) Term.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprMinus(\n");

        if(MinusEx!=null)
            buffer.append(MinusEx.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprMinus]");
        return buffer.toString();
    }
}

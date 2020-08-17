package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;


import rs.ac.bg.etf.pp1.CounterVisitor.VarCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;
public class CodeGenerator extends VisitorAdaptor {
	private int mainPc;
	
	Obj currentDesignator 		= null;
	Boolean assignFlag			= false;
	
	int typeOfAddOp 			= -1; //FLAG ZA TIP OPERACIJE(MOZE BITI +, -, +=, -=)
	int typeOfMulOp 			= -1; //FLAG ZA TIP OPERACIJE(MOZE BITI *, /, %,..)	
	boolean minusTermFlag		= false; //flag za hvatanje - izraza tj -TERM
	public int getMainPc(){
		return mainPc;
	}
	

	Logger log= Logger.getLogger(getClass());
	
	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public void visit(PrintStatement ps)
	{
		if(ps.getExpr().struct == Tab.intType)
		{
			Code.loadConst(5);
			Code.put(Code.print);
		}
		else
		{
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	
	public void visit(ReadStatement rs)
	{
		Obj designObj = currentDesignator;
		report_info("aAAAA" + designObj.getName(), null);
		if (designObj.getType().getKind()==Struct.Int)
		{
			Code.put(Code.read);
		}else if(designObj.getType().getKind()==Struct.Char)
		{
			Code.put(Code.bread);
		}
		
		Code.store(designObj);
	}
	
	public void visit(NumFactor nf)
	{
		Obj con = Tab.insert(Obj.Con, "$", nf.struct);
		con.setLevel(0);
		con.setAdr(nf.getFact());
		
		Code.load(con);
		if(minusTermFlag)
		{
			//SLUCAJ KAD IMAMMO -TERM TADA MORAMO DA IZV OPERACIJU NEGACIJE KOJOM CUVAMO PRAVU VR
			minusTermFlag = false;
			Code.put(Code.neg); 
		}
	}
	
	public void visit(CharFactor cf)
	{
		Obj con = Tab.insert(Obj.Con, "$", cf.struct);
		con.setLevel(0);
		con.setAdr(cf.getFact());
		
		Code.load(con);
	}
	
	public void visit(BoolFactor bf)
	{
		Obj con = Tab.insert(Obj.Con, "$", bf.struct);
		con.setLevel(0);
		
		con.setAdr(bf.getFact() ? 1 : 0);
		
		Code.load(con);
	}
	
	public void visit(MethodTypeName methodTypeName)
	{
		
		if("main".equalsIgnoreCase(methodTypeName.getMethodName())){
			mainPc = Code.pc;
		}
		methodTypeName.obj.setAdr(Code.pc);
		// Collect arguments and local variables
		SyntaxNode methodNode = methodTypeName.getParent();
	
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		/*FormParamCounter fpCnt = new FormParamCounter();
		methodNode.traverseTopDown(fpCnt);*/
		
		// Generate the entry
		Code.put(Code.enter);
		Code.put(0);
		Code.put(varCnt.getCount());
	
	}
	
	/**
	 * Kad se naleti na return odmah da se izajde
	 */
	public void visit(ReturnStatement rts)
	{
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	/**
	 * Ako metoda nea return iskaz
	 */
	public void visit(MethodDecl methodDecl)
	{
		Code.put(Code.exit);
		Code.put(Code.return_);
	}	
	
	/*
	 * Poziv finkcije koja se koristi kao faktor unutar izraza
	 */
	public void visit(FuncCallFactor fcf)
	{
		Obj funcObj = fcf.getDesignator().obj;
		int offset = funcObj.getAdr() - Code.pc;
		
		Code.put(Code.call);
		Code.put2(offset);
	}
	
	public void visit(Designator desig)
	{
		currentDesignator = desig.obj;
		
		SyntaxNode parent = desig.getParent();
		
		if(ReadStatement.class != parent.getClass() && DesignatorStatement.class != parent.getClass() && FuncCallFactor.class != parent.getClass() && ParentFactor.class != parent.getClass() && desig.obj.getType().getKind()!=Struct.Array)
		{

			Code.load(desig.obj);
			
			if(minusTermFlag)
			{
				//SLUCAJ KAD IMAMMO -TERM TADA MORAMO DA IZV OPERACIJU NEGACIJE KOJOM CUVAMO PRAVU VR
				minusTermFlag = false;
				Code.put(Code.neg); 
			}
		}

	}
	
	public void visit(DesigOperationAss dopa)
	{
		assignFlag = true;
	}
	
	public void visit(DesigOperationInc inc)
	{
		//first param
		Code.load(currentDesignator);
		
		//secont param
		Obj con = Tab.insert(Obj.Con, "$", new Struct(Struct.Int));
		con.setLevel(0);
		con.setAdr(1);
		
		Code.load(con);
		
		Code.put(Code.add);

		Code.store(currentDesignator);		
	}
	
	public void visit(DesigOperationDec dec)
	{
		Code.load(currentDesignator);
		Obj con = Tab.insert(Obj.Con, "$", new Struct(Struct.Int));
		con.setLevel(0);
		con.setAdr(-1);
		
		Code.load(con);
		
		Code.put(Code.add);

		Code.store(currentDesignator);	
	}
	
	
	public void visit(Assignoper aop)
	{
	
	}
	public void visit( DesignStatment ds )
	{
		if(assignFlag)
		{
			report_info("dodela vr promenljivoj: "+ ds.getDesignator().obj.getName() + " na liniji:"+ ds.getLine(), null);
			Code.store(ds.getDesignator().obj);
			assignFlag = false;
		}
		
	}
	/*
	 * Poziv metode kao samostalan statement
	 */
	public void visit(DesigOperationActPar procCall)
	{
		Obj funcObj = currentDesignator;
		int offset = funcObj.getAdr() - Code.pc;
		
		Code.put(Code.call);
		Code.put2(offset);
		
		if(currentDesignator.getType() != Tab.noType)
		{
			//ako ima povratan rez, da ga odmacimo
			Code.put(Code.pop);
		}
		currentDesignator = null;
	}

	public void visit(MinusExp em)
	{
		minusTermFlag = true;
	}
	public void visit(AddopExpr addexp)
	{
		switch(typeOfAddOp)
		{
		case 1:
			Code.put(Code.add);
			break;
		case 2:
			Code.put(Code.sub);
			break;
		case 3:
			break;
		case 4:
		}
		
		typeOfAddOp = -1;
	}
	
	public void visit(MulopTerm mulTerm)
	{
		switch(typeOfMulOp)
		{
		case 1:
			Code.put(Code.mul);
			break;
		case 2:
			Code.put(Code.div);
			break;
		case 3:
			Code.put(Code.rem);
		}
		
		typeOfMulOp = -1;
	}
	
	public void visit(Addoper addo)
	{
		typeOfAddOp = 1;
	}
	
	public void visit(Suboper sub)
	{
		typeOfAddOp = 2;
	}
	
	public void visit(Muloper mul)
	{
		typeOfMulOp = 1;
	}
	
	public void visit(Divoper div)
	{
		typeOfMulOp = 2;
	}
	
	public void visit(Modoper mod)
	{
		typeOfMulOp = 3;
	}
}
package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticAnalyzer extends VisitorAdaptor {
	
	int printCallCount 		= 0;
	int varDeclCount 		= 0;
	Obj currentMethod 		= null;
	Obj currentClass 		= null;
	Obj currentDesigObj     = null;
	
	Struct currentType 					= null;
	boolean returnFound 				= false;
	boolean errorDetected 				= false;
	boolean mainDeclared 				= false;
	boolean arrayDesigFlag 				= false; // flag za pristup nizu
	boolean newArrayFlag 				= false;
	boolean arrayDesignatorStatement 	= false; //KADA IMAMO DESIG STaTEMNTU I DESIGNATOR JE PRISTUP ELEMENTU NIZA
    boolean pristupNizu 				= false;
    boolean arrayRead 					= false;
    boolean newTypeFactorFlag 			= false; 
	int desigStatementOperation = -1; //operacija koj se desava sa dstm


	Obj designatorLeftObj 					= null;
	
	int nVars;
	
	int numClass = 0, 	numMethod = 0, 	numGlobalVar = 0 ,	numConst = 0, 	numGlobalArray = 0;
	int numLocalArrayMain = 0,	numLocalVarMain = 0,	numStatementMain = 0, 	numFunctionCallMain = 0;

	int currLevel = 0;
	
	
	int constValue;
	Struct currExprType 	= null;
    Struct methRetType 		= null;
	Struct returnType 		= null; //tip koji vraca return izraz unutar metode!
	Struct factorType 		= null;
	Obj currentConst 		= null;
	
	Logger log 				= Logger.getLogger(getClass());
	/**
	 * 
	 * @param message - text message to show
	 * @param info - info about syntax error
	 * @brief Predefined methods for throwing semantic errors
	 */
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public String objToString(Obj o)
    {
		StringBuilder msg = new StringBuilder(); 
		switch(o.getKind())
		{
		case 0:
			msg.append("Con ");
			break;
		case 1:
			msg.append("Var ");
			break;
		case 2:
			msg.append("Type ");
			break;
		case 3: 
			msg.append("Meth ");
			break;
		case 4:
			msg.append("Fld ");
			break;
		case 5:
			msg.append("Elem ");
			break;
		}
		msg.append(o.getName()+ ": ");
		switch(o.getType().getKind())
		{
		case 0:
			msg.append("None");
			break;
		case 1:
			msg.append("int");
			break;
		case 2: 
			msg.append("char");
			break;
		case 3:
			msg.append("array");
			break;
		case 4:
			msg.append("class");
			break;
		}
		msg.append(", "+ o.getAdr()+",");
		msg.append(o.getLevel());
		return msg.toString();
    }
	//VISIT METHODS 
	
	public void visit(VarDecl vardecl){
		varDeclCount++;
		
	}
	
    public void visit(PrintStatement  print) {
	
    	
    	/*if((print.getExpr().struct).getKind() != Struct.Int && (print.getExpr().struct).getKind() != Struct.Char)
		{
    		report_error("Greska na liniji "+ print.getLine()+": Izraz mora biti int ili char tipa", null);
		}*/
    	
    	/*if((print.getExpr().struct).getKind() != Struct.Int && (print.getExpr().struct).getKind() != Struct.Char)
		{
    		report_error("Greska na liniji "+ print.getLine()+": Izraz mora biti int ili char tipa", null);
		}*/
    	
    	if((print.getExpr().struct).getKind() != Struct.Int && (print.getExpr().struct).getKind() != Struct.Char)
		{
    		report_error("Greska na liniji "+ print.getLine()+": Izraz mora biti int ili char tipa", null);
		}
    	
	}
    
    /**
     * 
     */
    public void visit(ProgName progName)
    {
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgramName(), Tab.noType);
    	Tab.openScope();
    	
    	log.info("=======================================SEMANTICKA ANALIZA=====================================");
    	report_info("Zapocinjemo sa glavnim programom",progName);
    }
    
    
    /**
     * Visit metoda za hvatanje programa
     */
    public void visit(Program program)
    {
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    	
    	log.info("=======================================SINTAKSNA ANALIZA=====================================");
		log.info(numClass+"    classes");
		log.info(numMethod+"    methods in program");
		log.info(numGlobalVar+"    global variables");
		log.info(numConst+"    constants");
		log.info(numGlobalArray+"    global arrays");
		log.info(numLocalVarMain+"    local variables in main");
		log.info(numLocalArrayMain+"    local arrays in main");
		log.info(numStatementMain+"    statements in main");
		log.info(numFunctionCallMain+"    function calls in main");
    }
    
    //for vardecl
    /**
     * part- contains IDENT as variablename
     * DEO ZA DEFINISANE PROMENLJIVIH
     */
    public void visit(VariablePart part)
    {
    	Obj a =Tab.currentScope.findSymbol(part.getVarName());
    	if(a != null)
    	{
    		report_error("Greska na "+part.getLine()+":"+"Simbol" + part.getVarName() + "je vec deklarisan", null);
    		return;
    	}
    	report_info("Deklarisana promenljiva:"+part.getVarName()+" tipa "+ currentType.getKind(), null);
    	if(currentClass != null && currentMethod == null)
    	{
    		/*field type*/
    		Tab.insert(Obj.Fld, part.getVarName(), currentType);
    	}else
    	{
    		if(currentMethod != null)
    		{
    			if( currentMethod.getName() == "main" ) numLocalVarMain++;
    		}else
    		{
    			numGlobalVar++;
    		}
    		Tab.insert(Obj.Var, part.getVarName(), currentType);
    		
    	}
    }
    public void visit(VariablePartArr partArr)
    {
    	Obj a =Tab.currentScope.findSymbol(partArr.getVarName());
    	if(a != null)
    	{
    		report_error("Greska na "+partArr.getLine()+":"+"Simbol" + partArr.getVarName() + "je vec deklarisan", null);
    		return;
    	}
    	report_info("Deklarisan niz:"+partArr.getVarName()+" tipa "+ currentType.getKind(), null);
    	if(currentClass != null && currentMethod == null)
    	{
    		/*field type*/
    		Tab.insert(Obj.Fld, partArr.getVarName(), new Struct(Struct.Array, currentType));
    	}else
    	{
    		if(currentMethod != null)
    		{
    			if( currentMethod.getName() == "main" )numLocalArrayMain++;
    		}else
    		{
    			numGlobalArray++;
    		}
    		Tab.insert(Obj.Var, partArr.getVarName(), new Struct(Struct.Array, currentType));
    		
    	}
    }
    
    
    /**
     * Visit metoda ZA prihvatanje Tipa varijable
     */
    public void visit(Type type)
    {
    	Obj typeNode = Tab.find(type.getT());
    	if(typeNode == Tab.noObj)
    	{
    		report_error("Nije pronadjen tip" + type.getT() + "u tabeli simbola", null);
    		type.struct = Tab.noType;
    	}else
    	{
    		if(Obj.Type == typeNode.getKind())
    		{
    			type.struct = typeNode.getType();
    			currentType = typeNode.getType();
    		}else
    		{
    			report_error("Greska: Ime" + type.getT() + "ne predstavlja tip", type);
    			type.struct = Tab.noType;
    		}
    		
    	}
    }
    //MOZDA I NE MORA

    public void visit(VoidRetType voidRet)
    {
    	methRetType = Tab.noType;
    }
    public void visit(TypeRetType typeRet)
    {
    	methRetType = currentType;
    }
    
    public void visit(MethodTypeName methodTypeName)
    {
    	if(Tab.find(methodTypeName.getMethodName()) != Tab.noObj)
    	{
    		report_error("Greska na liniji:"+ methodTypeName.getLine()+ "metoda je vec deklarisana!", null);
    		currentMethod = null;
    		return;
    	}
    	if(methodTypeName.getMethodName() == "main")
    	{
    		//main metoda
    		if(methRetType != Tab.noType)
    		{
    			report_error("Greska na liniji "+ methodTypeName.getLine()+": Main metodi je tip povratne vr void.", null);
    		}
    		mainDeclared = true;
    	}
    	currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethodName(), methRetType);
    	methodTypeName.obj = currentMethod;
    	
    	Tab.openScope();
    	//VIDI DAL TREBA
    	
    }
    
    public void visit(MethodDecl methDecl)
    {
    	//greska u drugom delu moras da ispravis return
    	if((!returnFound && currentMethod.getType() != Tab.noType) || (returnFound && currentMethod.getType() != returnType)){
			report_error("Semanticka greska na liniji " + methDecl.getLine() + ": funkcija " + currentMethod.getName() + " nema return iskaz!", null);
    	}
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	
    	returnFound = false;
    	currentMethod = null;
    	returnType = null;
    }
    
    public void visit(ReturnStatement rtstm)
    {
    	if(currentMethod == null)
    	{
    		report_error("Greska na liniji:" + rtstm.getLine() + ", return izraz mora biti unutar metode", null);
    		return;
    	}
    	returnFound = true;
    }
  
    public void visit(RetValue rv)
    {
    	if(currentMethod != null)
    	{
    		Struct currMethType = currentMethod.getType();
    		if(!currMethType.compatibleWith(rv.getExpr().struct))
    		{
    			report_error("Greska na liniji " + rv.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
    		}else
    		{
    			returnType = currentMethod.getType();
    		}
    	}
    }
    
    public void visit(NoRetVal nrv)
    {
    	returnType = Tab.noType;
    }
    
    public void visit(ConstPart constPart)
    {
    	if(Tab.currentScope.findSymbol(constPart.getConstName()) != null)
    	{
    		report_error("Greska na liniji:" + constPart.getLine()+ "Ime" + constPart.getConstName() + "je vec definisano!", null);
    		return;
    	}
    	Obj cnst = Tab.insert(Obj.Con, constPart.getConstName(), currentType);

    	cnst.setAdr(constValue);
    	
    	
    }
    public void visit(CharacterConst chr)
    {
    	if(currentType.getKind() != Struct.Char)
    	{
    		report_error("Greska na liniji:"+ chr.getLine()+ "tip konstane i vrednost se razlikuju", null);
    	}
    	else
    	{
    		constValue = chr.getCharacter();
    	}
    	
    }
    
    public void visit(NumberConst num)
    {
    	if(currentType.getKind() != Struct.Int)
    	{
    		report_error("Greska na liniji:"+ num.getLine()+ "tip konstane i vrednost se razlikuju", null);
    		
    	}
    	else
    	{
    		constValue = num.getNum();
    	}
    	
    }
    
    public void visit(BooleanConst bln)
    {
    	if(currentType.getKind() != Struct.Int)
    	{
    		report_error("Greska na liniji:"+ bln.getLine()+ "tip konstane i vrednost se razlikuju", null);
    		
    	}
    	else
    	{
    		constValue = bln.getBoolConst()? 1 : 0;
    	}
    	
    }
    
    public void visit(Designator desig)
    {
    	currentDesigObj = Tab.find(desig.getName());
    	if(currentDesigObj == Tab.noObj)
    	{
    		report_error("Greska na liniji:"+ desig.getLine() +". Nije definisan simbol"+ desig.getName(), null);
    	}else
    	{
    		report_info("Pretraga na "+desig.getLine()+"("+desig.getName()+"), nadjeno:"+ objToString(currentDesigObj), desig.getParent());
    		desig.obj = currentDesigObj;
    		
    		if(arrayDesigFlag)
    		{
    			if(currentDesigObj.getType().getKind() != Struct.Array)
    			{
    				report_error("Greska na liniji: " + desig.getLine() + ": Pristup elem niza promenljivoj koja nije niz.", null);
    			}
    			arrayDesigFlag = false;
    		}
    	}
    	
    }

    public void visit(ArrayDesignPart adp)
    {
    	
    	
    	if(adp.getExpr().struct.getKind() != Struct.Int)
    		{
    			report_error("Greska na liniji: " + adp.getLine() + ":Index mora biti tipa int", null);
    		}
    	
    	if((adp.getParent().getParent()).getClass() == DesignatorLeft.class)
    	{
    		arrayDesignatorStatement = true;
    		
    	}else if((adp.getParent().getParent()).getClass() == ReadStatement.class)
    	{
    		arrayRead = true;
    	}
    	else if((adp.getParent().getParent()).getClass() == DesignatorFactor.class)
    	{
    		pristupNizu = true;
    	}
    	arrayDesigFlag = true;
    }
    
    public void visit(DesignatorFactor desigfac)
    {
    	//desigfac.struct = currentDesigObj.getType();
    	Obj o = desigfac.getDesignator().obj;
    	Struct s = o.getType();
    	
    	if(pristupNizu)
    	{
    		
    		s = desigfac.getDesignator().obj.getType().getElemType();
 	
    	}
    	
    	desigfac.struct = s;
    	factorType 		= s;
    	
    	pristupNizu = false;
    }
    public void visit(FactorTerm facTerm)
    {
    	facTerm.struct = facTerm.getFactor().struct;
    	//factorType  = facTerm.getFactor().struct;
    }
    
    public void visit(MulopTerm mulopTerm)
    {
    	mulopTerm.struct = mulopTerm.getFactor().struct;
    	//factorType		 = mulopTerm.getFactor().struct;
    }
    
    
    public void visit(DesignatorLeft dl)
    {
    	designatorLeftObj = dl.getDesignator().obj;
    	//arrayDesignatorStatement = true;
    }
    
    public void visit(DesigOperationAss dop)
    {
    	desigStatementOperation = 1;

    	report_info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + dop.getExpr().struct, null);
    	if(newTypeFactorFlag)
		{
			
			if(factorType.getKind() == Struct.Array)
			{
				if(designatorLeftObj.getType().getKind() != Struct.Array)
				{
					report_error("Greska na liniji " + dop.getLine() + ": Nekompatibilni tipvoi u dodeli vrednosti",null);
					
				}else if(designatorLeftObj.getType().getElemType().getKind() != factorType.getElemType().getKind())
				{
					report_error("Greska na liniji " + dop.getLine() + ": Nekompatibilni tipvoi u dodeli vrednosti",null);
				}
			}
		}
    	
    	else if(arrayDesignatorStatement && ((designatorLeftObj.getType()).getElemType()).getKind() != dop.getExpr().struct.getKind())
    	{
    		report_error("Greska na liniji " + dop.getLine() + ": Nekompatibilni tipvoi u dodeli vrednosti",null);
    	}
    	else if(!arrayDesignatorStatement && designatorLeftObj.getType().getKind() != dop.getExpr().struct.getKind())
    	{
    		report_error("Greska na liniji " + dop.getLine() + ": Nekompatibilni tipvoi u dodeli vrednosti",null);
    	}
    	
    	//designatorLeftObj 		= null;
    	
    	
    }
    
    public void visit(DesigOperationInc inc)
    {
    	desigStatementOperation = 2;
    }
    
    public void visit(DesigOperationDec dec)
    {
    	desigStatementOperation = 3;
    }
    
    public void visit(DesigOperationActPar proccall)
    {
    	desigStatementOperation = 4;
    }
    public void visit(DesignatorStatement ds)
    {
    	Obj desig = ds.getDesignatorLeft().getDesignator().obj;
    	//PAZI MORAS ZA ARRAY
    	//report_info("ASASASDASD: "+ ds.getDesignator().obj.getName(),null);
    	switch(desigStatementOperation)
    	{
    	case 1: //=====DS ASSIGMENT===========
    		/*report_info("gledaj " + desigStatementExpr.getKind() + ": some",null);
    		if(!arrayDesignatorStatement && desigStatementExpr.getKind() != desig.getType().getKind())
    		{
    			report_error("Greska na liniji " + ds.getLine() + ": Nekompatibilni tipvoi u dodeli vrednosti",null);
    		}
    		else 
    		else if(arrayDesignatorStatement && desigStatementExpr.getKind() != (desig.getType().getElemType()).getKind())
    		{
    			report_error("Greska na liniji " + ds.getLine() + ": Nekompatibilni tipvoi u dodeli vrednosti",null);
    		}
    		
    		
    		//========END DS ASSIGMENT=========
        	desigStatementExpr 		= null;
        	*/
    		break;
    		
    	case 2://========INCREMENT=========
    		if(!arrayDesignatorStatement && desig.getType().getKind()  != Struct.Int )
    		{
    			report_error("Greska na liniji " + ds.getLine() + ": Incerement se moze raditi samo sa integer tipom",null);
    		}else if(arrayDesignatorStatement && (desig.getType().getElemType()).getKind() != Struct.Int)
    		{
    			report_error("Greska na liniji " + ds.getLine() + ": Incerement se moze raditi samo sa integer tipom",null);
    		}
    		break;
    		
    	case 3://========DECREMENT=========
    		if(!arrayDesignatorStatement && desig.getType().getKind()  != Struct.Int )
    		{
    			report_error("Greska na liniji " + ds.getLine() + ": Decrement se moze raditi samo sa integer tipom",null);
    		}else if(arrayDesignatorStatement && (desig.getType().getElemType()).getKind() != Struct.Int)
    		{
    			report_error("Greska na liniji " + ds.getLine() + ": Dec se moze raditi samo sa integer tipom",null);
    		}
    		break;
    		
    	case 4: //========PROC CALL=========
    		if(desig.getKind() != Obj.Meth)
    		{
    			report_error("Greska na liniji " + ds.getLine() + ": " + desig.getName() + " nije metoda.",null);
    		}
    		break;
    	}
    	
    	desigStatementOperation = -1;
    	
    	designatorLeftObj 		= null;
    	arrayDesignatorStatement= false;
    	pristupNizu				= false;
    	
    	newTypeFactorFlag 		= false;
    	
    }
    
    
    public void visit(NumFactor nf)
    {
    	nf.struct = Tab.intType;
    	factorType = Tab.intType;
    }
    
    public void visit(CharFactor cf)
    {
    	cf.struct = Tab.charType;
    	factorType = Tab.charType;
    }
    
    public void visit(BoolFactor bf)
    {
    	bf.struct = Tab.intType;
    	factorType = Tab.intType;
    }
    
    public void visit(FuncCallFactor fcf)
    {
    	Obj func = fcf.getDesignator().obj;
    	if(Obj.Meth == func.getKind())
    	{
    		if(Tab.noType == func.getType())
    		{
    			report_error("Semanticka greska "+ func.getName() + " se ne moze koristiti u izrazima jer nema povratnu vr.", null);
    			fcf.struct = Tab.noType;
    		}else
    		{
    			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + fcf.getLine(), null);
    			//report_info("Pronadjen poziv funkcije " + func.getType().getKind(), null);
				fcf.struct = func.getType();
    		}
    	}
    	else
    	{
			report_error("Greska na liniji " + fcf.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
			fcf.struct = Tab.noType;
    	}
    	
    	factorType = fcf.struct;
    }
    
    
    public void visit(NewTypeFactor nf)
    {
    	
    	Struct s = nf.getType().struct;
    	
    	if(s.getKind() == Struct.Class)
    	{
    		report_error("Greska na liniji " + nf.getLine() + " Kreiranje objekata i nizova moguce samo za osnovne tipove.",null);
    	}else
    	{
    		newTypeFactorFlag = true;
    		if(newArrayFlag)
    		{
    			
    			newArrayFlag = false;
    			nf.struct = new Struct(Struct.Array, s);

    			factorType = nf.struct;
    		}else
    		{
    			nf.struct = s;
    			factorType = s;
    		}
    	}
    }
    
    public void visit(AddopExpr addExpr)
    {
    	//Struct t = addExpr.getTerm().struct;
    	//Struct te = addExpr.getExprList()
    }
    
    public void visit(Expr e)
    {
    	e.struct = factorType;
    }
    
    
    public void visit(ArrayExpr arrex)
    {
    	if(arrex.getExpr().struct.getKind() != Struct.Int)
    	{
    		report_error("Greska na liniji "+ arrex.getLine() + "Velicinu niza morate predstaviti int", null);
    	}else
    	{
    		newArrayFlag = true;
    	}
    }
    
    
    
    public void visit(ParentFactor pf)
    {
    	
    }
    
    
    
    public void visit(ReadStatement rs)
    {
    	Obj desig = rs.getDesignator().obj;
    	if(arrayRead)
    	{
    		if(desig.getType().getElemType().getKind() != Struct.Int  && desig.getType().getElemType().getKind() != Struct.Char && arrayRead)
    		{
    	    		report_error("Greska na liniji "+ rs.getLine()+": Niz mora biti tipa int ili char", null);
    	    }
    		arrayRead = false;
    	}
    	else
    	{
    		if(desig.getType().getKind() != Struct.Int && desig.getType().getKind() != Struct.Char)
    		{
  
    			report_error("Greska na liniji "+ rs.getLine()+": Izraz mora biti int ili char tipa", null);
    		}
    	}
    	
    	
    }
    
    
    
    public boolean passed()
    {
    	return !errorDetected;
    }
    
 
    
   /* NE TRBEA ZA A
    * public void visit(ClassName className)
   
    {
    	Obj cn = Tab.find(className.getClassName());
    	//Tab.currentScope.findSymbol(objName)
    	if(cn != Tab.noObj && cn.getKind() == Obj.Type)
    	{	
    		report_error("Vec postoji definisan tip(klasa) sa imenom:" + className.getClassName(), null);
    	}else
    	{
    		//prema sintaksi nije moguce da imam ugnjezdene klase!
    		currentClass = Tab.insert(Obj.Type, className.getClassName(), new Struct(Struct.Class));
    		Tab.openScope();
    		numClass++;
    	}
    	
    }
    
    public void visit(ClassDecl classDecl)
    {
    	
    	Tab.chainLocalSymbols(currentClass);
    	Tab.closeScope();
    	currentClass = null;
    }
    
    public void visit(AbstractClassName absclass)
    {
    	if(Tab.currentScope.findSymbol(absclass.getClassName()) != null)
    	{
    		report_error("Greska na liniji "+absclass.getLine()+"->Vec postoji definisan tip(klasa) sa imenom:" + absclass.getClassName(), null);
    	}
    }
     */
}

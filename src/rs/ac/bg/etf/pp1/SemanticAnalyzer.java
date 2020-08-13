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
	Struct currentType 		= null;
	boolean returnFound 	= false;
	boolean errorDetected 	= false;
	int nVars;
	
	int numClass=0,numMethod=0, numGlobalVar=0,numConst=0,numGlobalArray=0;
	int numLocalArrayMain=0,numLocalVarMain=0,numStatementMain=0, numFunctionCallMain=0;

	int currLevel = 0;
	
	
	int constValue;
	
	
	Obj currentConst =null;
	Logger log = Logger.getLogger(getClass());
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
	
	//VISIT METHODS 
	
	public void visit(VarDecl vardecl){
		varDeclCount++;
		
	}
	
    public void visit(PrintStatement  print) {
		printCallCount++;
	}
    
    /**
     * 
     */
    public void visit(ProgName progName)
    {
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgramName(), Tab.noType);
    	Tab.openScope();
    }
    
    /**
     * Visit metoda za hvatanje programa
     */
    public void visit(Program program)
    {
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
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
    boolean methRetType = false;
    public void visit(VoidRetType voidRet)
    {
    	methRetType = false;
    }
    public void visit(TypeRetType typeRet)
    {
    	methRetType = true;
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
    	}
    	currentMethod = Tab.insert(Obj.Meth, methodTypeName.getMethodName(), currentType);
    	methodTypeName.obj = currentMethod;
    	
    	Tab.openScope();
    	//VIDI DAL TREBA
    	
    }
    
    public void visit(MethodDecl methDecl)
    {
    	if(!returnFound && currentMethod.getType() != Tab.noType){
			report_error("Semanticka greska na liniji " + methDecl.getLine() + ": funkcija " + currentMethod.getName() + " nema return iskaz!", null);
    	}
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	
    	currentMethod = null;
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
    
    
    public boolean passed()
    {
    	return !errorDetected;
    }
    
    
    
   /* NE RTRBEA ZA A
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

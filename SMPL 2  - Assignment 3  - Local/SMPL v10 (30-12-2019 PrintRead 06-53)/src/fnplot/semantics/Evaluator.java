package fnplot.semantics;

import fnplot.syntax.StmtLet;
import fnplot.syntax.Statement;
import fnplot.syntax.StmtDefinition;
import fnplot.syntax.StmtSequence;
import fnplot.syntax.ExpLit;
import fnplot.syntax.ExpDiv;
import fnplot.syntax.ExpMul;
import fnplot.syntax.ExpAdd;
import fnplot.syntax.ExpVar;
import fnplot.syntax.ExpMod;
import fnplot.syntax.ExpSub;
import fnplot.syntax.ExpPow;
import fnplot.syntax.ExpFunction;
import fnplot.syntax.ExpCall;
import fnplot.syntax.ExpPlot;
import fnplot.syntax.ExpClear;
import fnplot.syntax.ExpBool;
import fnplot.syntax.ExpConcat;
import fnplot.syntax.ExpHeap;

import fnplot.syntax.ExpVector;
import fnplot.syntax.ExpSubVector;
import fnplot.syntax.ExpPair;
import fnplot.syntax.ExpIndex;
import fnplot.syntax.ExpSize;
import fnplot.syntax.ExpList;
import fnplot.syntax.ExpListCall;
import fnplot.syntax.ExpNull;
import fnplot.syntax.ExpCompare;
import fnplot.syntax.ExpLogOp;
import fnplot.syntax.ExpString;
import fnplot.syntax.ExpSubStr;
import fnplot.syntax.ExpLoop;
import fnplot.syntax.ExpVecComp;
import fnplot.syntax.ExpReadPrint;

import fnplot.syntax.ExpIf;
import fnplot.syntax.ExpCase;

import fnplot.gui.GraphPlotter;
import fnplot.gui.FnPlotFrame;
//import javax.swing.JFrame;

import fnplot.syntax.Binding;
import fnplot.syntax.ArithProgram;
import fnplot.syntax.Exp;
import fnplot.syntax.ExpFunction;
import fnplot.sys.FnPlotException;
import fnplot.values.FnPlotReal;
import fnplot.values.FnPlotValue;
import fnplot.values.FnPlotInt;
import fnplot.values.FnPlotFunction;
import fnplot.values.FnPlotType;
import fnplot.values.FnNull;
import fnplot.values.FnBool;
import fnplot.values.FnString;

import fnplot.values.FnVector;
import fnplot.values.FnPair;
import fnplot.values.FnHeap;

import java.awt.geom.Point2D;
import java.util.*;
import java.io.*;

public class Evaluator 
    implements Visitor<Environment<FnPlotValue<?>>, FnPlotValue<?>> {
    /* For this visitor, the argument passed to all visit
       methods will be the environment object that used to
       be passed to the eval method in the first style of
       implementation. */

    // allocate state here
    protected FnPlotValue<?> result;	// result of evaluation

    /**
     * The global environment associated with this evaluator.
     */
    protected Environment<FnPlotValue<?>> globalEnv;
    
    /**
     * The plotting device used by this interpreter.
     */
    private Plotter plotter;

    public Evaluator() {
	// perform initialisations here
	result = FnPlotValue.make(0.0);
        globalEnv = new Environment<>();
    }
    
    /**
     * @return The global environment used by this evaluator.  This will be the
     * parent environemnt of all environments that might arise during the 
     * tree walk of an AST that this Evaluator instance may perform.
     */
    public Environment<FnPlotValue<?>> getGlobalEnv() {
        return globalEnv;
    }

    /**
     * @return The plotting device currently being used by this interpreter
     */
    public Plotter getPlotter() {
        return plotter;
    }

    /**
     * Set the plotting device.
     * @param plotter The plotting device to be used by this interpreter.
     */
    public void setPlotter(Plotter plotter) {
        this.plotter = plotter;
    }

    /**
     * Visit a node representing the overall program.  This will be similar to
     * visiting the sequence of statements that make up the program, but is
     * provided as a separate method so that any top-level, one-time actions 
     * can be taken to initialise the context for the program, if necessary.
     * @param p The program node to be traversed.
     * @param arg The environment to be used while traversing the program.
     * @return The result of the last statement of the program, after evaluating
     * all the preceding ones in order.
     * @throws FnPlotException if any of the statements in the body of the 
     * program throws an exception.
     */
    @Override
    public FnPlotValue<?> visitArithProgram(ArithProgram p, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	result = p.getSeq().visit(this, arg);
	return result;
    }

    @Override
    public FnPlotValue<?> visitStmtSequence(StmtSequence sseq, Environment<FnPlotValue<?>> env)
	throws FnPlotException {
	ArrayList<Statement> seq = sseq.getSeq();
	Iterator<Statement> iter = seq.iterator();
	result = FnPlotValue.make(0.0); // default result
        for (Statement s : seq) {
            result = s.visit(this, env);
        }
	// return last value evaluated
	return result;
    }

    @Override
    public FnPlotValue<?> visitStmtDefinition(StmtDefinition sd, Environment<FnPlotValue<?>> env)
	throws FnPlotException {
	result = sd.getExp().visit(this, env);
	
	if (result.getType() == FnPlotType.FUNCTION){
		FnPlotFunction fun = (FnPlotFunction) result;
		String arity = ": SMPL~KOUGD7~FUNCTION" + fun.getFunExp().getParameters().size();
		//System.out.print(result.getType());
		env.put(sd.getVar()+arity, result);
		return result;
	}
	
	env.put(sd.getVar(), result);
	return result;
    }

    @Override
    public FnPlotValue<?> visitStmtLet(StmtLet let, Environment<FnPlotValue<?>> env) 
	throws FnPlotException {
	ArrayList<Binding> bindings = let.getBindings();
	Exp body = let.getBody();

	int size = bindings.size();
	String[] vars = new String[size];
	FnPlotValue<?>[] vals = new FnPlotValue<?>[size];
	Binding b;
	for (int i = 0; i < size; i++) {
	    b = bindings.get(i);
	    vars[i] = b.getVar();
	    // evaluate each expression in bindings
	    result = b.getValExp().visit(this, env);
	    vals[i] = result;
	}
	// create new env as child of current
	Environment<FnPlotValue<?>> newEnv = new Environment<> (vars, vals, env);
	return body.visit(this, newEnv);
    }



//-----------------------------------------------------------------------------------------------------------------
	public FnPlotValue<?> visitFnDefn(ExpFunction def, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	FnPlotFunction c = new FnPlotFunction (def, arg);
	return c;

	}

//-------------------------------------------------------------------------------------------------------------------

    	public FnPlotValue<?> visitFnCall (ExpCall callExp, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	String name = callExp.getName();
	ArrayList <Exp> args = callExp.getArgs();
	ExpFunction defin = callExp.getDef();
	FnPlotFunction fun;

	
	if (name == null){
		fun = new FnPlotFunction (defin, arg);
	}
	else{
		//FnPlotValue<?> fun = (FnPlotFunction) arg.get(name);
		String arity = ": SMPL~KOUGD7~FUNCTION" + args.size();
		fun = (FnPlotFunction) arg.get(name + arity);
	}

	ArrayList<FnPlotValue> values = new ArrayList<>();
	
	for (Exp funarg: args){ values.add(funarg.visit(this, arg));}
	
	
	Environment newEnvir = new Environment(fun.getFunExp().getParameters(), values, fun.getClosingEnv());

	return fun.getFunExp().getBody().visit(this, newEnvir);

	}

//-------------------------------------------------------------------------------------------------------------------

	public FnPlotValue<?> visitPlot(ExpPlot exp, Environment arg) throws FnPlotException{
	
	double h = exp.getHigh();
	double l = exp.getLow();
	Exp f = exp.getFunc();
	String id = exp.getId();


	/*FnPlotFrame jf = new FnPlotFrame();
	plotter = jf.getEval().getPlotter();*/
	
	double [] sample = plotter.sample(l,h);
	
	Point2D [] output = new Point2D [sample.length];

	FnPlotValue<?> el;

	//new environment to visit expression is id and individual sample
	Environment newEnvir = new Environment();

	newEnvir.setParent(arg);
	
	for (int i=0; i< sample.length; i++){
	
		//make literal using the current double in sample array
		el = FnPlotValue.make(sample[i]);

		//change assignment of id in environ with new literal	
		newEnvir.put(id, el);

		//evaluate function is environment with new literal and add double value to output
		output[i] = new Point2D.Double(sample[i], f.visit(this, newEnvir).doubleValue());

		//System.out.println(el);
	}

	plotter.plot(output);

	//System.out.println(sample);

	return new FnNull();

}


public FnPlotValue<?> visitClear(ExpClear exp, Environment arg) throws FnPlotException{

	plotter.clear();

	System.out.println(exp);

	return new FnNull();

}


//---------------VECTOR----------------------------------------------------------------------------------------------------
    
public FnPlotValue<?> visitVector (ExpVector exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	//String name = exp.getName();
	ArrayList <Exp> args = exp.getArgs();
	//ExpFunction defin = callExp.getDef();
	FnVector vec;
	
	ArrayList<FnPlotValue> values = new ArrayList<>();
	
	for (Exp funarg: args){ 
		if (funarg instanceof ExpSubVector || funarg instanceof ExpVecComp){
			FnVector subvec = (FnVector) funarg.visit(this, arg);
			values.addAll(subvec.getData());
		}
		else{
			values.add(funarg.visit(this, arg));
		}
	}
	
	vec = new FnVector(values);

	return vec;

	}


public FnPlotValue<?> visitSubVector (ExpSubVector exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{


	Exp size = exp.getSize();
	Exp proc = exp.getProc();

	FnPlotValue<?> val1, val2;

	//FnPlotReal max = (FnPlotReal) size.visit(this,arg);
	FnPlotValue max = size.visit(this,arg);
	FnPlotFunction fun = (FnPlotFunction) proc.visit(this,arg);

	ArrayList<FnPlotValue> results = new ArrayList<>();

	for (int i=0; i< max.intValue(); i++){
		ArrayList<FnPlotValue> values = new ArrayList<>();
		values.add(FnPlotValue.make(i));
		Environment newEnvir = new Environment(fun.getFunExp().getParameters(), values, fun.getClosingEnv());
		results.add(fun.getFunExp().getBody().visit(this, newEnvir));
	}

	FnVector vec;
	
	vec = new FnVector(results);

	return vec;

}

public FnPlotValue<?> visitVecComp (ExpVecComp exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	String var = exp.getId();
	Exp start = exp.getStart();
	Exp end = exp.getStop();
	Exp body = exp.getBody();
	Exp condition = exp.getCondition();

	FnBool cond;
	boolean check;

	FnPlotValue<?> val1, val2;
	
	FnPlotValue min = start.visit(this,arg);
	FnPlotValue max = end.visit(this,arg);

	Environment<FnPlotValue<?>> newEnv = new Environment<> ();

	ArrayList<FnPlotValue> results = new ArrayList<>();

	for (int i= min.intValue(); i< max.intValue(); i++){
		newEnv.put(var , FnPlotValue.make(i));
		cond = (FnBool)condition.visit(this, newEnv);
		check = cond.getValue();
		if(check){ results.add(body.visit(this, newEnv)); }
	}

	FnVector vec;
	
	vec = new FnVector(results);

	return vec;

}



/**------------------------PAIR------------------------------------------------------------------------*/

public FnPlotValue<?> visitNull (ExpNull exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	return new FnNull();

	}




public FnPlotValue<?> visitPair (ExpPair exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	Exp car = exp.getExpL();
	Exp cdr = exp.getExpR();
	
	FnPair pair;

	FnPlotValue<?> v1, v2;
	v1 = (FnPlotValue) car.visit(this, arg);
	v2 = (FnPlotValue) cdr.visit(this, arg);

	//System.out.println(v1);
        //System.out.println(v2);
	
	pair = new FnPair(v1, v2);

	return pair;

	}



public FnPlotValue<?> visitIndex (ExpIndex exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{
	
	FnPlotValue<?> block = exp.getExp().visit(this, arg);
	FnPlotValue<?> indexF = exp.getIndex().visit(this, arg);
	FnPlotType type = block.getType();


	int index = indexF.intValue();
	
	if (type == FnPlotType.PAIR){
		FnPair block1 = (FnPair) block;
		if (index == 0){ 
			return block1.getCar(); 
		}
		else { 
			return block1.getCdr();
		}
	}
	else{
		FnVector block1 = (FnVector) block;
		return block1.getElement(index);
	}

	//new FnNull();
}



public FnPlotValue<?> visitSize (ExpSize exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	String flag = exp.getFlag();
	Exp e1 = exp.getExpL();
	Exp e2 = exp.getExpR();
	Exp v = exp.getVector();
	
	FnPlotValue<?> val1, val2 ;
	FnVector valSize;

	//System.out.println(flag);

	if (flag.equals("size")){

		valSize = (FnVector) v.visit(this, arg);
		return valSize.getSize();
		
	}

	else if (flag.equals("type")){
		val1 = e1.visit(this, arg);
		val2 = e2.visit(this, arg);

		if (val1.getType() == FnPlotType.PAIR){
			//System.out.println(true);
			return FnPlotValue.make(true);
		}
		else {
			//System.out.println(false);
			return FnPlotValue.make(false);
		}	
	}

	else if (flag.equals("eqv")){
		val1 = e1.visit(this, arg);
		val2 = e2.visit(this, arg);

		if (val1 == val2){
			//System.out.println(true);
			return FnPlotValue.make(true);
		}
		else {
			//System.out.println(false);
			return FnPlotValue.make(false);
		}	
	}

	else if (flag.equals("equal")){
		val1 = e1.visit(this, arg);
		val2 = e2.visit(this, arg);
		//return val1.equals(val2);

		if (val1.equals(val2)){
			//System.out.println(true);
			return FnPlotValue.make(true);
		}
		else {
			//System.out.println(false);
			return FnPlotValue.make(false);
		}

	}
	else{
		return new FnNull();
	}
			
}
//-----------------------------------------------------------------COMPARISON--------------------------------------

public FnPlotValue<?> visitCompare (ExpCompare exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	String flag = exp.getOp();
	Exp e1 = exp.getExpL();
	Exp e2 = exp.getExpR();

	FnPlotValue val1 = e1.visit(this, arg);
	FnPlotValue val2 = e2.visit(this, arg);

	//System.out.println(flag);

	if (flag.equals("<")){

		if (val1.doubleValue() < val2.doubleValue()){
			return FnPlotValue.make(true);
		}
		else {
			return FnPlotValue.make(false);
		}	
		
	}
	else if (flag.equals("!=")){

		if (val1.doubleValue()  != val2.doubleValue()){
			
			return FnPlotValue.make(true);
		}
		else {
			
			return FnPlotValue.make(false);
		}	
	}

	else if (flag.equals("=")){

		if (val1.doubleValue()  == val2.doubleValue()){
			
			return FnPlotValue.make(true);
		}
		else {
			
			return FnPlotValue.make(false);
		}	
	}

	else if (flag.equals(">")){

		if (val1.doubleValue()  > val2.doubleValue()){
			
			return FnPlotValue.make(true);
		}
		else {
			
			return FnPlotValue.make(false);
		}	
	}

	else if (flag.equals("<=")){

		if (val1.doubleValue()  <= val2.doubleValue()){
			
			return FnPlotValue.make(true);
		}
		else {
			
			return FnPlotValue.make(false);
		}	
	}
	else if (flag.equals(">=")){

		if (val1.doubleValue()  >= val2.doubleValue()){
			
			return FnPlotValue.make(true);
		}
		else {
			
			return FnPlotValue.make(false);
		}	
	}


	else {
		return new FnNull();
	}
			
}

public FnPlotValue<?> visitLogOp (ExpLogOp exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	String flag = exp.getOp();
	Exp e1 = exp.getExpL();
	Exp e2 = exp.getExpR();

	FnBool val1 = (FnBool) e1.visit(this, arg);
	FnBool val2 = (FnBool) e2.visit(this, arg);

	//System.out.println(flag);

	if (flag.equals("and")){
		if (val1.getValue() && val2.getValue()) {return FnPlotValue.make(true);}
		else {return FnPlotValue.make(false);}
	}

	else if (flag.equals("or")){
		if (val1.getValue() || val2.getValue()) {return FnPlotValue.make(true);}
		else {return FnPlotValue.make(false); }	
	}

	else if (flag.equals("not")){

		if (! val1.getValue()) {return FnPlotValue.make(true);}
		else {return FnPlotValue.make(false);}
	}
	else { 
		return new FnNull();
	}
		
}

//-----------------------------------------------------------------LIST--------------------------------------------


public FnPlotValue<?> visitList (ExpList exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{
//CHANGE FNPLOTVALUE FROM ZERO (0) TO A NEW FNVALUE NIL
	
	ArrayList <Exp> args = exp.getArgs();
	
	ArrayList<FnPair> values = new ArrayList<>();
	
	FnPair next;
	FnPair current;

	//current = new FnPair(FnPlotValue.make(0), FnPlotValue.make(0));
	current = new FnPair(new FnNull(), new FnNull());
	FnPair head = current;

	for (Exp funarg: args){ 
		//next = new FnPair(FnPlotValue.make(0), FnPlotValue.make(0));
		next = new FnPair(new FnNull(), new FnNull());
		current.setCar(funarg.visit(this, arg));
		current.setCdr(next);

		current = next;
		values.add(current);
		
	}

	current.setCdr(new FnNull());

	//System.out.print(current);
	//return null;
	return head;

}



public FnPlotValue<?> visitListCall (ExpListCall exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{
	
	FnPlotValue<?> val1, val2, result;
	
	FnPlotFunction fun;
	
	val2 =  exp.getList().visit(this, arg);

	//System.out.println(val1);
	//System.out.println(val2);
	//System.out.print(exp.getList() instanceof ExpList);

	
	if (exp.getProc() instanceof ExpVar && exp.getList() instanceof ExpList){
		ExpList lst = (ExpList)exp.getList();
		ExpVar var = (ExpVar)exp.getProc();
		ArrayList<Exp> args = lst.getArgs();
		String name = var.getVar();
		String arity = ": SMPL~KOUGD7~FUNCTION" + args.size();
		fun = (FnPlotFunction) arg.get(name + arity);
		}
	else if (exp.getProc() instanceof ExpVar && exp.getList() instanceof ExpVar){
		ExpVar lst = (ExpVar)exp.getList();
		ExpVar var = (ExpVar)exp.getProc();
		//ArrayList<Exp> args = lst.getArgs();
		int count = 0;
		FnPair head = (FnPair) val2;
		FnPair current = head;
		while (current.getCar().getType() != FnPlotType.NULL){
			current = (FnPair)current.getCdr();
			count = count+1;
		}
		String name = var.getVar();
		String arity = ": SMPL~KOUGD7~FUNCTION" + count;
		fun = (FnPlotFunction) arg.get(name + arity);
		val2 = arg.get(lst.getVar());
		}
	else{
		fun = (FnPlotFunction) exp.getProc().visit(this, arg);
	}

	
	
	if (exp.getList() instanceof ExpVar){

		FnPair head = (FnPair) val2;

		FnPair current = head;
	
		//Maps function (with one parameter) to list. Orignal interpretion /*call(f, list(1, 2, 3))*/
		/*while (current.getCar().getType() != FnPlotType.NULL){
			
			ArrayList<FnPlotValue> values = new ArrayList<>();

			values.add(current.getCar());
			
			Environment newEnvir = new Environment(fun.getFunExp().getParameters(), values, fun.getClosingEnv());
			
			result = fun.getFunExp().getBody().visit(this, newEnvir);

			current.setCar(result);

			current = (FnPair)current.getCdr();}*/

		ArrayList<FnPlotValue> values = new ArrayList<>();
		while (current.getCar().getType() != FnPlotType.NULL){
			
			values.add(current.getCar());

			current = (FnPair)current.getCdr();
		}
		Environment newEnvir = new Environment(fun.getFunExp().getParameters(), values, fun.getClosingEnv());
		return fun.getFunExp().getBody().visit(this, newEnvir);
	}
	
	else{
		ExpList list = (ExpList) exp.getList();

		//FnPlotFunction fun = (FnPlotFunction) val1;

		ArrayList <Exp> args = list.getArgs();
	

		ArrayList<FnPlotValue> values = new ArrayList<>();
	
		for (Exp funarg: args){ values.add(funarg.visit(this, arg));}
	
	
		Environment newEnvir = new Environment(fun.getFunExp().getParameters(), values, fun.getClosingEnv());

		return fun.getFunExp().getBody().visit(this, newEnvir);
	}
}



public FnPlotValue<?> visitConcat (ExpConcat exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{
	
	FnPlotValue<?> val1, val2, result;

	val1 =  exp.getList1().visit(this, arg);
	val2 =  exp.getList2().visit(this, arg);


	FnPair head1 = (FnPair) val1;
	FnPair head2 = (FnPair) val2;

	FnPair current = head1;
	
	FnPair prev = null; 

	while (current.getCar().getType() != FnPlotType.NULL){
		
		prev = (FnPair) current;	
		current = (FnPair)current.getCdr();

	}
		
	prev.setCdr(head2);
	return head1;
}

//------------------------------------------SELECTION---------------------------------------------------------------------

    public FnPlotValue<?> visitIf (ExpIf exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	
	Exp ifBody = exp.getIf();
	Exp elseBody = exp.getElse();
	Exp condition = exp.getCondition();

	FnBool test = (FnBool) condition.visit(this, arg);
	
	if (test.getValue()){
		return ifBody.visit(this, arg);
	}
	else{
		
		return elseBody.visit(this, arg);
	}
   }



public FnPlotValue<?> visitCase (ExpCase exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	ArrayList <Exp> cases = exp.getCases();
	
	for (Exp c : cases){
		ExpIf  bc = (ExpIf) c;

		if (bc.getIf() == null && bc.getCondition() == null){
			return bc.getElse().visit(this, arg);	
		}
		else{
			Exp ifBody = bc.getIf();
			Exp condition = bc.getCondition();
			
			FnBool test = (FnBool) condition.visit(this, arg);
			
			if (test.getValue()){
				return ifBody.visit(this, arg);
			}
		}
	}
	return new FnNull();
   }



/**-------------------------Binary Heap----------------------------------------------------------------------------*/

public FnPlotValue<?> visitHeap (ExpHeap exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{
	
	Exp e = exp.getExp();
	String flag = exp.getFlag();

	
	if (flag.equals("heapify")){
		FnVector vec = (FnVector) e.visit(this, arg);
		ArrayList <FnPlotValue> vecData =  vec.getValue();
		PriorityQueue<Double> pQ = new PriorityQueue<Double>();

		for (FnPlotValue v :vecData){
			pQ.add(v.doubleValue());
		}
		return new FnHeap (pQ);
		
	}
	
	else if (flag.equals("deletemin")){
		FnHeap heap = (FnHeap) e.visit(this, arg);
		return FnPlotValue.make(heap.getValue().poll());
	}

	else if (flag.equals("getmin")){
		FnHeap heap = (FnHeap) e.visit(this, arg);
		return FnPlotValue.make(heap.getValue().peek());
	}

	else if (flag.equals("insert")){
		FnHeap heap = (FnHeap) e.visit(this, arg);
		FnPlotValue<?> insert = exp.getInsert().visit(this,arg);
		heap.getValue().add(insert.doubleValue());
		return heap;
	}
	else{
	}
	return new FnNull();
}


//--------------------------------LOOP------------------------------------------------------------------------------

    public FnPlotValue<?> visitLoop (ExpLoop exp, Environment<FnPlotValue<?>> env) 
	throws FnPlotException {
	
	String flag = exp.getFlag();
	//Exp e1 = exp.getExp();
	
	if (flag.equals("for")){
		Exp e1 = exp.getExp();
		
		ArrayList<Binding> bindings = new ArrayList<>();
		bindings.add(exp.getBinding());
		Exp body = exp.getExp2();

		int size = bindings.size();
		String[] vars = new String[size];
		FnPlotValue<?>[] vals = new FnPlotValue<?>[size];
		Binding b;
		for (int i = 0; i < size; i++) {
		    b = bindings.get(i);
		    vars[0] = b.getVar();
		    // evaluate each expression in bindings
		    result = b.getValExp().visit(this, env);
		    vals[0] = result;
		}
		// create new env as child of current
		Environment<FnPlotValue<?>> newEnv = new Environment<> (vars, vals, env);

		//for loop for valuation
		/*FnPlotReal start = (FnPlotReal)result; 
		FnPlotReal stop = (FnPlotReal) e1.visit(this, env);*/
		FnPlotValue start = result; 
		FnPlotValue stop = e1.visit(this, env);

		int startInt = start.intValue();
		int stopInt = stop.intValue();
		for (int i = startInt; i < stopInt+1; i++){
			vals[0] = FnPlotValue.make(i);
			newEnv.put(vars[0], vals[0]);
			result = body.visit(this, newEnv);
			//System.out.println(vars[0]);
			//System.out.println(vals[0]);
			//System.out.println(result);
		}
		return result;

	}
	else if (flag.equals("while")){

		Exp body = exp.getExp();
		Exp condition = exp.getExp2();
		String[] vars = new String[0];
		FnPlotValue<?>[] vals = new FnPlotValue<?>[0];
		
		// create new env as child of current
		Environment<FnPlotValue<?>> newEnv = new Environment<> (vars, vals, env);

		//while loop for valuation
		FnBool cond = (FnBool)condition.visit(this, env); 
		boolean start = cond.getValue();

		while (start){
			//vals[0] = FnPlotValue.make(i);
			//newEnv.put(vars[0], vals[0]);
			result = body.visit(this, newEnv);
			cond = (FnBool)condition.visit(this, newEnv);
			start = cond.getValue();
			
		}
		return result;

	}

	else if (flag.equals("repeat")){

		Exp body = exp.getExp();
		Exp condition = exp.getExp2();
		String[] vars = new String[0];
		FnPlotValue<?>[] vals = new FnPlotValue<?>[0];
		
		// create new env as child of current
		Environment<FnPlotValue<?>> newEnv = new Environment<> (vars, vals, env);

		//repeat loop for valuation
		FnBool cond = (FnBool)condition.visit(this, env); 
		boolean start = cond.getValue();
		
		result = body.visit(this, newEnv);
		while (!start){
			cond = (FnBool)condition.visit(this, newEnv);
			start = cond.getValue();
			if(start){break;}
			result = body.visit(this, newEnv);
		}
		return result;

	}

	return new FnNull();
  }
//--------------------------------------READ/PRINT----------------------------------------------------------------------------
public FnPlotValue<?> visitReadPrint (ExpReadPrint exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{
	
	
	String flag = exp.getFlag();

	
	if (flag.equals("print")){
		Exp e = exp.getExp();
		FnPlotValue output = e.visit(this, arg);
		System.out.print(output);
		return output;
		
	}
	
	else if (flag.equals("println")){
		Exp e = exp.getExp();
		FnPlotValue output = e.visit(this, arg);
		System.out.println(output);
		return output;
	}

	else if (flag.equals("read")){
		Scanner input = new Scanner(System.in); 
        	String s = input.nextLine();
		return FnPlotValue.make(s);
	}

	else if (flag.equals("readint")){
		Scanner input = new Scanner(System.in); 
        	int x = input.nextInt();
		return FnPlotValue.make(x);
	}
	else{
	}
	return new FnNull();
}
//-----------------------------------------------------------------------------------------------------------------  
    public FnPlotValue<?> visitExpString(ExpString exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	return exp.getVal();
    }

  
    public FnPlotValue<?> visitExpSubStr(ExpSubStr exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	
	Exp start = exp.getStart();
	Exp end = exp.getEnd();
	Exp string = exp.getString();
	
	FnPlotValue<?> val1, val2;
	
	val1 = start.visit(this,arg);
	val2 = end.visit(this,arg);
	FnString str = (FnString) string.visit(this,arg);

	return FnPlotValue.make(str.getVal().substring(val1.intValue(), val2.intValue()));
    }


   public FnPlotValue<?> visitExpBool(ExpBool exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	return exp.getVal();
    }


    @Override
    public FnPlotValue<?> visitExpAdd(ExpAdd exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	FnPlotValue<?> val1, val2;
	val1 = exp.getExpL().visit(this, arg);
	val2 = exp.getExpR().visit(this, arg);
	return val1.add(val2);
    }

    @Override
    public FnPlotValue<?> visitExpSub(ExpSub exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	FnPlotValue<?> val1, val2;
	val1 = exp.getExpL().visit(this, arg);
	val2 = exp.getExpR().visit(this, arg);
	return val1.sub(val2);
    }

    @Override
    public FnPlotValue<?> visitExpMul(ExpMul exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	FnPlotValue<?> val1, val2;
	val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
	val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
	return val1.mul(val2);
    }

    @Override
    public FnPlotValue<?> visitExpDiv(ExpDiv exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	FnPlotValue<?> val1, val2;
	val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
	val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
	return val1.div(val2);
    }

    @Override
    public FnPlotValue<?> visitExpMod(ExpMod exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	FnPlotValue<?> val1, val2;
	val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
	val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
	return val1.mod(val2);
    }


@Override
    public FnPlotValue<?> visitExpPow(ExpPow exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	FnPlotValue<?> val1, val2;
	val1 = (FnPlotValue) exp.getExpL().visit(this, arg);
	val2 = (FnPlotValue) exp.getExpR().visit(this, arg);
	return val1.pow(val2);
    }



    @Override
    public FnPlotValue<?> visitExpLit(ExpLit exp, Environment<FnPlotValue<?>> arg)
	throws FnPlotException {
	return exp.getVal();
    }

    @Override
    public FnPlotValue<?> visitExpVar(ExpVar exp, Environment<FnPlotValue<?>> env)
	throws FnPlotException {
	return env.get(exp.getVar());
    }
}

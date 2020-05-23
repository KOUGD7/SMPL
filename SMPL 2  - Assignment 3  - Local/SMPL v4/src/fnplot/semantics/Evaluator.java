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

import fnplot.syntax.ExpIf;

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

import fnplot.values.FnVector;
import fnplot.values.FnPair;

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
		fun = (FnPlotFunction) arg.get(name);
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
		if (funarg instanceof ExpSubVector){
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



/**PAIR-------------------------------------------------------------------------------------------------*/

public FnPlotValue<?> visitNull (ExpNull exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	return new FnNull();

	}




public FnPlotValue<?> visitPair (ExpPair exp, Environment<FnPlotValue<?>> arg) throws FnPlotException{

	Exp car = exp.getExpL();
	Exp cdr = exp.getExpR();
	
	FnPair pair;

	System.out.println(car);
        System.out.println(cdr);
	

	//ArrayList<FnPlotValue> values = new ArrayList<>();
	//for (Exp funarg: args){ values.add(funarg.visit(this, arg));}

	FnPlotValue<?> v1, v2;
	v1 = (FnPlotValue) car.visit(this, arg);
	v2 = (FnPlotValue) cdr.visit(this, arg);

	System.out.println(v1);
        System.out.println(v2);
	
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

	//return null;

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

	else if (flag.equals("equal")){
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

	else if (flag.equals("eqv")){
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

	//FnPlotValue<?> val1, val2 ;

	FnPlotReal val1 = (FnPlotReal)e1.visit(this, arg);
	FnPlotReal val2 = (FnPlotReal)e2.visit(this, arg);

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

	//FnPlotValue<?> val1, val2 ;

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

	val1 =  exp.getProc().visit(this, arg);
	val2 =  exp.getList().visit(this, arg);

	//System.out.println(val1);
	//System.out.println(val2);
	//System.out.print(exp.getList() instanceof ExpList);

	
	/*call(f, list(1, 2, 3))*/
	if (exp.getList() instanceof ExpVar){

		FnPlotFunction fun = (FnPlotFunction) val1;
		FnPair head = (FnPair) val2;

		FnPair current = head;
	

		while (current.getCar().getType() != FnPlotType.NULL){
			
			ArrayList<FnPlotValue> values = new ArrayList<>();

			values.add(current.getCar());
			
			Environment newEnvir = new Environment(fun.getFunExp().getParameters(), values, fun.getClosingEnv());
			
			result = fun.getFunExp().getBody().visit(this, newEnvir);

			//System.out.println(current.getCar());
			//System.out.println(result);
			//System.out.println(current.getCdr());

			current.setCar(result);

			current = (FnPair)current.getCdr();


		}

		return head;
	}
	/*call(f, x)  function parameter as to be 1 element to apply to list*/
	else{
		ExpList list = (ExpList) exp.getList();

		//ExpFunction def = (ExpFunction) exp.getProc();
		//FnPlotFunction fun = new FnPlotFunction (def, arg)
	

		FnPlotFunction fun = (FnPlotFunction) val1;

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
//-------------------------------------------------------------------------------------------------------------------



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

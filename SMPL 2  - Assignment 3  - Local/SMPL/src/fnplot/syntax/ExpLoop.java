package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

public class ExpLoop extends Exp {
  
    Binding bind;
    Exp exp1;
    Exp exp2;
    String flag;


    public ExpLoop() {
        super();
    }

    public ExpLoop(Exp e1,  Exp e2, String f) {
        exp1 = e1;
	exp2 = e2;
	flag = f;
    }

   public ExpLoop(Binding b, Exp e1, Exp e2, String f) {
   	bind = b;
        exp1 = e1;
        exp2 = e2;
	flag = f;
    }
    
    public Binding getBinding() {
        return bind;
    }

    public Exp getExp() {
        return exp1;
    }

    public Exp getExp2() {
        return exp2;
    }
   
    public String getFlag() {
        return flag;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitLoop(this, arg);
    }

    @Override
    public String toString() {
        return flag;//String.format("%s (%s,%s,%s)", bind, exp1, exp2);
	
    }
}

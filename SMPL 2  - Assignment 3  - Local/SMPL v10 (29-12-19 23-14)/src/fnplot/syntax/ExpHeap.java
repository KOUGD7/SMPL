package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

public class ExpHeap extends Exp {

    Exp exp1;
    Exp insert;
    
    String flag;


    public ExpHeap() {
        super();
    }

    public ExpHeap(Exp e1, String f) {
        exp1 = e1;
	flag = f;
    }

   public ExpHeap(Exp e1, Exp e2, String f) {
        exp1 = e1;
	insert = e2;
	flag = f;
    }


    public Exp getExp() {
        return exp1;
    }

    public Exp getInsert() {
        return insert;
    }


    public String getFlag() {
        return flag;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitHeap(this, arg);
    }

    @Override
    public String toString() {
        return flag +"("+ exp1.toString()+")";
    }
}

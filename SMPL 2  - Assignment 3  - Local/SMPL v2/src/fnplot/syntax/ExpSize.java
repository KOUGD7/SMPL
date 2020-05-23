package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

public class ExpSize extends Exp {

    Exp exp1;
    Exp exp2;
    Exp vector;
    String flag;


    public ExpSize() {
        super();
    }

    public ExpSize(Exp e1, Exp e2, String f) {
        exp1 = e1;
        exp2 = e2;
	vector = null;
	flag = f;
    }

    public ExpSize(Exp v, String f) {
        exp1 = null;
        exp2 = null;
	vector = v;
	flag = f;
    }

    public Exp getExpL() {
        return exp1;
    }

    public Exp getExpR() {
        return exp2;
    }

    public Exp getVector() {
        return vector;
    }

    public String getFlag() {
        return flag;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitSize(this, arg);
    }

    @Override
    public String toString() {
        return flag;
    }
}

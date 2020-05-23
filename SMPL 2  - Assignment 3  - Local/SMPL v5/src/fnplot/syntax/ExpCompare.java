package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

public class ExpCompare extends Exp {

    Exp exp1;
    Exp exp2;
    String flag;


    public ExpCompare() {
        super();
    }

    public ExpCompare(Exp e1, Exp e2, String f) {
        exp1 = e1;
        exp2 = e2;
	flag = f;
    }


    public Exp getExpL() {
        return exp1;
    }

    public Exp getExpR() {
        return exp2;
    }


    public String getOp() {
        return flag;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitCompare(this, arg);
    }

    @Override
    public String toString() {
        return exp1.toString() + flag + exp2.toString();
    }
}

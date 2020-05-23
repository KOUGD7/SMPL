package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

public class ExpReadPrint extends Exp {

    Exp exp1;
    String flag;


    public ExpReadPrint() {
        super();
    }

    public ExpReadPrint(Exp e1, String f) {
        exp1 = e1;
	flag = f;
    }

    public ExpReadPrint(String f) {
	flag = f;
    }


    public Exp getExp() {
        return exp1;
    }


    public String getFlag() {
        return flag;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitReadPrint(this, arg);
    }

    @Override
    public String toString() {
        return flag +"("+ exp1.toString()+")";
    }
}

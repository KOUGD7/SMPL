package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

public class ExpIndex extends Exp {

    Exp exp;
    Exp index;

    public ExpIndex(Exp e1, Exp i) {
        exp = e1;
        index = i;
    }

    public Exp getExp() {
        return exp;
    }

    public Exp getIndex() {
        return index;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitIndex(this, arg);
    }

    @Override
    public String toString() {
        return exp.toString() + " ["+ index.toString() +"]";
    }
}

package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;
import fnplot.values.FnPlotValue;

/**
 * Class to represent numerical literals in the AST.
 * @author newts
 */
public class ExpString extends Exp {

    FnPlotValue<?> val;
    
    public ExpString(FnPlotValue<?> v) {
        val = v;
    }

    public ExpString(String v) {
        val = FnPlotValue.make(v);
    }

    public ExpString(Character v) {
        val = FnPlotValue.make(v);
    }
    

    public FnPlotValue<?> getVal() {
        return val;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitExpString(this, arg);
    }

    @Override
    public String toString() {
        return val.toString();
    }
}

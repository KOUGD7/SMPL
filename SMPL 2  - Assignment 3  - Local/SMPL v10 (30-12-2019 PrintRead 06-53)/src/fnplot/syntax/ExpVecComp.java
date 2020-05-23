package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

public class ExpVecComp extends Exp {
  
    String id;
    Exp body;
    Exp start;
    Exp stop;
    Exp condition = new ExpBool(new Boolean(true));
    


    public ExpVecComp() {
        super();
    }


   public ExpVecComp(String var, Exp b, Exp begin, Exp end, Exp c) {
   	id = var;
        body = b;
        start = begin;
	stop = end;
	condition = c;
    }
    
    public String getId() {
        return id;
    }

    public Exp getBody() {
        return body;
    }

    public Exp getStart() {
        return start;
    }

    public Exp getStop() {
        return stop;
    }
   
    public Exp getCondition() {
        return condition;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitVecComp(this, arg);
    }

    @Override
    public String toString() {
        return "Vector Comprehension" + body.toString();//String.format("%s (%s,%s,%s)", bind, exp1, exp2);
	
    }
}

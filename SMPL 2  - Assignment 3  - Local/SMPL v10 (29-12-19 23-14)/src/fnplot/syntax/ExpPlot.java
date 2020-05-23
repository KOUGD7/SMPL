/*
 * ExpFunction.java
 * Created on 14-Nov-2016, 9:41:02 PM
 */

/*
 * Copyright (C) 2016 newts
 * Produced as part of course software for COMP3652 at UWI, Mona
 * If you have any questions about this software, please contact
 * the author.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;
import java.util.ArrayList;

/**
 *
 * @author newts
 */
public class ExpPlot  extends Exp {
    
    String name;
    double high;
    double low;
    Exp Func;

    public ExpPlot() {
        super();
    }

    public ExpPlot(Exp e1, String id, double hi, double lo) {
        
	this.name = id;
	this.high = hi;
	this.low = lo;
	this.Func = e1;
	//this.parameters = parameters;
        //this.body = body;
    }

    public String getId() {
        return name;
    }    

    public Exp getFunc() {
        return Func;
    }

    public double getHigh(){
	return high;
    }

    public double getLow(){
	return low;
     }
    
    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        return v.visitPlot(this, state);
    }

    @Override
    public String toString() {

	return String.format("(plot %s for %s in [%s: %s])", Func.toString(), name, String.valueOf(high)+"", String.valueOf(low)+"");

        /*String paramStr = "";
        if (parameters.size() > 0) {
            paramStr = parameters.get(0);
        }
        for (int i = 1; i < parameters.size(); i++) {
            paramStr = paramStr + ", " + parameters.get(i);
        }
        return String.format("(fun (%s) -> %s)", paramStr, body);*/
    }

}

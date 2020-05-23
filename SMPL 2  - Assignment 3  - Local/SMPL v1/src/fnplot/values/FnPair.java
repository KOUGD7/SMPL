/*
 * FnPlotFunction.java
 * Created on 14-Nov-2016, 10:58:02 PM
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

package fnplot.values;

import fnplot.semantics.Environment;
import fnplot.syntax.ExpFunction;
import java.util.ArrayList;

/**
 *
 * @author newts
 */
public class FnPair extends FnPlotValue<FnPlotFunction> {
    //ExpFunction funExp;
    //Environment<FnPlotValue<?>> closingEnv;

    FnPlotValue car;
    FnPlotValue cdr;
    FnPlotValue size = FnPlotValue.make(2);

    /**
     * Create a new instance of a user-defined function.
     * @param funExp The function expression that was evaluated
     * @param closingEnv The environment over which this function is closed
     */
   
    

    public FnPair(FnPlotValue e1 , FnPlotValue e2) {
        this.car = e1;
	this.cdr = e2;
    }


    @Override
    public FnPlotType getType() {
        return FnPlotType.PAIR;
    }
    
    
    public FnPlotValue getSize() {
        return size;
    }


    public FnPlotValue getCar() {
	return car; 
     }

    public FnPlotValue getCdr() {
		return cdr; 
     }

   public void setCar(FnPlotValue f) {
	this.car = f; 
     }

    public void setCdr(FnPlotValue f) {
	this.cdr = f; 
     }
    
    @Override
    public String toString() {

        return String.format("[Pair(%s) -> (%s, %s)]", size, car.toString(), cdr.toString());
    }
    
}

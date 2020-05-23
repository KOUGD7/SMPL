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

/**
  * Modified Dec 2019 by KougD7 for Assignment 2 and Assignment 3
  */

public class FnNull extends FnPlotValue<FnPlotFunction> {
    //ExpFunction funExp;
    //Environment<FnPlotValue<?>> closingEnv;

    FnPlotValue data;

    /**
     * Create a new instance of a user-defined function.
     * @param funExp The function expression that was evaluated
     * @param closingEnv The environment over which this function is closed
     */
   
	public FnNull(){
	}
   

    	public FnPlotValue getData() {
		return data; 
    	}

	public FnPlotType getType() {
        	return FnPlotType.NULL;
    	}

   @Override
    public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	else if (obj== null) {
		return false;
	}
	else if (obj instanceof FnNull) {
		FnNull fn = (FnNull) obj;
		if ((fn.getData() == data ) || (fn.getData() == null && data ==null)){ 
			return true;
		}
	}
	return false;

    }

    
    @Override
    public String toString() {

        return String.format("%s", this.getType());
    }
    
}

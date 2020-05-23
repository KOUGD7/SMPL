/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fnplot.values;

import fnplot.sys.FnPlotException;
import static fnplot.values.FnPlotValue.make;

/**
 *
 * @author newts
 * Created on 14-Nov-2016
 */

/**
  * Modified Dec 2019 by KougD7 for Assignment 2 and Assignment 3
  */

public class FnBool extends FnPlotValue<FnPlotInt> {
    
    boolean value;

    /*public FnPlotInt() {
        this(0);
    }*/

    public FnBool(Boolean b) {
        value = b;
    }

    public FnBool(boolean b) {
        value = b;
    }
    
    @Override
    public FnPlotType getType() {
        return FnPlotType.BOOLEAN;
    }
    

    
    public boolean getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
		return true;
	}
	else if (obj== null) {
		return false;
	}
	else if (obj instanceof FnBool) {
		FnBool fn = (FnBool) obj;
		if (fn.getValue() == value){ 
			return true;
		}
	}
	return false;

    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }
}


   

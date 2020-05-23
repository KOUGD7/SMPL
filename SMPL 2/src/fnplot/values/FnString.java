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

public class FnString extends FnPlotValue<FnString> {
    
    String value;

    public FnString() {
        this("");
    }

    public FnString(String v) {
        value = v;
    }
    
    @Override
    public FnPlotType getType() {
        return FnPlotType.STRING;
    }

    
    
    public String getVal() {
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
	else if (obj instanceof FnString) {
		FnString fn = (FnString) obj;
		if (fn.getVal().equals(value)){ 
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

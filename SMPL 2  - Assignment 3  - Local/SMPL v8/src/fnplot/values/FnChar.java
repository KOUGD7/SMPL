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
public class FnChar extends FnPlotValue<FnString> {
    

    char value;

    public FnChar() {
        this(" ".charAt(0));
    }

    public FnChar(Character v) {
        value = v;
    }
    
    @Override
    public FnPlotType getType() {
        return FnPlotType.CHAR;
    }

    public char getVal() {
        return value;
  }
     
   
    @Override
    public String toString() {
        return "Char: " + String.valueOf(value);
    }
}

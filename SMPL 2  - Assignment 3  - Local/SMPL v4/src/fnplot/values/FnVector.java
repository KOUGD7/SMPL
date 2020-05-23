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
public class FnVector extends FnPlotValue<FnPlotFunction> {
    //ExpFunction funExp;
    //Environment<FnPlotValue<?>> closingEnv;

    ArrayList <FnPlotValue> data;
    FnPlotValue size;

    /**
     * Create a new instance of a user-defined function.
     * @param funExp The function expression that was evaluated
     * @param closingEnv The environment over which this function is closed
     */
    /*public FnPlotFunction(ExpFunction funExp, Environment<FnPlotValue<?>> closingEnv) {
        this.funExp = funExp;
        this.closingEnv = closingEnv;
    }*/
    

    public FnVector(ArrayList <FnPlotValue> args) {
        this.data = args;
        this.size = FnPlotValue.make(args.size());
    }


    @Override
    public FnPlotType getType() {
        return FnPlotType.VECTOR;
    }
    
    
    public FnPlotValue getSize() {
        return size;
    }


    public FnPlotValue getElement(int i) {
	return data.get(i); 
    }

    public ArrayList <FnPlotValue> getData() {
	return data; 
    }

    public ArrayList <FnPlotValue> getValue() {
	return data; 
    }

    /*@Override
    public FnPlotFunction funValue() {
        return this;
    }

    public ExpFunction getFunExp() {
        return funExp;
    }

    public Environment<FnPlotValue<?>> getClosingEnv() {
        return closingEnv;
    }*/
    
    @Override
    public String toString() {
        String params;
        //ArrayList<String> paramList = funExp.getParameters();
        int n = data.size();
        switch (n) {
            case 0: params = ""; break;
            case 1: params = data.get(0).toString(); break;
            default: 
                params = data.get(0).toString();
                for (int i = 1; i < n; i++) {
                    params += ", " + data.get(i).toString();
                }
        }
        //String body = funExp.getBody().toString();
        return String.format("[V%s(%s)]", size, params);
    }
    
}

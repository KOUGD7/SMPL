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
import fnplot.syntax.ExpFunction;
import fnplot.sys.FnPlotException;
import java.util.ArrayList;

/**
 *
 * @author newts
 */
public class ExpList extends Exp {
    
    ArrayList<Exp> args;
    //String name;
    //ExpFunction funcDef;
    

    public ExpList() {
        super();
    }

    public ExpList(ArrayList<Exp> argsList) {
        this.args = argsList;
    }


    public ArrayList<Exp> getArgs() {
        return args;
    } 

    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        return v.visitList(this, state);
    }

    @Override
    public String toString() {
	StringBuilder argStr = new StringBuilder("");
        //String paramStr = "";
        if (args.size() > 0) {
            //paramStr = args.get(0);
		argStr.append (args.get(0));
        }
        for (int i = 1; i < args.size(); i++) {
            //paramStr = paramStr + ", " + args.get(i);
	argStr.append (", ");
	argStr.append (args.get(i));

        }
	/*if (name == null){
		return String.format("(%s)(%s)",funcDef, argStr.toString()); 
	}*/
        return String.format("%s", argStr.toString());
    }

}

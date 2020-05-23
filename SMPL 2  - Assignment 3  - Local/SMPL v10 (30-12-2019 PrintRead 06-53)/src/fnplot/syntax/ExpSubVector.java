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
public class ExpSubVector extends Exp {
    
    Exp size;
    Exp proc;
    //String name;
    //ExpFunction funcDef;
    

    public ExpSubVector() {
        super();
    }

    public ExpSubVector(Exp s, Exp p) {
        this.size = s;
	this.proc = p;
    }


    public Exp getSize() {
        return size;
    } 

    public Exp getProc() {
        return proc;
    } 

    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        return v.visitSubVector(this, state);
    }

    @Override
    public String toString() {
        return String.format("%s %s", size.toString(), proc.toString());
    }

}

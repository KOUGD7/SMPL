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

/**
  * Modified Dec 2019 by KougD7 for Assignment 2 and Assignment 3
  */

public class ExpConcat extends Exp {
    
    Exp lst1;
    Exp lst2;
   

    public ExpConcat() {
        super();
    }

    public ExpConcat (Exp e1, Exp e2) {
        this.lst1 = e1;
        this.lst2 = e2;
    }


    public Exp getList1() {
        return lst1;
    }

    public Exp getList2() {
        return lst2;
    }

    @Override
    public <S, T> T visit(Visitor<S, T> v, S arg) throws FnPlotException {
        return v.visitConcat(this, arg);
    }

    @Override
    public String toString() {
        return  lst1.toString() + " @ " + lst2.toString();
    }

}

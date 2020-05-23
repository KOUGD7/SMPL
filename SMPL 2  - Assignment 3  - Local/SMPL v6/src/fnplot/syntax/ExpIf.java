/*
 * ExpIf.java
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
public class ExpIf  extends Exp {
    
    Exp condition;
    Exp body1;
    Exp body2;

    public ExpIf() {
        super();
    }

    public ExpIf(Exp c, Exp b1, Exp b2) {
        this.condition = c;
        this.body1 = b1;
	this.body2 = b2;
    }

    public ExpIf(Exp else1) {
    
	this.body2 = else1;
    }

    public Exp getCondition() {
        return condition;
    }    

    public Exp getIf() {
        return body1;
    }

    public Exp getElse() {
        return body2;
    }
    
    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        return v.visitIf(this, state);
    }

    @Override
    public String toString() {
   
        return String.format("if: %s then: %s else: %s", condition, body1, body2);
    }

}

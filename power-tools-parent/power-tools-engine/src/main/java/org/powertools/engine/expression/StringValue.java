/* Copyright 2012 by Martin Gijsen (www.DeAnalist.nl)
 *
 * This file is part of the PowerTools engine.
 *
 * The PowerTools engine is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * The PowerTools engine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with the PowerTools engine. If not, see <http://www.gnu.org/licenses/>.
 */

package org.powertools.engine.expression;


final class StringValue extends Value {
    private final String mText;


    StringValue (String text) {
        mText = text;
    }


    @Override
    String getType () {
        return "string";
    }


    @Override
    Value equal (Value v) {
        return new BooleanValue (mText.equals (v.toStringValue ().mText));
    }

    @Override
    Value unequal (Value v) {
        return new BooleanValue (!mText.equals (v.toStringValue ().mText));
    }

    @Override
    Value concatenate (Value v) {
        return new StringValue (mText + v.toStringValue ().mText);
    }


    @Override
    IntegerValue toIntegerValue () {
        return new IntegerValue (Integer.parseInt (mText));
    }

    @Override
    RealValue toRealValue () {
        return new RealValue (Double.parseDouble (mText));
    }

    @Override
    StringValue toStringValue () {
        return this;
    }

    @Override
    BooleanValue toBooleanValue () {
        return new BooleanValue (mText);
    }

    @Override
    public String toString () {
        return mText;
    }
}

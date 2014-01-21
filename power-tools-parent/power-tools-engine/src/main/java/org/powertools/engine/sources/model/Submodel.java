/* Copyright 2014 by Martin Gijsen (www.DeAnalist.nl)
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

package org.powertools.engine.sources.model;


public final class Submodel extends Model {
    private final String mFileName;
    
    public Submodel (String fileName, Model parent) {
        mFileName      = fileName;
        mAtNode        = false;
        mSelector      = parent.mSelector;
        mDoneCondition = parent.mDoneCondition;
    }

    @Override
    public void initialize () {
        mGraph       = DirectedGraphImpl.createGraph (mFileName);
        mCurrentNode = mGraph.getRootNode ();
        finishInit ();
    }

    @Override
    Edge selectEdge () {
        return mSelector.selectEdge (mGraph, mCurrentNode);
    }
}
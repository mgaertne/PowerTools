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

import java.util.HashSet;
import java.util.Set;


final class DoneWhenAllStatesSeen extends DoneCondition {
    private static final String DESCRIPTION = "stop after all states have been traversed";

    private final Set<String> mUnseenStates;

    
    DoneWhenAllStatesSeen () {
        super (DESCRIPTION);
        mUnseenStates = new HashSet<String> ();
    }


    @Override
    public void processNewState (String name) {
        mUnseenStates.add (name);
    }

    @Override
    public void processAtState (String name) {
        mUnseenStates.remove (name);
        mDone = mUnseenStates.isEmpty ();
    }
}
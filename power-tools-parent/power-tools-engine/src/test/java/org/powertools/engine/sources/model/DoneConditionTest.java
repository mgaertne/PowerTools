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

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class DoneConditionTest {
    private static final String DESCRIPTION = "description";
    
    @Test
    public void testGetDescription () {
        DoneCondition condition = new DoneConditionImpl ();
        assertEquals (DESCRIPTION, condition.getDescription ());
    }

    @Test
    public void testIsSatisfied () {
        DoneCondition condition = new DoneConditionImpl ();
        condition.start (null);
        condition.finish (null);
        condition.processNewState ("");
        condition.processNewTransition ("", "");
        condition.processAtState ("");
        condition.processAtTransition ("", "");
        assertFalse (condition.isSatisfied ());
    }

    public class DoneConditionImpl extends DoneCondition {
        public DoneConditionImpl() {
            super (DESCRIPTION);
        }
    }
}

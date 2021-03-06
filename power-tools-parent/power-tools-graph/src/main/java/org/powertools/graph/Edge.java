/* Copyright 2013 by Martin Gijsen (www.DeAnalist.nl)
 *
 * This file is part of the PowerTools.
 *
 * The PowerTools are free software: you can redistribute them and/or
 * modify them under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * The PowerTools are distributed in the hope that they will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with the PowerTools. If not, see <http://www.gnu.org/licenses/>.
 */

package org.powertools.graph;


public final class Edge extends AttributeSet {
    private final Node mSource;
    private final Node mTarget;


    Edge (Node source, Node target) {
        super ();
        mSource = source;
        mTarget = target;
    }

    public Node getSource () {
        return mSource;
    }

    public Node getTarget () {
        return mTarget;
    }
}

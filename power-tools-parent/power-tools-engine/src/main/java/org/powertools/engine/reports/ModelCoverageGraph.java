/* Copyright 2014 by Martin Gijsen (www.DeAnalist.nl)
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

package org.powertools.engine.reports;

import java.util.Date;
import org.powertools.graph.DirectedGraph;
import org.powertools.graph.Edge;
import org.powertools.graph.GraphViz;
import org.powertools.graph.Node;


public class ModelCoverageGraph implements ModelSubscriber {
    private final DirectedGraph mGraph;
    private final String mResultsDirectory;
    
    private int mEdgeNr = 0;

    
    public ModelCoverageGraph (String resultsDirectory) {
        mGraph            = new DirectedGraph ();
        mResultsDirectory = resultsDirectory;
    }
    
    public void processNewEdge (String sourceNodeName, String targetNodeName) {
        Node source = getOrCreateNode (sourceNodeName);
        Node target = getOrCreateNode (targetNodeName);
        mGraph.addEdge (source, target);
    }

    private Node getOrCreateNode (String name) {
        if (mGraph.hasNode (name)) {
            return mGraph.getNode (name);
        } else {
            return mGraph.addNode (name);
        }
    }

    public void processAtNode (String name) {
        // ignore
    }

    public void processAtEdge (String sourceNodeName, String targetNodeName) {
        Node source = mGraph.getNode (sourceNodeName);
        Node target = mGraph.getNode (targetNodeName);
        if (mGraph.hasEdge (source, target)) {
            Edge edge    = mGraph.getEdge (source, target);
            String label = edge.getLabel ();
            label        = (label.isEmpty () ? "" : label + ", ") + Integer.toString (++mEdgeNr);
            edge.setLabel (label);
            edge.setLineWidth (3);
        }
    }

    public void start (Date dateTime) {
        // ignore
    }

    public void finish (Date dateTime) {
        GraphViz graphViz = new GraphViz ("C:\\Program Files (x86)\\Graphviz 2.28\\bin");
        graphViz.writeDirected (mGraph, mResultsDirectory + "/coverage");
    }
}

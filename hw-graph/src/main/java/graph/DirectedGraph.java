package graph;

import java.util.Map;
import java.util.Set;

/**
 * DirectedGraph represents a mutable, directed graph.
 *
 * Specification fields:
 * @spec.specfield graphMap : HashMap<VertexNode, HashSet<LabeledEdge>>  // Map of all of the
 * nodes with their edges, which contain the destination nodes.
 *
 */
public class DirectedGraph {
    /**
     * Constructs a new empty DirectedGraph.
     *
     * @spec.effects constructs a new empty DirectedGraph
      */
    public DirectedGraph() {
        throw new RuntimeException("DirectedGraph() is not yet implemented");
    }

    /**
     * Adds a given node to the graph if it is not already present.
     *
     * @param v new node to be added into the graph
     * @spec.requires v != null
     * @spec.modifies this
     * @spec.effects adds new node, v, to the map of the graph
     * @return true iff this graph does not already contain the node
     */
    public boolean addNode(VertexNode v) {
        throw new RuntimeException("DirectedGraph.addNode() is not yet implemented");
    }

    /**
     * Adds a new edge to the graph if it is not already present. If either the destination
     * node or the start node doesn't exist in the graph, creates a new node/nodes.
     *
     * @param v1 start of the edge
     * @param v2 destination of the edge
     * @param s label of the edge
     * @spec.requires v1, v2, and s != null
     * @spec.modifies this
     * @spec.effects adds a new edge to the map of the graph
     * @return true iff this graph does not already contain the edge (with the same
     * destination and start)
     */
    public boolean addEdge(VertexNode v1, VertexNode v2, String s) {
        throw new RuntimeException("DirectedGraph.addEdge() is not yet implemented");
    }

    /**
     * Lists the child nodes of a given VertexNode
     *
     * @param v a node contained by the graph
     * @spec.requires v != null, v is contained in graph
     * @return a set containing all the child nodes of v
     */
    public Set<VertexNode> listChildren(VertexNode v) {
        throw new RuntimeException("DirectedGraph.listChildren() is not yet implemented");
    }

    /**
     * Lists all the nodes contained in the graph
     *
     * @spec.requires this != null and is not empty
     * @return a set containing all the nodes in the graph
     */
    public Set<VertexNode> listNodes() {
        throw new RuntimeException("DirectedGraph.listNodes() is not yet implemented");
    }

    /**
     * Finds out whether the graph contains a given node or not
     *
     * @param v the node to be searched for
     * @spec.requires v != null
     * @return true iff the node, v, is present within the graph
     */
    public boolean containsNode(VertexNode v) {
        throw new RuntimeException("DirectedGraph.containsNode() is not yet implemented");
    }

    /**
     * Finds out whether the graph contains a given edge (by label) or not
     *
     * @param l the edge to be searched for by label
     * @spec.requires l != null
     * @return true iff the edge, v, is present within the graph
     */
    public boolean containsEdge(LabeledEdge l) {
        throw new RuntimeException("DirectedGraph.containsEdge() is not yet implemented");
    }

    /**
     * Finds out whether a node is connected to another node (there
     * are edges between them)
     *
     * @param v1 the first node
     * @param v2 the second node
     * @spec.requires v1 != null && v2 != null
     * @return true iff there are edges between the nodes given
     */
    public boolean connected(VertexNode v1, VertexNode v2) {
        throw new RuntimeException("DirectedGraph.connected() is not yet implemented");
    }

    /**
     * Gets the number of nodes(vertices) in the graph
     *
     * @return the number of nodes(vertices) in the graph
     */
    public int size() {
        throw new RuntimeException("DirectedGraph.size() is not yet implemented");
    }

    /**
     * Returns true if the graph is empty.
     *
     * @return true iff the graph is empty
     */
    public boolean isEmpty() {
        throw new RuntimeException("DirectedGraph.isEmpty() is not yet implemented");
    }

    /**
     * Returns a set with the same elements as the graph.
     *
     * @return an unmodifiable set with the same elements as the graph
     */
    public Set<Map<VertexNode, Set<LabeledEdge>>> entrySet() {
        throw new RuntimeException("DirectedGraph.isEmpty() is not yet implemented");
    }

}

package graph;

import java.util.Map;
import java.util.Set;

/**
 * DirectedGraph represents a mutable, directed graph.
 *
 * Specification fields:
 * @spec.specfield graphMap : {@literal Map<VertexNode(l), Set<LabeledEdge(l,d)>>} // Map of all the
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
     * Creates a new node to put in the graph if it is not already present.
     *
     * @param l creates new node to be added into the graph
     * @spec.requires l != null
     * @spec.modifies this
     * @spec.effects adds new node to the map of the graph
     * @return true iff this graph does not already contain the node
     */
    public boolean addNode(String l) {
        throw new RuntimeException("DirectedGraph.addNode() is not yet implemented");
    }

    /**
     * Adds a new edge to the graph if it is not already present.
     *
     * @param l the label of the edge to be added
     * @param v1 the start of the edge
     * @param v2 the destination of the edge
     * @spec.requires v1, v2, and l != null, v1 and v2 are contained in the graph,
     * graphMap.size() > 1
     * @spec.modifies this
     * @spec.effects adds a new edge to the map of the graph
     * @return true iff this graph does not already contain the edge (with the same
     * destination, start, and label)
     */
    public boolean addEdge(VertexNode v1, VertexNode v2, String l) {
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
     * Finds out the number of edges connected between two nodes
     *
     * @param v1 the first node
     * @param v2 the second node
     * @spec.requires v1 != null and v2 != null
     * @return the number of edges between v1 and v2
     */
    public int numberOfEdges(VertexNode v1, VertexNode v2) {
        throw new RuntimeException("DirectedGraph.numberOfEdges() is not yet implemented");
    }

    /**
     * Finds out whether a node is connected to another node (there
     * are edges between them)
     *
     * @param v1 the first node
     * @param v2 the second node
     * @spec.requires v1 != null and v2 != null
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

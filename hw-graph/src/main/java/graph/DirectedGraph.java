package graph;

import java.util.*;

/**
 * DirectedGraph represents a mutable, directed graph. It is a graph containing nodes
 * and LabelEdges which represent the vertices and the edges connecting them on a
 * graph.
 *
 * Specification fields:
 * @spec.specfield graphMap : {@literal Map<String(l), Set<LabeledEdge(l,d)>>} // Map of all the
 * nodes with their edges, which contain the destination nodes.
 *
 */
public class DirectedGraph {

    // Abstraction Function:
    //      AF(this) = directed map m such that
    //          {} if graph is empty
    //          nodes in this = this.graphMap.keySet()
    //          edges outgoing from node n = this.graphMap.getKey(n)
    //
    // Representation Invariant for every DirectedGraph g,
    //      graphMap != null
    //      && nodes in this != null
    //      && edges in this != null

    /**
     * Holds all the nodes and outgoing edges in this
     */
    private final Map<String, Set<LabeledEdge>> graphMap;

    private static final boolean bigTest = false;

    /**
     * Constructs a new empty DirectedGraph.
     *
     * @spec.effects constructs a new empty DirectedGraph
     */
    public DirectedGraph() {
        graphMap = new HashMap<>();
        checkRep();
    }

    /**
     * Throws an exception if rep invariant is violated
     */
    private void checkRep() {
        assert (graphMap != null);

        for (String key : graphMap.keySet()) {
            assert (key != null);
        }

        if (bigTest) {
            for (Set<LabeledEdge> set : graphMap.values()) {
                for (LabeledEdge value : set) {
                    assert (value != null);
                }
            }
        }

    }

    /**
     * Creates a new node to put in the graph if it is not already present.
     *
     * @param l label of the node to be added
     * @return true iff this graph does not already contain the node
     * @spec.requires l != null
     * @spec.modifies this
     * @spec.effects adds new node to the map of the graph
     * @throws IllegalArgumentException if l == null
     */
    public boolean addNode(String l) {
        checkRep();
        if (l == null) {
            throw new IllegalArgumentException();
        }
        boolean addedNode = false;
        //Checks if graph contains same node
        if (!graphMap.containsKey(l)) {
            graphMap.put(l, new HashSet<>());
            addedNode = true;
        }
        checkRep();
        return addedNode;
    }

    /**
     * Adds a new edge to the graph if it is not already present.
     *
     * @param l  the label of the edge to be added
     * @param v1 the start of the edge
     * @param v2 the destination of the edge
     * @return true iff this graph does not already contain the edge (with the same
     * destination, start, and label)
     * @spec.requires v1, v2, and l != null
     * @spec.modifies this
     * @spec.effects adds a new edge to the map of the graph
     * @throws IllegalStateException if !(graphMap.size() &gt; 1) or v1 or v2
     * are not contained in the graph
     * @throws IllegalArgumentException if v1, v2, or l == null
     */
    public boolean addEdge(String v1, String v2, String l) {
        checkRep();
        if (v1 == null || v2 == null || l == null) {
            throw new IllegalArgumentException();
        }
        // Checks if both nodes are contained in graph, also checks size of this since
        // a size of 1 assumes that both nodes are not contained
        if (!graphMap.containsKey(v1) || !graphMap.containsKey(v2) || graphMap.size() <= 1) {
            throw new IllegalStateException();
        }

        boolean addedEdge = false;
        LabeledEdge newEdge = new LabeledEdge(v1, v2, l);
        //Checks if graph contains same edge
        if (!graphMap.get(v1).contains(newEdge)) {
            graphMap.get(v1).add(newEdge);
            addedEdge = true;
        }
        checkRep();
        return addedEdge;
    }

    /**
     * Lists the outgoing edges of a given node (includes the children nodes)
     *
     * @param v a node contained by the graph
     * @return a set containing all the outgoing edges of v (an empty set if there are
     * no children)
     * @spec.requires v != null
     * @throws IllegalArgumentException if v is not contained in the graph
     * @throws IllegalArgumentException if v == null
     */
    public Set<LabeledEdge> listChildren(String v) {
        checkRep();
        if (v == null) {
            throw new IllegalArgumentException();
        }
        if (!graphMap.containsKey(v)) {
            throw new IllegalArgumentException();
        }
        checkRep();
        return new HashSet<>(graphMap.get(v));
    }

    /**
     * Lists all the nodes contained in the graph
     *
     * @return a set containing all the nodes in the graph
     * @spec.requires this != null and is not empty
     */
    public Set<String> listNodes() {
        checkRep();
        return new HashSet<>(graphMap.keySet());
    }

    /**
     * Finds out whether the graph contains a given node or not
     *
     * @param v the node to be searched for
     * @return true iff the node, v, is present within the graph
     * @spec.requires v != null
     * @throws IllegalArgumentException if v == null
     */
    public boolean containsNode(String v) {
        checkRep();
        if (v == null) {
            throw new IllegalArgumentException();
        }
        boolean containsNode = false;
        for (String v2 : graphMap.keySet()) {
            if (v.equals(v2)) {
                containsNode = true;
            }
        }
        checkRep();
        return containsNode;
    }

    /**
     * Finds out the number of edges connected between two nodes
     *
     * @param v1 the first node
     * @param v2 the second node
     * @return the number of edges between v1 and v2
     * @spec.requires v1 != null and v2 != null
     * @throws IllegalArgumentException if v1 or v2 == null
     */
    public int numberOfEdges(String v1, String v2) {
       checkRep();
       if (v1 == null || v2 == null) {
           throw new IllegalArgumentException();
       }
       int numberOfEdges = 0;
       //Gets the edges outgoing from v1
       for (LabeledEdge e: graphMap.get(v1)) {
           if (e.getDestination().equals(v2)) {
               numberOfEdges++;
           }
       }
       //Gets the edges outgoing from v2
       for (LabeledEdge e: graphMap.get(v2)) {
           if (e.getDestination().equals(v1)) {
                numberOfEdges++;
           }
       }
       checkRep();
       return numberOfEdges;

    }

    /**
     * Finds out whether a node is connected to another node (there
     * are edges between them)
     *
     * @param v1 the first node
     * @param v2 the second node
     * @return true iff there are edges between the nodes given
     * @spec.requires v1 != null and v2 != null, v1 and v2 must
     * be contained in the graph
     * @throws IllegalStateException if v1 or v2 are not contained
     * in the graph
     * @throws IllegalArgumentException if v1 or v2 == null
     */
    public boolean connected(String v1, String v2) {
        checkRep();
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException();
        }
        if (!graphMap.containsKey(v1) || !graphMap.containsKey(v2)) {
            throw new IllegalStateException();
        }
        boolean connected = false;
        //Checks outgoing edges from v1
        for (LabeledEdge e: graphMap.get(v1)) {
            if (e.getDestination().equals(v2)) {
                connected = true;
            }
        }

        //Checks outgoing edges from v2
        for (LabeledEdge e: graphMap.get(v2)) {
            if (e.getDestination().equals(v1)) {
                connected = true;
            }
        }
        checkRep();
        return connected;
    }

    /**
     * Gets the number of nodes(vertices) in the graph
     *
     * @return the number of nodes(vertices) in the graph
     */
    public int size() {
        checkRep();
        return graphMap.size();
    }

    /**
     * Returns true if the graph is empty.
     *
     * @return true iff the graph is empty
     */
    public boolean isEmpty() {
        checkRep();
        return graphMap.isEmpty();
    }
}

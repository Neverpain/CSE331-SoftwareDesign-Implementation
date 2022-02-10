package graph;

/**
 * LabelEdge represents an edge with a label that points towards a
 * single node (or vertex).
 *
 * Specification fields:
 * @spec.specfield destination : String  // The node(vertex) this edge is pointing towards.
 * @spec.specfield start : String  // The node(vertex) this edge is coming from.
 * @spec.specfield label : String  // The label of this edge.
 */
public class LabeledEdge {

    /**
     * Constructs a new LabeledEdge.
     *
     * @param l the start of the LabeledEdge to be constructed
     * @param d the destination of the LabeledEdge to be constructed
     * @param s the start of the LabeledEdge to be constructed
     * @spec.requires d != null and l != null
     * @spec.effects constructs a new LabeledEdge, with this.destination = d,
     * this.label = l, and this.start = s
     */
    public LabeledEdge(String s, String d, String l) {
        throw new RuntimeException("LabeledEdge(String l, String d) is not " +
        "yet implemented");
    }

    /**
     * Gets the start of this LabeledEdge.
     *
     * @return returns the start of this LabeledEdge
     */
    public String getStart() {
        throw new RuntimeException("LabeledEdge.getStart() is not yet implemented");
    }

    /**
     * Gets the label of this LabeledEdge.
     *
     * @return returns the destination of this LabeledEdge
     */
    public String getDestination() {
        throw new RuntimeException("LabeledEdge.getDestination() is not yet implemented");
    }

    /**
     * Gets the label of this LabeledEdge.
     *
     * @return returns the label of this LabeledEdge
     */
    public String getLabel() {
        throw new RuntimeException("LabeledEdge.getLabel() is not yet implemented");
    }

    /**
     * Standard equality operation.
     *
     * @param obj object to be compared to this LabeledEdge
     * @return true iff obj is an instance of a LabeledEdge and this and obj
     * represent the same LabeledEdge (same destination, same start, and same label)
     */
    @Override
    public boolean equals(Object obj) {
        throw new RuntimeException("LabeledEdge.equals() is not yet implemented");
    }

    /**
     * Standard hashCode function.
     *
     * @return an int that all objects equal to this will also have
     */
    @Override
    public int hashCode() {
        throw new RuntimeException("LabeledEdge.hashCode() is not yet implemented");
    }
}

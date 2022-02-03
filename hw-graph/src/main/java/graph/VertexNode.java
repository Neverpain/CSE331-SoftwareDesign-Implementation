package graph;

/**
 * VertexNode represents a labeled vertex.
 *
 * Specification fields:
 * @spec.specfield label : String  // The label of this Vertex(could represent anything,
 * be any data type)
 */
public class VertexNode {
    /**
     * Constructs a new VertexNode.
     *
     * @param l the label of the VertexNode to be constructed
     * @spec.requires l != null
     * @spec.effects constructs a new VertexNode, with this.label = l
     */
    public VertexNode(String l) {
        throw new RuntimeException("VertexNode() is not yet implemented");
    }

    /**
     * Gets the label of this VertexNode.
     *
     * @return returns the label of this VertexNode
     */
    public String getLabel() {
        throw new RuntimeException("VertexNode.getName() is not yet implemented");
    }

    /**
     * Standard equality operation.
     *
     * @param obj object to be compared to this VertexNode
     * @return true iff obj is an instance of a VertexNode and this and obj
     * represent the same VertexNode (same label)
     */
    @Override
    public boolean equals(Object obj) {
        throw new RuntimeException("VertexNode.equals() is not yet implemented");
    }

    /**
     * Standard hashCode function.
     *
     * @return an int that all objects equal to this will also have
     */
    @Override
    public int hashCode() {
        throw new RuntimeException("VertexNode.hashCode() is not yet implemented");
    }
}

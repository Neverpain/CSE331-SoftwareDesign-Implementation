package graph;

/**
 * This class represents a labeled vertices
 *
 * Specification fields:
 * @spec.specfield label : String  // The label of this vertices(could represent anything,
 * be any data type)
 */
public class VerticesNode {
    /**
     * Constructs a new VerticesNode
     *
     * @param l the label of the VerticesNode to be constructed
     * @spec.requires l != null
     * @spec.effects Constructs a new VerticesNode, with this.label = l
     */
    public VerticesNode(String l) {
        throw new RuntimeException("VerticesNode() is not yet implemented");
    }

    /**
     * Gets the label of this VerticesNode.
     *
     * @return returns the label of this VerticesNode
     */
    public String getLabel() {
        throw new RuntimeException("VerticesNode.getName() is not yet implemented");
    }

    /**
     * Standard equality operation.
     *
     * @param obj object to be compared to this VerticesNode
     * @return true iff obj is an instance of a VerticesNode and this and obj
     * represent the same VerticesNode (same label)
     */
    @Override
    public boolean equals(Object obj) {
        throw new RuntimeException("VerticesNode.equals() is not yet implemented");
    }

    /**
     * Standard hashCode function.
     *
     * @return an int that all objects equal to this will also have
     */
    @Override
    public int hashCode() {
        throw new RuntimeException("VerticesNode.hashCode() is not yet implemented");
    }
}

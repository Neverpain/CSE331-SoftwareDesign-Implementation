package graph;

import java.awt.*;
import java.util.Comparator;

/**
 * LabelEdge represents an edge with a label that points towards a
 * single node (or vertex).
 *
 * Specification fields:
 * @spec.specfield destination : String  // The node(vertex) this edge is pointing towards.
 * @spec.specfield label : String  // The label of this edge.
 */
public class LabeledEdge {

    // Abstraction Function:
    //      AF(this) = labeled edge e such that
    //          e.destination = this.destination
    //          e.label = this.label
    //
    // Representation Invariant for every LabeledEdge l:
    //      label != null && destination != nul

    /**
     * The node the labeled edge points at
     */
    private final String destination;

    /**
     * Label of the edge
     */
    private final String label;

    /**
     * The node the labeled edge starts at
     */
    private final String start;

    /**
     * Constructs a new LabeledEdge.
     *
     * @param s the start of the LabeledEdge
     * @param l the label of the LabeledEdge
     * @param d the destination of the LabeledEdge
     * @spec.requires d != null and l != null
     * @spec.effects constructs a new LabeledEdge, with this.destination = d,
     * this.label = l, this.start = s
     */
    public LabeledEdge(String s, String d, String l) {
        if (l == null || d == null || s == null) {
            throw new IllegalArgumentException("Labeled edges cannot have null values");
        }
        destination = d;
        label = l;
        start = s;
        checkRep();
    }

    /**
     * Throws an exception if rep invariant is violated
     */
     private void checkRep() {
         assert (destination != null);
         assert (label != null);
         assert (start != null);
     }

    /**
     * Gets the destination node of this LabeledEdge.
     *
     * @return returns the destination of this LabeledEdge
     */
    public String getDestination() {
        checkRep();
        return destination;
    }

    /**
     * Gets the start node of this LabeledEdge.
     *
     * @return returns the start of this LabeledEdge
     */
    public String getStart() {
        checkRep();
        return start;
    }

    /**
     * Gets the label of this LabeledEdge.
     *
     * @return returns the label of this LabeledEdge
     */
    public String getLabel() {
        checkRep();
        return label;
    }

    /**
     * Standard equality operation.
     *
     * @param o object to be compared to this LabeledEdge
     * @return true iff obj is an instance of a LabeledEdge and this and obj
     * represent the same LabeledEdge (same destination, same start, and same label)
     */
    @Override
    public boolean equals(Object o) {
        checkRep();
        if (!(o instanceof LabeledEdge)) {
            return false;
        }
        LabeledEdge e = (LabeledEdge) o;
        checkRep();
        return hashCode() == o.hashCode();
    }

    /**
     * Standard hashCode function.
     *
     * @return an int that all objects equal to this will also have
     */
    @Override
    public int hashCode() {
        checkRep();
        return label.hashCode() + destination.hashCode() + start.hashCode();
    }
}

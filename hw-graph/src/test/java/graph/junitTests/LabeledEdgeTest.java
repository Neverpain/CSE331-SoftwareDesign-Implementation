package graph.junitTests;

import graph.LabeledEdge;
import graph.VertexNode;
import org.junit.*;
import static org.junit.Assert.*;

/** Unit tests for my LabeledEdge ADT implementation */
public class LabeledEdgeTest {

    private final LabeledEdge edge1 = new LabeledEdge("start1", "destination1", "edge1");
    private final LabeledEdge edge2 = new LabeledEdge("start1", "destination1", "edge1");
    private final LabeledEdge edge3 = new LabeledEdge("start1", "destination1", "edge12");

    @Test (expected = IllegalArgumentException.class)
    public void testsNullArgConstructor() {
        new LabeledEdge(null, "destination1", "label1");
        new LabeledEdge("start2", null, "label2");
        new LabeledEdge("start3", "destination3", null);
    }

    @Test
    public void testGetDestinationTrue() {
        assertEquals("destination1", edge1.getDestination());
    }

    @Test
    public void testGetDestinationFalse() {
        assertNotEquals("destinationFalse", edge1.getDestination());
    }

    @Test
    public void testGetStartTrue() {
        assertEquals("start1", edge1.getStart());
    }

    @Test
    public void testGetStartFalse() {
        assertNotEquals("startFalse", edge1.getStart());;
    }

    @Test
    public void testGetLabelTrue() {
        assertEquals("edge1", edge1.getLabel());
    }

    @Test
    public void testGetLabelFalse() {
        assertNotEquals("edgeFalse", edge1.getStart());;
    }

    @Test
    public void testEqualsForSameObjects() {
        assertEquals(edge1, edge2);
    }

    @Test
    public void testEqualsForDiffObjects() {
        assertNotEquals(edge1, edge3);
    }

    @Test
    public void testHashCodeForSameObjects() {
        assertEquals(edge1.hashCode(), edge2.hashCode());
    }

    @Test
    public void testHashCodeForDiffObjects() {
        assertNotEquals(edge1.hashCode(), edge3.hashCode());
    }
}

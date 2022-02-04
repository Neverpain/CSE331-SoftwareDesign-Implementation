package graph.junitTests;

import graph.LabeledEdge;
import graph.VertexNode;
import org.junit.*;
import static org.junit.Assert.*;

/** Unit tests for my LabeledEdge ADT implementation */
public class LabeledEdgeTest {

    private final VertexNode vertex1 = new VertexNode("testCase");
    private final VertexNode vertex2 = new VertexNode("testCase");

    private final LabeledEdge edge1 = new LabeledEdge(vertex1, vertex2, "edge1");
    private final LabeledEdge edge2 = new LabeledEdge(vertex1, vertex2, "edge1");
    private final LabeledEdge edge3 = new LabeledEdge(vertex1, vertex2, "edge12");

    @Test (expected = IllegalArgumentException.class)
    public void testsNullArgConstructor() {
        new LabeledEdge(null, vertex2, "null1");
        new LabeledEdge(vertex1, null, "null2");
        new LabeledEdge(vertex1, vertex2, null);
    }

    @Test
    public void testGetDestination() {
        assertEquals(vertex2, edge1.getDestination());
    }

    @Test
    public void testGetStart() {
        assertEquals(vertex1, edge1.getStart());
    }

    @Test
    public void testGetLabel() {
        assertEquals("edge1", edge1.getLabel());
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

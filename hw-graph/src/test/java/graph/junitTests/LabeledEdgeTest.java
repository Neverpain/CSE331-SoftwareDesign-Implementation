package graph.junitTests;

import graph.LabeledEdge;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.Timeout;

/** Unit tests for my LabeledEdge ADT implementation */
public class LabeledEdgeTest {
    @Rule public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested

    private final LabeledEdge edge1 = new LabeledEdge("start1", "destination1", "edge1");
    private final LabeledEdge edge2 = new LabeledEdge("start1", "destination1", "edge1");
    private final LabeledEdge edge3 = new LabeledEdge("start1", "destination1", "edge12");

    //Tests null value constructors
    @Test (expected = IllegalArgumentException.class)
    public void testsNullArgConstructor() {
        new LabeledEdge(null, "destination1", "label1");
        new LabeledEdge("start2", null, "label2");
        new LabeledEdge("start3", "destination3", null);
    }

    //Tests getting the destination is correct
    @Test
    public void testGetDestinationTrue() {
        assertEquals("destination1", edge1.getDestination());
    }

    //Tests getting the destination wrong
    @Test
    public void testGetDestinationFalse() {
        assertNotEquals("destinationFalse", edge1.getDestination());
    }

    //Tests getting the start is correct
    @Test
    public void testGetStartTrue() {
        assertEquals("start1", edge1.getStart());
    }

    //Tests getting the start wrong
    @Test
    public void testGetStartFalse() {
        assertNotEquals("startFalse", edge1.getStart());;
    }

    //Tests getting the label is correct
    @Test
    public void testGetLabelTrue() {
        assertEquals("edge1", edge1.getLabel());
    }

    //Tests getting the label wrong
    @Test
    public void testGetLabelFalse() {
        assertNotEquals("edgeFalse", edge1.getStart());;
    }

    //Tests equals for two same objects
    @Test
    public void testEqualsForSameObjects() {
        assertEquals(edge1, edge2);
    }

    //Tests equals for two different objects
    @Test
    public void testEqualsForDiffObjects() {
        assertNotEquals(edge1, edge3);
    }

    //Tests hashCodes for two same objects are same
    @Test
    public void testHashCodeForSameObjects() {
        assertEquals(edge1.hashCode(), edge2.hashCode());
    }

    //Tests hashCodes for two different objects are different
    @Test
    public void testHashCodeForDiffObjects() {
        assertNotEquals(edge1.hashCode(), edge3.hashCode());
    }
}

package graph.junitTests;

import graph.VertexNode;
import org.junit.*;
import static org.junit.Assert.*;

/** Unit tests for my VertexNode ADT implementation */
public class VertexNodeTest {

    private final VertexNode testCase1 = new VertexNode("testCase");
    private final VertexNode testCase2 = new VertexNode("testCase");
    private final VertexNode testCase3 = new VertexNode("diffTestCase");

    @Test (expected = IllegalArgumentException.class)
    public void testsNullArgConstructor() {
        new VertexNode(null);
    }

    @Test
    public void testGetLabel() {
        assertEquals("testCase", testCase1.getLabel());
    }

    @Test
    public void testEqualsForSameObjects() {
        assertEquals(testCase1.getLabel(), testCase2.getLabel());
    }

    @Test
    public void testEqualsForDiffObjects() {
        assertNotEquals(testCase1.getLabel(), testCase3.getLabel());
    }

    @Test
    public void testHashCodeForSameObjects() {
        assertEquals(testCase2.hashCode(), testCase1.hashCode());
    }

    @Test
    public void testHashCodeForDiffObjects() {
        assertNotEquals(testCase2.hashCode(), testCase3.hashCode());
    }
}

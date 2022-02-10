package graph.junitTests;

import graph.DirectedGraph;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.Timeout;

/** Unit tests for my DirectedGraph ADT implementation
 * @Rule public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested
 */

public class DirectedGraphTest {

    //Constructed DirectedGraph instance that is empty
    private final DirectedGraph graph1 = new DirectedGraph();

    //Constructed DirectedGraph instance that has one node
    private final DirectedGraph graph2 = new DirectedGraph();

    //Constructed DirectedGraph instance that has two nodes
    private final DirectedGraph graph3 = new DirectedGraph();


    @Before
    public void setUp() {
        graph3.addNode("v1");
        graph3.addNode("v2");
        graph3.addEdge("v1", "v2", "l1");

        graph2.addNode("v1");
    }

    @Test
    public void testIsEmptyOfEmptyGraph() {
        assertTrue(graph1.isEmpty());
    }

    @Test
    public void testSizeOfEmptyGraph() {
        assertEquals(0, graph1.size());
    }

    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeToEmptyGraph() {
        graph1.addEdge("v1", "v2", "l1");
    }

    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeToOneNodeGraph() {
        graph2.addEdge("v1", "v2", "l1");
    }

    @Test
    public void testSizeToOneNodeGraph() {
        assertEquals(1, graph2.size());
    }

    @Test
    public void testSizeWithTwoNodeGraph() {
        assertEquals(2, graph3.size());
    }

    @Test
    public void testIsEmptyForOneNodeGraph() {
        assertFalse(graph2.isEmpty());
    }

    @Test
    public void testIsEmptyForTwoNodeGraph() {
        assertFalse(graph3.isEmpty());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullNodeToEmptyGraph() {
        graph1.addNode(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullNodeToOneNodeGraph() {
        graph2.addNode(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullNodeToTwoNodeGraph() {
        graph3.addNode(null);
    }

    @Test
    public void testAddingNodeInOneNodeGraph() {
        assertTrue(graph2.addNode("v3)"));
    }

    @Test
    public void testAddingNodeInTwoNodeGraph() {
        assertTrue(graph3.addNode("v3)"));
    }

    @Test
    public void testAddingNodeAlreadyContainedInOneNodeGraph() {
        assertFalse(graph2.addNode("v1"));
    }

    @Test
    public void testAddingNodeAlreadyContainedInTwoNodeGraph() {
        assertFalse(graph3.addNode("v1"));
    }

    @Test
    public void testAddingEdgeAlreadyContained() {
        assertFalse(graph3.addEdge("v1", "v2", "l1"));
    }

    @Test
    public void testNumberOfEdgesBetweenTwoVertices() {
        assertEquals(1, graph3.numberOfEdges("v1", "v2"));
    }

    @Test
    public void testNumberOfEdgesBetweenTwoVerticesReverse() {
        assertEquals(1, graph3.numberOfEdges("v2", "v1"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNumberOfEdgesBetweenVertexAndNull() {
        graph2.numberOfEdges("v1", null);
    }

    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeWithSameDestinationAndStartDiffLabel() {
        graph2.addEdge("v1", "v2", "l2");
    }

    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeWithSameDestinationAndLabelDiffStart() {
        graph3.addEdge("v3", "v2", "l1");
    }

    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeWithSameStartAndLabelDiffDestination() {
        graph3.addEdge("v1", "v3", "l1");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullLabelLabelEdge() {
        graph3.addEdge("v1", "v2", null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullStartLabelEdge() {
        graph3.addEdge(null, "v2", "l1");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullDestinationLabelEdge() {
        graph3.addEdge("v1", null, "l1");
    }

    @Test
    public void testContainsNode() {
        assertTrue(graph2.containsNode("v1"));
    }

    @Test
    public void testDoesNotContainsNode() {
        assertFalse(graph2.containsNode("v4"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testContainsNullNode() {
        graph2.containsNode(null);
    }

    @Test
    public void testConnectedNodes() {
        assertTrue(graph3.connected("v1", "v2"));
    }

    @Test
    public void testConnectedNodesReverse() {
        assertTrue(graph3.connected("v2", "v1"));
    }

    @Test (expected = IllegalStateException.class)
    public void testConnectedNodesNotContained() {
        graph3.connected("v2", "v4");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConnectedNullNodes() {
        graph2.connected(null, "v1");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testListChildrenOfNullNode() {
        graph2.listChildren(null);
    }
}


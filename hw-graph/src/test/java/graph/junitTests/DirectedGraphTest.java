package graph.junitTests;

import graph.DirectedGraph;
import graph.LabeledEdge;
import graph.VertexNode;
import org.junit.*;

import static org.junit.Assert.*;

/** Unit tests for my DirectedGraph ADT implementation */
public class DirectedGraphTest {
    private final VertexNode vertex1 = new VertexNode("vertex1");
    private final VertexNode vertex2 = new VertexNode("vertex1");
    private final VertexNode vertex3 = new VertexNode(null);

    private final LabeledEdge edge1 = new LabeledEdge(vertex1, vertex2, "edge1");
    private final LabeledEdge edge2 = new LabeledEdge(vertex1, null, "edge2");
    private final LabeledEdge edge3 = new LabeledEdge(null, vertex2, "edge3");
    private final LabeledEdge edge4 = new LabeledEdge(vertex1, vertex2, null);

    //Constructed DirectedGraph instance that is empty
    private final DirectedGraph graph1 = new DirectedGraph();

    //Constructed DirectedGraph instance that has two nodes
    private final DirectedGraph graph2 = new DirectedGraph();

    //Constructed DirectedGraph instance that has one node
    private final DirectedGraph graph3 = new DirectedGraph();


    @Before
    public void setUp() {
        graph2.addNode("vertex1");
        graph2.addNode("vertex2");
        graph2.addEdge(vertex1, vertex2, "edge1");

        graph3.addNode("vertex1");
    }

    @Test
    public void testIsEmptyOfEmptyGraph() {
        assertTrue(graph1.isEmpty());
    }

    @Test
    public void testSizeOfEmptyGraph() {
        assertEquals(0, graph1.size());
    }

    @Test
    public void testEntrySetOfEmptyGraph() {
        //unsure of how to do without implementation
    }

    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeToEmptyGraph() {
        graph1.addEdge(vertex1, vertex2, "edge1");
    }

    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeToOneNodeGraph() {
        graph3.addEdge(vertex1, vertex2, "edge1");
    }

    @Test (expected = IllegalStateException.class)
    public void testSizeToOneNodeGraph() {
        assertEquals(1, graph3.size());
    }

    @Test
    public void testIsEmptyForOneNodeGraph() {
        assertFalse(graph3.isEmpty());
    }

    @Test
    public void testIsEmptyForTwoNodeGraph() {
        assertFalse(graph2.isEmpty());
    }

    @Test
    public void testSizeWithTwoNodeGraph() {
        assertEquals(2, graph2.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullNode() {
        graph1.addNode(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingNodeAlreadyContained() {
        graph2.addNode("vertex1)");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddingEdgeAlreadyContained() {
        graph2.addEdge(vertex1, vertex2, "edge1");
    }

    @Test
    public void testAddingEdgeWithSameDestinationAndStartDiffLabel() {
        graph2.addEdge(vertex1, vertex2, "edge11");
        assertEquals(2, graph2.numberOfEdges(vertex1, vertex2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingNullLabelLabelEdge() {
        graph1.addEdge(vertex1, vertex2, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingNullOriginLabelEdge() {
        graph1.addEdge(null, vertex2, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingNullDestinationLabelEdge() {
        graph1.addEdge(vertex1, null, "");
    }

    @Test
    public void testNumberOfEdgesBetweenVertex1andVertex2() {
        assertEquals(2, graph2.numberOfEdges(vertex1, vertex2));
    }

    @Test
    public void testNumberOfEdgesBetweenVertex1andVertex2Reverse() {
        assertEquals(2, graph2.numberOfEdges(vertex2, vertex1));
    }

    @Test
    public void testNumberOfEdgesBetweenVertex1andVertex3() {
        assertEquals(0, graph2.numberOfEdges(vertex1, vertex3));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNumberOfEdgesBetweenVertex1andNull() {
        graph2.numberOfEdges(vertex1, null);
    }

    @Test
    public void testContainsNode() {
        assertTrue(graph2.containsNode(vertex1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testContainsNullNode() {
        graph2.containsNode(null);
    }

    @Test
    public void testDoesNotContainNode() {
        assertFalse(graph2.containsNode(vertex3));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testContainsNullEdge() {
        graph2.containsEdge(new LabeledEdge(null, null, null));
    }

    @Test
    public void testContainsEdge() {
        assertTrue(graph2.containsEdge(new LabeledEdge(vertex1, vertex2, "edge")));
    }

    @Test
    public void testDoesNotContainEdge() {
        assertTrue(graph1.containsEdge(new LabeledEdge(vertex1, vertex2, "edge")));
    }

    @Test
    public void testConnectedNodes() {
        assertTrue(graph2.connected(vertex1, vertex2));
    }

    @Test
    public void testNonConnectedNodes() {
        assertFalse(graph2.connected(vertex2, new VertexNode("vertex4")));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConnectedNullNodes() {
        graph2.connected(vertex2, vertex3);
    }

    @Test
    public void testEntrySet() {
        //unsure how to do without adding the implementation
    }

    @Test (expected = IllegalArgumentException.class)
    public void testListChildrenOfNullNode() {
        graph2.listChildren(null);
    }



}


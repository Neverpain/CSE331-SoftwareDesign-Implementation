package graph.junitTests;

import graph.DirectedGraph;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.Timeout;

/** Unit tests for my DirectedGraph ADT implementation */
public class DirectedGraphTest {
    @Rule public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested

    //Constructed DirectedGraph instance that is empty
    private final DirectedGraph graph1 = new DirectedGraph();

    //Constructed DirectedGraph instance that has one node
    private final DirectedGraph graph2 = new DirectedGraph();

    //Constructed DirectedGraph instance that has two nodes
    private final DirectedGraph graph3 = new DirectedGraph();

    //Initializes all the graphs
    @Before
    public void setUp() {
        graph3.addNode("v1");
        graph3.addNode("v2");
        graph3.addEdge("v1", "v2", "l1");

        graph2.addNode("v1");
    }

    //Tests isEmpty() on an EmptyGraph
    @Test
    public void testIsEmptyOfEmptyGraph() {
        assertTrue(graph1.isEmpty());
    }

    //Tests size() on an EmptyGraph
    @Test
    public void testSizeOfEmptyGraph() {
        assertEquals(0, graph1.size());
    }

    //Tests adding edge on an EmptyGraph with no nodes
    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeToEmptyGraph() {
        graph1.addEdge("v1", "v2", "l1");
    }

    //Tests adding edge to graph with only one node
    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeToOneNodeGraph() {
        graph2.addEdge("v1", "v2", "l1");
    }

    //Tests adding edge to same node in one node graph (circular edge)
    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeToSameNodeInOneNodeGraph() {
        graph2.addEdge("v1", "v1", "l1");
    }

    //Tests size() on a one node graph
    @Test
    public void testSizeToOneNodeGraph() {
        assertEquals(1, graph2.size());
    }

    //Tests size() on a two node graph
    @Test
    public void testSizeWithTwoNodeGraph() {
        assertEquals(2, graph3.size());
    }

    //Tests isEmpty() on a one node graph
    @Test
    public void testIsEmptyForOneNodeGraph() {
        assertFalse(graph2.isEmpty());
    }

    //Tests isEmpty() on a two node graph
    @Test
    public void testIsEmptyForTwoNodeGraph() {
        assertFalse(graph3.isEmpty());
    }

    //Tests adding a null node to empty graph
    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullNodeToEmptyGraph() {
        graph1.addNode(null);
    }

    //Tests adding null node to one node graph
    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullNodeToOneNodeGraph() {
        graph2.addNode(null);
    }

    //Tests adding null node to two node graph
    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullNodeToTwoNodeGraph() {
        graph3.addNode(null);
    }

    //Tests adding node to one node graph
    @Test
    public void testAddingNodeInOneNodeGraph() {
        assertTrue(graph2.addNode("v3)"));
    }

    //Tests adding node to two node graph
    @Test
    public void testAddingNodeInTwoNodeGraph() {
        assertTrue(graph3.addNode("v3)"));
    }

    //Tests adding node already contained to one node graph
    @Test
    public void testAddingNodeAlreadyContainedInOneNodeGraph() {
        assertFalse(graph2.addNode("v1"));
    }

    //Tests adding node already contained to two node graph
    @Test
    public void testAddingNodeAlreadyContainedInTwoNodeGraph() {
        assertFalse(graph3.addNode("v1"));
    }

    //Tests adding edge already contained in a graph
    @Test
    public void testAddingEdgeAlreadyContained() {
        assertFalse(graph3.addEdge("v1", "v2", "l1"));
    }

    //Tests number of edges between two vertices
    @Test
    public void testNumberOfEdgesBetweenTwoVertices() {
        assertEquals(1, graph3.numberOfEdges("v1", "v2"));
    }

    //Tests number of edges between two vertices reversed
    @Test
    public void testNumberOfEdgesBetweenTwoVerticesReverse() {
        assertEquals(1, graph3.numberOfEdges("v2", "v1"));
    }

    //Tests number of edges with a null argument
    @Test (expected = IllegalArgumentException.class)
    public void testNumberOfEdgesBetweenVertexAndNull() {
        graph2.numberOfEdges("v1", null);
    }

    //Tests adding edge with same start and destination but different label
    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeWithSameDestinationAndStartDiffLabel() {
        graph2.addEdge("v1", "v2", "l2");
    }

    //Tests adding edge with same destination and label but different start
    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeWithSameDestinationAndLabelDiffStart() {
        graph3.addEdge("v3", "v2", "l1");
    }

    //Tests adding edge with same start and label but different destination
    @Test (expected = IllegalStateException.class)
    public void testAddingEdgeWithSameStartAndLabelDiffDestination() {
        graph3.addEdge("v1", "v3", "l1");
    }

    //Tests adding null label edge
    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullLabelLabelEdge() {
        graph3.addEdge("v1", "v2", null);
    }

    //Tests adding null start edge
    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullStartLabelEdge() {
        graph3.addEdge(null, "v2", "l1");
    }

    //Tests adding null destination edge
    @Test (expected = IllegalArgumentException.class)
    public void testAddingNullDestinationLabelEdge() {
        graph3.addEdge("v1", null, "l1");
    }

    //Tests contains node method
    @Test
    public void testContainsNode() {
        assertTrue(graph2.containsNode("v1"));
    }

    //Tests contains node method but false
    @Test
    public void testDoesNotContainsNode() {
        assertFalse(graph2.containsNode("v4"));
    }

    //Tests contains method with a null node
    @Test (expected = IllegalArgumentException.class)
    public void testContainsNullNode() {
        graph2.containsNode(null);
    }

    //Tests two nodes are connected with an edge(s)
    @Test
    public void testConnectedNodes() {
        assertTrue(graph3.connected("v1", "v2"));
    }

    //Tests two nodes are connected with an edge(s) but reversed
    @Test
    public void testConnectedNodesReverse() {
        assertTrue(graph3.connected("v2", "v1"));
    }

    //Tests two nodes are connected but one is not contained in the graph
    @Test (expected = IllegalStateException.class)
    public void testConnectedNodesNotContained() {
        graph3.connected("v2", "v4");
    }

    //Tests two nodes are connected but one is null
    @Test (expected = IllegalArgumentException.class)
    public void testConnectedNullNodes() {
        graph2.connected(null, "v1");
    }

    //Tests the list children method for a null node
    @Test (expected = IllegalArgumentException.class)
    public void testListChildrenOfNullNode() {
        graph2.listChildren(null);
    }

    //Tests adding edge to same node in two node graph (circular edge)
    @Test
    public void testAddingEdgeToSameNodeInTwoNodeGraph() {
        assertTrue(graph3.addEdge("v1", "v1", "l1"));
    }
}


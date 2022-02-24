package pathfinder.junitTests;

import graph.DirectedGraph;
import graph.LabeledEdge;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.Timeout;
import pathfinder.DijkstraAlgorithm;

import java.util.List;

/** Unit tests for my DijkstraAlgorithm */
public class TestDijkstraAlgorithm {
    @Rule public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested

    //Non-empty graph used for testing
    DirectedGraph<String, Double> graph = new DirectedGraph<>();

    @Before
    public void create(){
        graph.addNode("v1");
        graph.addNode("v2");
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestDijkstraNullStart() {
        List<LabeledEdge<String, Double>> list = DijkstraAlgorithm.findPath(null, "v2", graph);
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestDijkstraNullDestination() {
        List<LabeledEdge<String, Double>> list = DijkstraAlgorithm.findPath("v1", null, graph);
    }

    @Test (expected = IllegalStateException.class)
    public void TestDijkstraEmptyGraph() {
        List<LabeledEdge<String, Double>> list = DijkstraAlgorithm.findPath("v1", "v2", new DirectedGraph<>());
    }

    @Test
    public void TestDijkstraReturn() {
        List<LabeledEdge<String, Double>> list = DijkstraAlgorithm.findPath("v1", "v2", graph);
        assertEquals(1, list.size());
    }
}

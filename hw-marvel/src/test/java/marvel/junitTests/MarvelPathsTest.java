package marvel.junitTests;

import graph.DirectedGraph;
import marvel.MarvelPaths;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.Timeout;

/** Unit tests for my MarvelPaths implementation (mostly used for exceptions testing) */
public class MarvelPathsTest {
    @Rule public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested

    // Constructed DirectedGraph instance that is empty
    private final DirectedGraph graph = new DirectedGraph();

    // Tests making a graph with a null file to read from
    @Test (expected = IllegalArgumentException.class)
    public void TestsMakeGraphNullFile() {
        MarvelPaths.makeGraph(null);
    }

    // Tests finding a path with a null start node
    @Test (expected = IllegalArgumentException.class)
    public void TestsFindPathNullStart() {
        MarvelPaths.findPath(null, "v2", graph);
    }

    // Tests finding a path with a null destination node
    @Test (expected = IllegalArgumentException.class)
    public void TestsFindPathNullDestination() {
        MarvelPaths.findPath("v1", null, graph);
    }

    // Tests finding a path in an empty graph
    @Test (expected = IllegalStateException.class)
    public void TestsFindPathEmptyGraph() {
        MarvelPaths.findPath("v1", "v2", graph);
    }

    // Tests making a graph with an invalid file name
    @Test (expected = IllegalArgumentException.class)
    public void TestsMakeGraphWithInvalidFileName() {
        MarvelPaths.makeGraph("asdfasd///1@#$//asdf!@#$");
    }

    // Tests making a graph with a valid file name that does not exist
    // in search
    @Test (expected = IllegalArgumentException.class)
    public void TestsMakeGraphWithNoFile() {
        MarvelPaths.makeGraph("marvellllllllllllllllll.csv");
    }

    //Tests making a graph with an empty (unreadable) file
    @Test
    public void TestsMakeGraphWithEmptyFile() {
        assertEquals(0,MarvelPaths.makeGraph("empty.csv").size());
    }
}

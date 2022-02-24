package pathfinder.junitTests;
import graph.DirectedGraph;
import marvel.MarvelPaths;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.Timeout;

/** Unit tests for my CampusMap implementation */
public class TestCampusMap {
    @Rule public Timeout globalTimeout = Timeout.seconds(10); // 10 seconds max per method tested

}

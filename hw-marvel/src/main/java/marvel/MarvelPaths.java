package marvel;

import graph.DirectedGraph;
import graph.LabeledEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * MarvelPaths represents a client implementation of my graph ADT where each node represents
 * a character and each edge connecting two characters is labeled as a comic book that both
 * appear in.
 *
 * @spec.specfield marvelGraph : DirectedGraph // Graph of the marvel connections
 */
public class MarvelPaths {
    private final static DirectedGraph graph = new DirectedGraph();
    /**
     * Builds a new graph with all the marvel connections
     */
    public static void newGraph() {
        Map<String, List<String>> data = MarvelParser.parseData("marvel.csv");
        for (String s : data.keySet()) {
            graph.addNode(s);
        }

        for (String books : data.keySet()) {
            List<String> names = data.get(books);
            for (int i = 0; i < names.size(); i++) {
                graph.addEdge(names.get(i), names.get(i + 1), books);
                graph.addEdge(names.get(i + 1), names.get(i), books);
            }
        }
    }
}

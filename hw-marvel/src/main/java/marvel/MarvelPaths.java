package marvel;

import graph.DirectedGraph;
import graph.LabeledEdge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
     * Builds a new graph with all the marvel connections from given file
     *
     * @param filename file to be read from
     * @throws FileNotFoundException if filename is not found
     * @spec.requires filename != null
     * @spec.modifies this
     * @spec.effects constructs a new DirectedGraph from given files
     */
    public static void newGraph(String filename) throws FileNotFoundException {
        if (filename == null) {
            throw new FileNotFoundException();
        }
        Map<String, List<String>> data = MarvelParser.parseData(filename);
        for (String s : data.keySet()) {
            graph.addNode(s);
        }

        for (String books : data.keySet()) {
            List<String> names = data.get(books);
            for (int i = 0; i < names.size() - 1; i++) {
                graph.addEdge(names.get(i), names.get(i + 1), books);
                graph.addEdge(names.get(i + 1), names.get(i), books);
            }
        }
    }

    public static void BFS(String start, String destination) {
        Queue<String> path = new LinkedList<>();
           Map<String, List<LabeledEdge>> allPaths = new HashMap<>();

    }
}
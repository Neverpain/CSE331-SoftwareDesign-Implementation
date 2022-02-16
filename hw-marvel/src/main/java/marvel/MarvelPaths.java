package marvel;

import graph.DirectedGraph;
import graph.LabeledEdge;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * MarvelPaths represents a client implementation of my graph ADT where each node represents
 * a character and each edge connecting two characters is labeled as a comic book that both
 * appear in.
 */
public class MarvelPaths {
    /**
     * Builds a new graph with all the marvel connections from given file
     *
     * @param filename file to be read from
     * @throws FileNotFoundException if filename is not found
     * @spec.requires filename != null
     * @spec.modifies this
     * @spec.effects  fills this with nodes and edges from information in given files
     */
    public static DirectedGraph makeGraph(String filename) throws FileNotFoundException {
        if (filename == null) {
            throw new FileNotFoundException();
        }
        DirectedGraph graph = new DirectedGraph();
        Set<String> characters = new HashSet<>();
        Map<String, List<String>> comics = new HashMap<>();
        MarvelParser.parseData(filename, comics, characters);

        for (String character : characters) {
            graph.addNode(character);
        }

        for (String comic : comics.keySet()) {
            List<String> names = comics.get(comic);
            for (int i = 0; i < names.size() - 1; i++) {
                for (int k = names.size() - 1; k > i; k--) {
                    graph.addEdge(names.get(i), names.get(k), comic);
                    graph.addEdge(names.get(k), names.get(i), comic);
                }
            }
        }
        return graph;
    }

    /**
     * Finds the closest path from one node to another and returns
     * all edges connecting them in a list.
     *
     * @param start node noting beginning of path
     * @param destination node noting end of path
     * @spec.requires this != null
     * @throws IllegalArgumentException if start and/or end is not contained
     * in this
     * @return a list of labeled edges that represent the path from one node
     * to another, if no path returns empty list
     */
    public static List<LabeledEdge> findPath(String start, String destination, DirectedGraph graph) {
        Queue<String> worklist = new LinkedList<>();
        Map<String, List<LabeledEdge>> allPaths = new HashMap<>();
        allPaths.put(start, new ArrayList<>());
        worklist.add(start);
        while (!worklist.isEmpty()) {
            String nextNode = worklist.remove();
            if (nextNode.equals(destination)) {
                return allPaths.get(nextNode);
            }
            else {
                Set<LabeledEdge> nodesToVisit = new TreeSet<>(new Comparator<LabeledEdge>() {
                    @Override
                    public int compare(LabeledEdge e1, LabeledEdge e2) {
                        if(!(e1.getDestination().equals(e2.getDestination())))
                            return e1.getDestination().compareTo(e2.getDestination());
                        if (!(e1.getLabel().equals(e2.getLabel()))) {
                            return e1.getLabel().compareTo(e2.getLabel());
                        }
                        return 0;
                    }
                });
                nodesToVisit.addAll(graph.listChildren(nextNode));
                for (LabeledEdge e : nodesToVisit) {
                    if (!allPaths.containsKey(e.getDestination())) {
                        List<LabeledEdge> pathOfPrev = allPaths.get(nextNode);
                        List<LabeledEdge> pathOfNode = new ArrayList<>(pathOfPrev);
                        pathOfNode.add(e);
                        allPaths.put(e.getDestination(), pathOfNode);
                        worklist.add(e.getDestination());
                    }
                }
            }
        }
        return allPaths.get(start);
    }
}
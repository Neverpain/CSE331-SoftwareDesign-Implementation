package pathfinder;

import graph.DirectedGraph;
import graph.LabeledEdge;

import java.util.*;

/**
 * The class, DijkstraAlgorithm, is an implementation to find the minimum-cost path between
 * two given nodes that requires a weighted graph, where each node represents a generic
 * data type and each edge connecting two nodes has a non-negative double value.
 */
public class DijkstraAlgorithm {

    // This class does not represent an ADT.

    /**
     * Finds the minimum-cost path between two given nodes using the double values
     * assigned to their edges.
     *
     * @param <N> type of node labels
     * @param start node noting beginning of path
     * @param destination node noting destination of path
     * @param graph graph containing all the information on nodes and edges
     *
     * @spec.requires graph does not contain edges with negative values
     * @return a list of labeled edges that represent the path from one node
     * to another, if no path returns empty list
     * @throws IllegalArgumentException if start or destination == null
     * @throws IllegalStateException if graph.size() == 0
     */
    public static <N> List<LabeledEdge<N, Double>> findPath(N start, N destination, DirectedGraph<N, Double> graph) {
        if (start == null || destination == null) {
            throw new IllegalArgumentException("The start and destination cannot be null.");
        }
        if (graph.size() == 0) {
            throw new IllegalStateException("The graph cannot be empty.");
        }
        Queue<List<LabeledEdge<N, Double>>> active = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(List<LabeledEdge<N, Double>> e1, List<LabeledEdge<N, Double>> e2) {
                double cost1 = 0;
                double cost2 = 0;
                //Total cost of e1 path
                for (LabeledEdge<N, Double> e : e1) {
                    cost1 += e.getLabel();
                }
                //Total cost of e2 path
                for (LabeledEdge<N, Double> e : e2) {
                    cost2 += e.getLabel();
                }
                return (int) (cost1 - cost2);
            }
        });
        Set<N> finished = new HashSet<>();
        List<LabeledEdge<N, Double>> startPath = new ArrayList<>();
        startPath.add(new LabeledEdge<>(start, start, 0.0));
        active.add(startPath);

        while (!active.isEmpty()) {
            List<LabeledEdge<N, Double>> minPath = active.remove();
            N minDest = minPath.get(minPath.size() - 1).getDestination();

            if (minDest.equals(destination)) {
                //Removes the original startPath with a cost of 0.0;
                minPath.remove(0);
                return minPath;
            } else {
                for (LabeledEdge<N, Double> e : graph.listChildren(minDest)) {
                    if (!finished.contains(e.getDestination())) {
                        List<LabeledEdge<N, Double>> newPath = new ArrayList<>(minPath);
                        newPath.add(e);
                        active.add(newPath);
                        finished.add(minDest);
                    }
                }
            }

        }
        startPath.remove(0);
        return startPath;
    }
}

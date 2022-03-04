/*
 * Copyright (C) 2022 Hal Perkins.  All rights reserved.  Permission is
 * hereby granted to students registered for University of Washington
 * CSE 331 for use solely during Winter Quarter 2022 for purposes of
 * the course.  No other use, copying, distribution, or modification
 * is permitted without prior written consent. Copyrights for
 * third-party components of this work must be honored.  Instructors
 * interested in reusing these course materials should contact the
 * author.
 */

package pathfinder;

import graph.DirectedGraph;
import graph.LabeledEdge;
import pathfinder.datastructures.Path;
import pathfinder.datastructures.Point;
import pathfinder.parser.CampusBuilding;
import pathfinder.parser.CampusPath;
import pathfinder.parser.CampusPathsParser;

import java.util.*;

/**
 * This class, CampusMap, is a weighted graph representation of the UW Campus from 2006
 * using given data files where the nodes represent a building/location and the edges represent a
 * path from them.
 *
 * Specification fields:
 * @spec.specfield graph : {DirectedGraph<Point, Double>} // graph of all the
 * buildings/locations with their paths
 * @spec.specfield buildingNames: {Map<CampusBuilding, Point>} // map of buildings(and their information)
 * and their respective coordinate points
 */
public class CampusMap implements ModelAPI {

    // Abstraction Function:
    //      AF(this) = campus map m such that
    //      buildings/locations(nodes) in this = this.graph.listNodes()
    //      paths(edges) in this outgoing from node n = this.graph.getKey(n)
    //
    //      all building information(points, names, etc.) in this = buildingNames.keySet()
    //      points of the buildings/locations n = buildingNames.getKey(n)
    //
    // Representation Invariant for every CampusMap g,
    //      graph != null && is not empty,
    //      nodes != null && edges != null
    //
    //      buildingNames != null && is not empty,
    //      keys != null && values != null

    /**
     * A weighted graph containing all the buildings and paths on campus
     */
    private final DirectedGraph<Point, Double> graph;

    /**
     * Holds the names of building objects and their locations as points
     */
    private final Map<CampusBuilding, Point> buildingNames;

    /**
     * Determines whether to use "big" tests or not
     */
    private static final boolean bigTest = false;

    /**
     * Constructs a new weighted graph with all the information of building/paths from given files.
     *
     * @spec.effects creates a new DirectedGraph with the UW buildings or locations as nodes and their
     * paths as edges, creates a new map of buildings as keys and their points as values
     */
    public CampusMap() {
        graph = new DirectedGraph<>();
        buildingNames = new HashMap<>();
        List<CampusBuilding> buildings = CampusPathsParser.parseCampusBuildings("campus_buildings.csv");
        List<CampusPath> paths = CampusPathsParser.parseCampusPaths("campus_paths.csv");

        for (CampusBuilding building : buildings) {
            graph.addNode(new Point(building.getX(), building.getY()));
            buildingNames.put(building,new Point(building.getX(), building.getY()));
        }

        for (CampusPath path : paths) {
            if (!graph.containsNode(new Point(path.getX1(), path.getY1()))) {
                graph.addNode(new Point(path.getX1(), path.getY1()));
            }
            if(!graph.containsNode(new Point(path.getX2(), path.getY2()))) {
                graph.addNode(new Point(path.getX2(), path.getY2()));
            }
            graph.addEdge(new Point(path.getX1(), path.getY1()),new Point(path.getX2(), path.getY2())
            ,path.getDistance());
        }
        checkRep();
    }

    private void checkRep() {
        assert (graph != null && !graph.isEmpty());
        assert (buildingNames != null && !buildingNames.isEmpty());

        if (bigTest) {
            for (Point key : graph.listNodes()) {
                assert (key != null);
            }

            for (CampusBuilding key : buildingNames.keySet()) {
                assert (key != null);
            }
            for (Point key : buildingNames.values()) {
                assert (key != null);
            }
        }
    }

    @Override
    public boolean shortNameExists(String shortName) {
        checkRep();
        for (CampusBuilding building : buildingNames.keySet()) {
            if (building.getShortName().equals(shortName)) {
                return true;
            }
        }
        checkRep();
        return false;
    }

    @Override
    public String longNameForShort(String shortName) {
        checkRep();
        if (!shortNameExists(shortName)) {
            throw new IllegalArgumentException("Short name of building does not exist in campus map.");
        }
        for (CampusBuilding building : buildingNames.keySet()) {
            if (building.getShortName().equals(shortName)) {
                return building.getLongName();
            }
        }
        checkRep();
        return shortName;
    }

    @Override
    public Map<String, String> buildingNames() {
        checkRep();
        Map<String, String> names = new HashMap<>();
        for (CampusBuilding building : buildingNames.keySet()) {
            names.put(building.getShortName(), building.getLongName());
        }
        checkRep();
        return Collections.unmodifiableMap(names);
    }

    @Override
    public Path<Point> findShortestPath(String startShortName, String endShortName) {
        checkRep();
        if (startShortName == null ||  endShortName == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        if (!shortNameExists(startShortName) || !shortNameExists(endShortName)) {
            throw new IllegalArgumentException("Not valid short names of building in campus map.");
        }
        Point start = null;
        Point end = null;
        for (CampusBuilding building : buildingNames.keySet()) {
            if (building.getShortName().equals(startShortName)) {
                start = new Point(building.getX(), building.getY());
            }
            else if (building.getShortName().equals(endShortName)) {
                end = new Point(building.getX(), building.getY());
            }
        }
        List<LabeledEdge<Point, Double>> points = DijkstraAlgorithm.findPath(start, end, graph);
        Path<Point> path = new Path<>(start);
        for (LabeledEdge<Point, Double> e : points) {
            path = path.extend(e.getDestination(), e.getLabel());
        }
        checkRep();
        return path;
    }
}

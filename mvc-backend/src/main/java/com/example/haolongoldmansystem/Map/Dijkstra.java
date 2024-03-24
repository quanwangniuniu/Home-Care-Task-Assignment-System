package com.example.haolongoldmansystem.Map;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dijkstra {
    public void calculateShortestPath(Node source) {
        source.distance = 0;

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);

            for (Edge edge : currentNode.adjacentEdges) {
                Node adjacentNode = edge.destination;
                int edgeWeight = edge.weight;

                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
    }

    private Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for (Node node : unsettledNodes) {
            int nodeDistance = node.distance;
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private void calculateMinimumDistance(Node evaluationNode, int edgeWeight, Node sourceNode) {
        int sourceDistance = sourceNode.distance;
        if (sourceDistance + edgeWeight < evaluationNode.distance) {
            evaluationNode.distance = sourceDistance + edgeWeight;
            evaluationNode.previous = sourceNode;
        }
        if (sourceDistance + edgeWeight == evaluationNode.distance) {
            evaluationNode.cheapest = true;
        }
    }


    public Node findClosestDriver(Node userLocation, List<Node> drivers) {
        int minDistance = Integer.MAX_VALUE;
        Node closestDriver = null;

        for (Node driver : drivers) {
            calculateShortestPath(driver);
            int distance = userLocation.distance;

            if (distance < minDistance) {
                minDistance = distance;
                closestDriver = driver;
            }
        }

        return closestDriver;
    }

    public Node findCheapestDriver(Node userLocation, List<Node> drivers) {
        int minDistance = Integer.MAX_VALUE;
        Node cheapestDriver = null;

        for (Node driver : drivers) {
            calculateShortestPath(driver);
            int distance = userLocation.distance;

            if (driver.cheapest && distance < minDistance) {
                minDistance = distance;
                cheapestDriver = driver;
            }
        }

        return cheapestDriver;
    }

}

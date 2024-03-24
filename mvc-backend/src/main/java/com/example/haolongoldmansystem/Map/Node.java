package com.example.haolongoldmansystem.Map;

import java.util.ArrayList;
import java.util.List;

class Node {
    String name;
    List<Edge> adjacentEdges;
    int distance = Integer.MAX_VALUE;
    Node previous = null;
    boolean cheapest = false;

    public Node(String name) {
        this.name = name;
        this.adjacentEdges = new ArrayList<>();
    }

    public void addEdge(Edge edge) {
        adjacentEdges.add(edge);
    }
}

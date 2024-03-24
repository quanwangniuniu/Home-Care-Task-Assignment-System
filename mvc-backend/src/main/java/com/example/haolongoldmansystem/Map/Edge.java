package com.example.haolongoldmansystem.Map;

class Edge {
    Node source;
    Node destination;
    int weight;

    public Edge(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}


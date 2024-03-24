//package com.example.haolongoldmansystem.Map;
//
////创建图的时候使用单例模式，保证每次创建的时候只创建一个对象
//public class MapBuild {
//    private MapBuild(){
//    }
//    private static final MapBuild instance = new MapBuild();
//    public static MapBuild getInstance(){
//        return instance;
//    }
//
//    public void buildMap(){
//        Graph graph = new Graph(5);
//        graph.addEdge(0, new int[] {1, 3}); // 添加从节点 0 出发的边到节点 1 和节点 2
//        graph.addEdge(1, new int[] {2, 3});
//        graph.addEdge(2, new int[] {3});
//        graph.addEdge(3, new int[] {});
//        graph.addEdge(4, new int[] {0, 1});
//        graph.addEdgeWithCost(0, new Edge[] {new Edge(1, 3), new Edge(2, 1)});  // 添加从节点 0 出发的带权边
//        graph.addEdgeWithCost(1, new Edge[] {new Edge(2, 1), new Edge(3, 4)});
//        graph.addEdgeWithCost(2, new Edge[] {new Edge(3, 1)});
//        graph.addEdgeWithCost(3, new Edge[] {});
//        graph.addEdgeWithCost(4, new Edge[] {new Edge(0, 2), new Edge(1, 4)});
//
//        System.out.println("Shortest Path:");
//        System.out.println("From 1 to 3: " + graph.shortestPath(1, 3));  // 2
//        System.out.println("From 4 to 2: " + graph.shortestPath(4, 2));  // 2
//        System.out.println("From 3 to 0: " + graph.shortestPath(3, 0));  // -1
//
//        System.out.println("Shortest Path with Cost:");
//        System.out.println("From 1 to 3: " + graph.shortestPathWithCost(1, 3));  // 2
//        System.out.println("From 4 to 2: " + graph.shortestPathWithCost(4, 2));  // 3
//        System.out.println("From 3 to 0: " + graph.shortestPathWithCost(3, 0));  // -1
//    }
//}

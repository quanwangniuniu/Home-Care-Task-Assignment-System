//package com.example.haolongoldmansystem.Map;
//
//import java.util.Arrays;
//import java.util.PriorityQueue;
//
//// 表示边的类
//class Edge {
//    int to;  // 目标节点编号
//    int cost;  // 边的长度（权值）
//
//    Edge(int to, int cost) {
//        this.to = to;
//        this.cost = cost;
//    }
//}
//
//public class Graph {
//    int V;  // 节点数
//    int[][] adjList;  // 邻接表，adjList[i][j] 表示从节点 i 出发的第 j 条边指向的节点编号
//    int[][] dist;  // 距离矩阵，dist[i][j] 表示节点 i 到节点 j 的距离
//    Edge[][] adjListWithCost;  // 带权邻接表，adjListWithCost[i] 表示对节点 i 出发的边按照长度从小到大排序后的数组
//    int[][] shortestDist;  // 最短路径矩阵，shortestDist[i][j] 表示节点 i 到节点 j 的最短路径长度
//    int[][] shortestDistWithCost;  // 最短加权路径矩阵，shortestDistWithCost[i][j] 表示节点 i 到节点 j 的最短加权路径长度
//    boolean[] visited;
//
//    Graph(int V) {
//        this.V = V;
//        adjList = new int[V][];
//        dist = new int[V][V];
//        adjListWithCost = new Edge[V][];
//        shortestDist = new int[V][V];
//        shortestDistWithCost = new int[V][V];
//        visited = new boolean[V];
//
//        for (int i = 0; i < V; i++) {
//            Arrays.fill(dist[i], Integer.MAX_VALUE);
//            Arrays.fill(shortestDist[i], Integer.MAX_VALUE);
//            Arrays.fill(shortestDistWithCost[i], Integer.MAX_VALUE);
//        }
//    }
//
//    public void addEdge(int u, int[] vList) {
//        adjList[u] = vList;
//    }
//
//    public void addEdgeWithCost(int u, Edge[] edges) {
//        adjListWithCost[u] = edges;
//    }
//
//    // 计算节点 i 到节点 j 的最短路径
//    public int shortestPath(int i, int j) {
//        Arrays.fill(visited, false);
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));  // 记录 (节点编号, 距离) 的优先队列
//        pq.offer(new int[]{i, 0});  // 将起点加入优先队列
//        while (!pq.isEmpty()) {
//            int[] cur = pq.poll();
//            int curNode = cur[0], curDist = cur[1];
//            if (visited[curNode]) {
//                continue;
//            }
//            visited[curNode] = true;
//            if (curNode == j) {  // 已经到达终点
//                return dist[i][j];
//            }
//            for (int k = 0; k < adjList[curNode].length; k++) {  // 遍历 curNode 的所有出边
//                int nextNode = adjList[curNode][k];
//                int nextDist = curDist + 1;
//                if (nextDist < dist[i][nextNode]) {  // 更新 curNode 到 nextNode 的距离
//                    dist[i][nextNode] = nextDist;
//                    pq.offer(new int[]{nextNode, nextDist});
//                }
//            }
//        }
//        return -1;  // 无法到达终点
//    }
//
//    // 计算节点 i 到节点 j 的最短加权路径
//    public int shortestPathWithCost(int i, int j) {
//        Arrays.fill(visited, false);
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));  // 记录 (节点编号, 距离) 的优先队列
//        pq.offer(new int[]{i, 0});  // 将起点加入优先队列
//        while (!pq.isEmpty()) {
//            int[] cur = pq.poll();
//            int curNode = cur[0], curDist = cur[1];
//            if (visited[curNode]) {
//                continue;
//            }
//            visited[curNode] = true;
//            if (curNode == j) {  // 已经到达终点
//                return shortestDistWithCost[i][j];
//            }
//            for (int k = 0; k < adjListWithCost[curNode].length; k++) {  // 遍历 curNode 的所有出边
//                Edge edge = adjListWithCost[curNode][k];
//                int nextNode = edge.to;
//                int nextDist = curDist + edge.cost;
//                if (nextDist < shortestDistWithCost[i][nextNode]) {  // 更新 curNode 到 nextNode 的距离
//                    shortestDistWithCost[i][nextNode] = nextDist;
//                    pq.offer(new int[]{nextNode, nextDist});
//                }
//            }
//        }
//        return -1;  // 无法到达终点
//    }
//}
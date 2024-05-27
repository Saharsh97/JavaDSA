package LeetCode.Graphs;

import java.util.*;

public class MSTPrimsAlgorithm {
    static class Point{
        int vertex;
        int x;
        int y;

        public Point(int vertex, int x, int y) {
            this.vertex = vertex;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge{
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static int minCostConnectPoints(int[][] coordinates) {
        int n = coordinates.length;
        Point[] points = new Point[n];
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            points[i] = new Point(i, coordinates[i][0], coordinates[i][1]);
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w - o2.w;
            }
        });


        for(int i = 1; i < n; i++){
            pq.add(new Edge(0, i, getDistance(points[0], points[i])));
        }

        int sum = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(visited[edge.u] && visited[edge.v]) continue;
            sum += edge.w;
            visited[edge.u] = true;
            visited[edge.v] = true;
            for(int i = 0; i < n; i++){
                if(i==edge.u || i==edge.v || visited[i]) continue;
                // add an edge to PQ, that contains at-least 1 unvisited node.
                pq.add(new Edge(edge.v, i, getDistance(points[edge.v], points[i])));
            }
        }
        return sum;
    }

    private static int getDistance(Point a, Point b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
































//    public int minCostConnectPoints(int[][] coordinates) {
//        List<Point> points = new ArrayList<>();
//        for(int i = 0; i < coordinates.length; i++){
//            Point point = new Point(i, coordinates[i][0], coordinates[i][1]);
//            points.add(point);
//        }
//        int n = points.size();
//
//        List<Edge> edges = new ArrayList<>();
//        for(int i = 0; i < n; i++){
//            for(int j = i+1; j < n; j++){
//                Point p1 = points.get(i);
//                Point p2 = points.get(j);
//                int dist = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
//                Edge edge = new Edge(p1, p2, dist);
//                edges.add(edge);
//            }
//        }
//
//        Edge minEdge = edges.get(0);
//        for(int i = 1; i < edges.size(); i++){
//            minEdge = edges.get(i).w < minEdge.w ? edges.get(i) : minEdge;
//        }
//        minEdge.dist = minEdge.w;
//
//        Map<Point, Boolean> visited = new HashMap<>();
//        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
//            @Override
//            public int compare(Edge o1, Edge o2) {
//                return o1.dist - o2.dist;
//            }
//        });
//        pq.add(minEdge);
//        while(!pq.isEmpty()){
//            Edge edge = pq.poll();
//
//        }
//    }
//
//    class Point{
//        int number;
//        int x;
//        int y;
//
//        public Point(int number, int x, int y) {
//            this.number = number;
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    class Edge{
//        Point p1;
//        Point p2;
//        int w;
//        int dist;
//
//        public Edge(Point p1, Point p2, int w) {
//            this.p1 = p1;
//            this.p2 = p2;
//            this.w = w;
//            this.dist = Integer.MAX_VALUE;
//        }
//    }
}

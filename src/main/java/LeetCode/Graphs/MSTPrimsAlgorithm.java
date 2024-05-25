//package LeetCode.Graphs;
//
//import java.util.*;
//
//public class MSTPrimsAlgorithm {
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
//
//
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
//}

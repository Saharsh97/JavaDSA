package LeetCode.Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class A_Dijkstra {
    // https://leetcode.com/problems/network-delay-time/description/
    private class Pair {
        Integer vertex;
        Integer dist;

        public Pair(Integer vertex, Integer distance) {
            this.vertex = vertex;
            this.dist = distance;
        }
    }

    int[] distance;
    int[][] graph;
    List<Integer>[] adjacencyList;

    public int networkDelayTime(int[][] edges, int n, int src) {
        initialise(edges, n, --src);
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.dist-o2.dist;
            }
        });
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int u = pair.vertex;
            int dist = pair.dist;

            for(int v: adjacencyList[u]){
                if(distance[v] > dist + graph[u][v]){
                    distance[v] = dist + graph[u][v];
                    pq.add(new Pair(v, distance[v]));
                }
            }
        }
        int maxTime = 0;
        for(int d: distance) maxTime = Math.max(maxTime, d);
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }

    private void initialise(int[][] edges, int n, int src){
        for(int i = 0; i < edges.length; i++) {
            edges[i][0]--;
            edges[i][1]--;
        }
        // initialise graph
        graph = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                graph[i][j] = j==i ? 0 : Integer.MAX_VALUE;
            }
        }
        // populate graph
        adjacencyList = new List[n];
        for(int i = 0; i < n; i++)
            adjacencyList[i] = new ArrayList<>();
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            graph[u][v] = w;
            adjacencyList[u].add(v);
        }
        // initialise distance from source
        distance = new int[n];
        for(int i = 0; i < n; i++) distance[i] = Integer.MAX_VALUE;
        distance[src] = 0;
    }
}

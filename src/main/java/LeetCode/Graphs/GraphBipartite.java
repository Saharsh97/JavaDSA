package LeetCode.Graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class GraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] color = new int[n];   // 1 or -1.

        for(int i = 0; i < n; i++) {
            if(!bfs(i, visited, color, graph)){
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int st, boolean[] visited, int[] color, int[][] graph){
        if(visited[st]){
            return true;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(st);
        color[st] = 1;
        while (!deque.isEmpty()) {
            int node = deque.poll();
            if (visited[node]) continue;
            visited[node] = true;

            for (int adj : graph[node]) {
                if (color[adj] != 0 && color[adj] == color[node]) {
                    return false;
                }
                if (!visited[adj]) {
                    deque.add(adj);
                    color[adj] = -color[node];
                }
            }
        }
        return true;
    }
}

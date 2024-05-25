package LeetCode.Graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class GraphBipartiteDFS {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] color = new int[n];   // 1 or -1.

        for(int i = 0; i < n; i++) {
            if(!visited[i]){
                color[i] = 1;
                if(!dfs(i, visited, color, graph)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int st, boolean[] visited, int[] color, int[][] graph){
        if(visited[st]) {
            return true;
        }
        visited[st] = true;
        for(int adj: graph[st]){
            if(color[adj] != 0 && color[adj] == color[st]){
                return false;
            }
            if(!visited[adj]) {
                color[adj] = -color[st];
                if(!dfs(adj, visited, color, graph)){
                    return false;
                }
            }
        }
        return true;
    }
}

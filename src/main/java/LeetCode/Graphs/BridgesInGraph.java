package LeetCode.Graphs;

import java.util.ArrayList;
import java.util.List;

public class BridgesInGraph {
    // https://leetcode.com/problems/critical-connections-in-a-network/

    int tValue;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        tValue = 0;
        boolean[] visited = new boolean[n];
        int[] time = new int[n];
        int[] low = new int[n];

        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(List<Integer> edge: connections){
            int u = edge.get(0);
            int v = edge.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, 0, visited, time, low, graph, result);
        return result;
    }

    public void dfs(int u, int parent, boolean[] visited, int[] time, int[] low, List<Integer>[] graph, List<List<Integer>> result){
        if(visited[u]) return;
        visited[u] = true;
        time[u] = tValue;
        low[u] = tValue++;
        for(Integer v: graph[u]) {
            if(!visited[v]) {
                dfs(v, u, visited, time, low, graph, result);
            }
        }

        for(Integer v: graph[u]) {
            if(v == parent) continue;
            low[u] = Math.min(low[u], low[v]);
        }
        if(low[parent] < low[u]) {
            result.add(List.of(parent, u));
        }
    }
}

package LeetCode.Graphs;

import java.util.ArrayList;

public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        ArrayList<Integer> path = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            dfs(i, visited, graph, path);
        }
        return path;
    }

    public void dfs(int vertex, boolean[] visited, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> path){
        if(visited[vertex]){
            return;
        }
        visited[vertex] = true;
        path.add(vertex);
        for(Integer adj: graph.get(vertex)){
            dfs(adj, visited, graph, path);
        }
    }
}

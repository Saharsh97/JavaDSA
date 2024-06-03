package LeetCode.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponents {
    public int kosaraju(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            dfsFillStack(i, stack, visited, adj);
        }

        List<Integer>[] reverseGraph = new List[n];
        for(int i = 0; i < n; i++) reverseGraph[i] = new ArrayList<>();
        for(int u = 0; u < n; u++){
            for(int v: adj.get(u)){
                reverseGraph[v].add(u);
            }
        }

        Arrays.fill(visited, false);
        List<List<Integer>> allSCCs = new ArrayList<>();
        while(!stack.isEmpty()){
            int u = stack.pop();
            List<Integer> path = new ArrayList<>();
            if(!visited[u]) {
                dfs(u, visited, path, reverseGraph);
                allSCCs.add(path);
            }
        }
        return allSCCs.size();
    }

    private void dfsFillStack(int u, Stack<Integer> stack, boolean[] visited, List<List<Integer>> adj){
        if(visited[u]) return;
        visited[u] = true;
        for(Integer v: adj.get(u))
            dfsFillStack(v, stack, visited, adj);
        // after visiting all the nodes, then push to stack.
        stack.push(u);
    }

    private void dfs(int u, boolean[] visited, List<Integer> path, List<Integer>[] reverseGraph){
        if(visited[u]) return;
        visited[u] = true;
        path.add(u);
        for(Integer v: reverseGraph[u])
            dfs(v, visited, path, reverseGraph);
    }
}

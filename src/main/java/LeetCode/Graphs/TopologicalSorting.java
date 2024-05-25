package LeetCode.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSorting {
    int[] topoSort(int n, ArrayList<ArrayList<Integer>> graph) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            dfs(i, stk, visited, result, graph);
        }

        // result list needs to be reversed
        // OR push to front of deque.
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            answer[i] = result.get(n-1-i);
        }
        return answer;
    }

    private void dfs(int vertex, Stack<Integer> stk, boolean[] visited, List<Integer> result, ArrayList<ArrayList<Integer>> graph){
        if(visited[vertex]){
            return;
        }
        stk.push(vertex);
        visited[vertex] = true;
        for(Integer adj: graph.get(vertex)){
            dfs(adj, stk, visited, result, graph);
        }
        int node = stk.pop();
        result.add(node);
    }
}

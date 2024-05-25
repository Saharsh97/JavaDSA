package LeetCode.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectCycleUsingDFS {
    public boolean canFinish(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
        }

        boolean[] visited = new boolean[n];
        Set<Integer> path = new HashSet<>();
        for(int i = 0; i < n; i++){
            if (dfsContainsCycle(i, path, visited, graph)) {
                return false; // not possible to schedule
            }
        }
        return true;
    }

    public boolean dfsContainsCycle(int vertex, Set<Integer> path, boolean[] visited, List<Integer>[] graph){
        if(path.contains(vertex)){  // already saw this node in the current path. cycle found.
            return true;
        }
        // no cycle found. this node has been already computed. no need to compute again.
        if(visited[vertex]){
            return false;
        }
        path.add(vertex);
        visited[vertex] = true;
        for (int adj : graph[vertex]) {
            if (dfsContainsCycle(adj, path, visited, graph)) {
                return true;
            }
        }
        path.remove(vertex);
        return false;
    }
}

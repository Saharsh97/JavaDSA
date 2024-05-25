package LeetCode.Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> path = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            bfs(i, visited, path, graph);
        }
        return path;
    }

    private void bfs(int startVertex, boolean[] visited, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> graph){
        Deque<Integer> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(startVertex);

        while(!bfsQueue.isEmpty()){
            int vertex = bfsQueue.pollFirst();
            if(visited[vertex]){
                continue;
            }
            visited[vertex] = true;
            path.add(vertex);
            for(Integer adj: graph.get(vertex)){
                bfsQueue.add(adj);
            }
        }
    }
}

package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlowerPlantingWithNoAdjacent {

    public int[] gardenNoAdj(int n, int[][] paths) {
        if(paths.length == 0){
            int[] assignedFlowers = new int[n];
            Arrays.fill(assignedFlowers, 1);
            return assignedFlowers;
        }
//        int[][] graph = new int[n][n];  // dont use this!
        // use optimum graph structure
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < paths.length; i++){
            int u = paths[i][0]-1;
            int v = paths[i][1]-1;
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];
        int[] assignedFlowers = new int[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                assignedFlowers[i] = 1;
                dfs(i, visited, assignedFlowers, graph);
            }
        }
        return assignedFlowers;
    }

    private void dfs(int u, boolean[] visited, int[] assignedFlowers, List<Integer>[] graph){
        if(visited[u]) return;
        visited[u] = true;

        int color = 1;
        for(int v: graph[u]){
            if(assignedFlowers[v] != 0){
                continue;
            }

            if(color == assignedFlowers[u]){
                color++;
            }

            assignedFlowers[v] = color;
            color++;
        }
        for(int v: graph[u]){
            dfs(v, visited, assignedFlowers, graph);
        }
    }
}

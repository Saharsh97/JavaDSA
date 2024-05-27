package LeetCode.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgorithm {
    int[] bellmanFord(int n, ArrayList<ArrayList<Integer>> edges, int s) {
        long[] distance = new long[n];
        Arrays.fill(distance, 100000000);
        distance[s] = 0;
        for(int i = 0; i < n; i++){
            if(i == s) continue;
            for(List<Integer> edge: edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                if(distance[u] == 100000000) continue;
                if(distance[v] > distance[u] + w){
                    distance[v] = distance[u] + w;
                }
            }
        }

        int[] result = new int[n];
        for(int i = 0; i < n; i++) result[i] = (int) distance[i];

        // checking for negative cycle.
        for(int i = 0; i < n; i++){
            if(i == s) continue;
            for(List<Integer> edge: edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                if(distance[u] == 100000000) continue;
                if(distance[v] > distance[u] + w){
                    return new int[]{-1};
                }
            }
        }
        return result;
    }
}

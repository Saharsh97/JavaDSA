package LeetCode.Graphs;

public class FloydWarshallAlgorithm {
    public void shortestDistance(int[][] M) {
        int n = M.length;

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(M[i][k] == -1 || M[k][j] == -1) continue;
                    // no direct edge from i to j, but a connecting edge from i to k and k to j
                    if(M[i][j] == -1 || M[i][k] + M[k][j] < M[i][j])
                        M[i][j] = M[i][k] + M[k][j];
                }
            }
        }
        // repeat above for negative cycle.
    }
}

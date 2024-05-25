package LeetCode.DynamicProgramming;

public class MaximalSquare {
    public int maximalSquare(char[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[][] dp = new int[n][m];
        int size = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = A[i][j] == '1' ? 1 : 0;
                size = Math.max(size, dp[i][j]);
            }
        }

        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < m-1; j++){
                if(A[i][j] == '1' && A[i][j+1] == '1' && A[i+1][j] == '1' && A[i+1][j+1] == '1'){
                    dp[i+1][j+1] = Math.min(dp[i][j], Math.min(dp[i][j+1], dp[i+1][j])) + 1;
                    size = Math.max(size, dp[i+1][j+1]);
                }
            }
        }
        return size * size;
    }
}

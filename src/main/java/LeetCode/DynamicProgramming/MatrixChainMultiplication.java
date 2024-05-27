package LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixChainMultiplication {
    class Matrix{
        int x;
        int y;

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public  int matrixMultiplication(int n, int A[]) {
        Matrix[] matrices = new Matrix[n-1];
        for(int i = 1; i < n; i++)
            matrices[i-1] = new Matrix(A[i-1], A[i]);

        n = n-1;    // matrices length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = i; j < n; j++)
                dp[i][j] = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++)
            dp[i][i] = 0;
        for(int i = 0; i < n-1; i++)
            dp[i][i+1] = matrices[i].x * matrices[i].y * matrices[i+1].y;

        for(int length = 2; length < n; length++){
            for(int i = 0; i < n-length; i++){
                int j = i+length;
                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + matrices[i].x * matrices[k].y * matrices[j].y + dp[k + 1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}

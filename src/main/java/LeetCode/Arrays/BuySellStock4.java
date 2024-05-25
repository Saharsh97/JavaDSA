package LeetCode.Arrays;

public class BuySellStock4 {

    public int maxProfit(int k, int[] A) {
        int n = A.length;
        if(k > n/2){
            return infiniteTransactions(A);
        }

        int[][] dp = new int[k+1][n];
        // i,j => i transactions, in a list of [jth index to nth index] numbers.

        // base, k=1 transaction:
        int minSoFar = A[0];
        int profit = 0;
        for(int i = 0; i < n; i++){
            profit = Math.max(profit, A[i] - minSoFar);
            dp[1][i] = profit;
            minSoFar = Math.min(minSoFar, A[i]);
        }

        for(int i = 2; i <= k; i++){
            int maxSoFar = A[n-1];
            profit = 0;
            for(int j = n-1; j >= 0; j--){
                if(maxSoFar > A[j]) {
                    int thisTransaction = maxSoFar - A[j];
                    profit = Math.max(profit, thisTransaction + dp[i-1][j]);
                    dp[i][j] = profit;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
                maxSoFar = Math.max(maxSoFar, A[j]);
            }
        }

        return dp[k][0];
    }

    // buy sell II
    private int infiniteTransactions(int[] A){
        int profit = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] > A[i-1]){
                profit += A[i] - A[i-1];
            }
        }
        return profit;
    }
}

package LeetCode.Arrays;

public class A_BuySellStock4 {

    public int maxProfitONCube(int K, int[] A) {
        int n = A.length;
        if(K > n/2){
            return infiniteTransactions(A);
        }

        int[][] dp = new int[K+1][n];

        for(int k = 1; k <= K; k++){    // for the kth transaction
            // what is the maximum profit till ith day.
            for(int i = 1; i < n; i++){
                dp[k][i] = dp[k][i-1];  // if I don't do any action, maximum profit till ith day is max profit till (i-1)th day.
                for(int j = 0; j < i; j++){     //  I will pick jth stock, and sell it on ith day + I would have some max profit till jth day.
                    dp[k][i] = Math.max(dp[k][i], dp[k-1][j] + A[i] - A[j]);
                }
            }
        }

        return dp[K][n-1];
    }

    public int maxProfit(int K, int[] A) {
        int n = A.length;
        if(K > n/2){
            return infiniteTransactions(A);
        }

        int[][] dp = new int[K+1][n];

        // for kth transaction, for the first j numbers:
        // let say we pick any mth day from 1 to j.
        // we already know the profit on mth day + then you buy on mth day, sell on jth day.

        // for m = 0 to j-1 => maximise A[j] - A[m] + dp[t-1][m]
        // in iterating m, A[j] is constant.
        // for m = 0 to j-1 => maximise (A[j] + dp[t-1][m] - A[m])
        // to maximise (A[j] + dp[t-1][m] - A[m]), A[j] is contant, so maximise dp[t-1][m] - A[m]
        // => A[j] + max(dp[t-1][m] - A[m]) implies keep finding the max of it so far.

         for(int t = 1; t <= K; t++){
             int localMax = 0 - A[0];    // m = 0;
             for(int j = 1; j < n; j++){
                 dp[t][j] = Math.max(dp[t][j-1], A[j] + localMax);
                 localMax = Math.max(localMax, dp[t-1][j] - A[j]);
             }
         }

        return dp[K][0];
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

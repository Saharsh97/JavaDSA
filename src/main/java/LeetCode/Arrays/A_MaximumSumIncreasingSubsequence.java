package LeetCode.Arrays;


// always go step by step, starting from i = 0, to any index.
// how will you approach here.

// if I am at this i, what is the max answer for this i
// I will have to check all the numbers before i,
// Answer till j, plus A[i] if A[i] > A[j].
public class A_MaximumSumIncreasingSubsequence {
    public int maxSumIS(int A[], int n) {
        int[] dp = new int[n];
        dp[0] = A[0];

        int maxSum = A[0];
        for(int i = 1; i < n; i++){
            dp[i] = A[i];
            for(int j = 0; j < i; j++){
                if(A[j] < A[i]){
                    dp[i] = Math.max(dp[i], A[i] + dp[j]);
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}

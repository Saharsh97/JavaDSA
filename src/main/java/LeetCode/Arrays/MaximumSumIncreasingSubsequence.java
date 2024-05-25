package LeetCode.Arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MaximumSumIncreasingSubsequence {
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

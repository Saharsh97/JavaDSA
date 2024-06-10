package LeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        // longest subsequence ending at i
        for(int i = 0; i < n; i++){
            // whichever j, before i, has less value than i and a better length, consider that.
            for(int j = 0; j < i; j++){
                if(A[j] < A[i] && (dp[j] + 1) > dp[i])
                    dp[i] = dp[j] + 1;
            }
        }
        int max = 1;
        for(int x: dp) max = Math.max(max, x);
        return max;
    }


}

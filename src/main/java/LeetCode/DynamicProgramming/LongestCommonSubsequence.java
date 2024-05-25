package LeetCode.DynamicProgramming;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n][m];
        dp[0][0] = A.charAt(0) == B.charAt(0) ? 1 : 0;
        for(int j = 1; j < m; j++){
            dp[0][j] = A.charAt(0) == B.charAt(j) ? 1 : dp[0][j-1];
        }
        for(int i = 1; i < n; i++){
            dp[i][0] = A.charAt(i) == B.charAt(0) ? 1 : dp[i-1][0];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if(A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - 1][j - 1]);
                }
            }
        }
        return dp[n-1][m-1];
    }
}

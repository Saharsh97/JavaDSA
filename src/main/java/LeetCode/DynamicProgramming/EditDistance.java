package LeetCode.DynamicProgramming;

public class EditDistance {
    public int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();
        if(n == 0) {
            return m;
        }
        if(m == 0){
            return n;
        }
        int[][] dp = new int[n][m];
        dp[0][0] = A.charAt(0) == B.charAt(0) ? 0 : 1;

        boolean notMatched = true;
        for(int j = 1; j < m; j++){
            dp[0][j] = A.charAt(j) == B.charAt(j) & notMatched ? dp[0][j-1] : 1 + dp[0][j-1];
            if(A.charAt(j) == B.charAt(j)) notMatched = false;
        }

        notMatched = true;
        for(int i = 1; i < n; i++){
            dp[i][0] = A.charAt(i) == B.charAt(i) & notMatched ? dp[i-1][0] : 1 + dp[i-1][0];
            if(A.charAt(i) == B.charAt(i)) notMatched = false;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                int diag = dp[i-1][j-1];

                dp[i][j] = Math.min( (A.charAt(i) == B.charAt(j) ? 0 : 1) + diag, Math.min(1 + up, 1 + left) );
            }
        }
        return dp[n-1][m-1];
    }
}

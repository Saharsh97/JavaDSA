package LeetCode.DynamicProgramming;

public class A_InterLeavingStrings {

    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1]; // this is important! // creating map of Pair. null if no key.
        return recur(0, s1, 0, s2, 0, s3, dp);
    }

    private boolean recur(int idx1, String s1, int idx2, String s2, int idx3, String s3, Boolean[][] dp){
        if(idx3 == s3.length()){
            dp[idx1][idx2] = true;
            return true;
        }
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();

        if(n-idx1 + m-idx2 != k-idx3){
            dp[idx1][idx2] = false;
            return false;
        }

        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }

        boolean answer = false;
        if(idx1 < n && s3.charAt(idx3) == s1.charAt(idx1)){
            answer |= recur(idx1 + 1, s1, idx2, s2, idx3+1, s3, dp);
        }

        if(!answer && idx2 < m && s3.charAt(idx3) == s2.charAt(idx2)){
            answer |= recur(idx1, s1, idx2+1, s2, idx3+1, s3, dp);
        }


        dp[idx1][idx2] = answer;
        return answer;
    }
}

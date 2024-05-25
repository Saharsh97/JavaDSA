package LeetCode.DynamicProgramming;

public class PalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        int maxLength = 0;
        int idx = 0;
        for(int i = n-1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i > 1 && dp[i+1][j-1] == 0){
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1] + 2);
                    if(dp[i][j] > maxLength){
                        maxLength = dp[i][j];
                        idx = i;
                    }
                }
            }
        }
        return s.substring(idx, idx+maxLength);
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//        return "p";
    }
}

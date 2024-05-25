package LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        for(int i = n-2; i >= 0 ; i--){
            for(int j = i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = j-i==1 ? 2 :
                            dp[i+1][j-1] > 0 ? dp[i+1][j-1] + 2 : 0;
                }
            }
        }

        List<List<String>> answer = new ArrayList<>();
        List<String> path = new ArrayList<>();
        recur(0, s, dp, path, answer);
        return answer;
    }

    private void recur(int st, String str, int[][] dp, List<String> path, List<List<String>> answer){
        int n = str.length();
        if(st > n){
            return;
        }
        if(st == n){
            answer.add(new ArrayList<>(path));
            return;
        }
        String word = "";
        for(int i = st; i < n; i++){
            word += str.charAt(i);
            if(dp[st][i]!=0){
                path.add(word);
                recur(i+1, str, dp, path, answer);
                path.removeLast();
            }
        }
    }
}

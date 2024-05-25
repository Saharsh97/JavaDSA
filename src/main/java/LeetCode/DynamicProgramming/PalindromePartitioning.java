package LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public int palindromicPartition(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        for(int i = n-1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                dp[i][j] = str.charAt(i) != str.charAt(j) ? 0 :
                        j-i == 1 ? 2 :  // nothing between i and j, and i and j are adjacent.
                                dp[i+1][j-1] > 0 ? 2 + dp[i+1][j-1] : 0;
            }
        }

        List<Integer>[] indexPalindromes = new List[n];
        for(int i = 0; i < n; i++){
            indexPalindromes[i] = new ArrayList<>();
            for(int j = i; j < n; j++){
                if(dp[i][j] > 0) {
                    indexPalindromes[i].add(dp[i][j]);
                }
            }
        }


        int[] computed = new int[n+1];
        computed[n] = 0;
        return findMinPartition(0, computed, indexPalindromes);
    }

    private int findMinPartition(int st, int[] computed, List<Integer>[] indexPalindromes){
        if(st == indexPalindromes.length){
            return 0;
        }
        if(computed[st] != 0){
            return computed[st];
        }
        int minAnswer = 1000;
        for(Integer palindromeLength: indexPalindromes[st]){
            if(st + palindromeLength == indexPalindromes.length){
                computed[st] = 0;
                return 0;
            }
            minAnswer = Math.min(minAnswer, findMinPartition(st+palindromeLength, computed, indexPalindromes));
        }
        computed[st] = minAnswer+1;
        return minAnswer+1;
    }
}

package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class RodCuttingProblem {

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        Integer[][] dp = new Integer[n+1][n+1];
        return recur(0, n, 0, cuts.length-1, cuts, dp);
    }

    private int recur(int st, int en, int cutsSt, int cutsEn, int[] cuts, Integer[][] dp){
        if(cutsSt > cutsEn){
            return 0;
        }
        if(st >= en){
            return 0;
        }
        int length = en - st;
        if(cutsSt == cutsEn){
            return length;
        }
        if(dp[st][en] != null){
            return dp[st][en];
        }
        int minCost = Integer.MAX_VALUE;
        for(int i = cutsSt; i <= cutsEn; i++){
            int leftCost = recur(st, cuts[i], cutsSt, i-1, cuts, dp);
            int rightCost = recur(cuts[i], en, i+1, cutsEn, cuts, dp);
            minCost = Math.min(minCost, leftCost + rightCost);
        }
        minCost = minCost == Integer.MAX_VALUE ? 0 : minCost + length;
        dp[st][en] = minCost;
        return minCost;
    }

//    private int minCut(int L, int R, int[] cuts, Map<String, Integer> dp){
//        if(dp.containsKey(L+"|"+R)){
//            return dp.get(L+"|"+R);
//        }
//        int n = cuts.size();
//        if(R-L == 1){   // cannot cut a stick of length 1. so its cost is 0.
//            return 0;
//        }
//        int leastCost = Integer.MAX_VALUE;
//
//        for(int i = 0; i < n; i++){
//            if(L < cuts.get(i) && cuts.get(i) < R){
//                int leftAnswer = minCut(L, cuts.get(i), cuts, dp);
//                int rightAnswer = minCut(cuts.get(i), R, cuts, dp);
//                leastCost = Math.min(leastCost, leftAnswer + rightAnswer);
//            }
//        }
//        // if no cuts applied. its cost is 0.
//        int result = leastCost == Integer.MAX_VALUE ? 0 : leastCost + (R-L);
//        dp.put(L+"|"+R, result);
//        return result;
//    }
}

//package LeetCode;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class RodCuttingProblem {
//
//    public int minCost(int n, int[] cuts) {
//        Arrays.sort(cuts);
//        Map<String, Integer> dp = new HashMap<>();
//        return minCut(0, n, cuts, dp);
//    }
//
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
//}

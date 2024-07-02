package LeetCode.DynamicProgramming;

// f(n, k) = min(max(f(n-x, k-1), f()))

public class A_EggDrop {
    public int eggDrop(int eggs, int floors) {
        int[][] dp = new int[floors+1][eggs+1];
        for(int e = 1; e <= eggs; e++){
            dp[1][e] = 1;   // IMPORTANT!
            // this takes care of f-1, in below recursion
        }
        for(int f = 1; f <= floors; f++){
            dp[f][1] = f;   // IMPORTANT!
            // this takes care of e-1, in below recursion.
        }

        for(int f = 2; f <= floors; f++){
            for(int e = 2; e <= eggs; e++){
                int minAnswer = Integer.MAX_VALUE;
                for(int x = 1; x < f; x++){
                    int eggBreakResult = dp[x-1][e-1];
                    int eggSurviveResult = dp[f-x][e];
                    int worstCase = Math.max(eggBreakResult, eggSurviveResult);
                    int totalTries = worstCase + 1;
                    minAnswer = Math.min(minAnswer, totalTries);
                }
                dp[f][e] = minAnswer;
            }
        }

        return dp[floors][eggs];
    }

//    private int recur(int n, int k, Integer[][] dp){
//        if(n == 0 || k == 0){
//            return 0;
//        }
//        if(k == 1){
//            return n;
//        }
//        if(n == 1){
//            return 1;
//        }
//        if(dp[n][k] != null){
//            return dp[n][k];
//        }
//        int minAnswer = Integer.MAX_VALUE;
//        for(int x = 1; x < n; x++){
//            int ithFloor = Math.max(eggDrop(n-x, k), eggDrop(x-1, k-1)) + 1;
//            minAnswer = Math.min(minAnswer, ithFloor);
//        }
//        dp[n][k] = minAnswer;
//        return minAnswer;
//    }
}

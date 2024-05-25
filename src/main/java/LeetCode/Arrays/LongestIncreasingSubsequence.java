package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {



    public int lengthOfLIS(int[] A) {
        int n = A.length;
        List<Integer> increasingLis = new ArrayList<>();
        increasingLis.add(A[0]);
        for(int i = 1; i < n; i++){
            int x = Collections.binarySearch(increasingLis, A[i]);
            if(x >= 0){  // element found.
                continue;
            }
            // x = -(insertionPoint) - 1
            // insertionPoint, the index at which the number should have been.
            int idx = (-x)-1;
            if(idx == increasingLis.size()){
                increasingLis.add(A[i]);
            } else {
                increasingLis.set(idx, A[i]);
            }
        }
        return increasingLis.size();
    }

    // O(N^2) -> DP.

//    public int lengthOfLIS(int[] A) {
//        int n = A.length;
//        int[] lis = new int[n];
//        for(int i = 0; i < n; i++)
//            lis[i] = 1;
//
//        for(int i = n-2; i >= 0; i--){
//            for(int j = i+1; j < n; j++){
//                if(A[j] > A[i] && 1+lis[j] > lis[i]){
//                    lis[i] = 1 + lis[j];
//                }
//            }
//        }
//
//        int maxLis = 1;
//        for(int x: lis){
//            maxLis = Math.max(maxLis, x);
//        }
//        return maxLis;
//    }
}

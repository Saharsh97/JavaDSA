package LeetCode.Arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] A) {
        int n = A.length;
        int minLen = Integer.MAX_VALUE;
        int windowSum = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            deque.add(A[i]);
            windowSum += A[i];

            while(!deque.isEmpty() && windowSum >= target){
                minLen = Math.min(minLen, deque.size());
                int x = deque.pollFirst();
                windowSum -= x;
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}

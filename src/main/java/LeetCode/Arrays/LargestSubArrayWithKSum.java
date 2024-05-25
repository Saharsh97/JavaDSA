package LeetCode.Arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithKSum {
    int maxLen(int A[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        map.put(0, -1);
        for(int i = 0; i < n; i++){
            sum += A[i];
            if(!map.containsKey(sum)){
                map.put(sum, i);
            } else {
                maxLen = Math.max(maxLen, i - map.get(sum));
            }
        }
        return maxLen;
    }
}

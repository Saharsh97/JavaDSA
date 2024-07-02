package LeetCode.Arrays;

import java.util.HashMap;
import java.util.Map;

public class A_LongestConsecutiveSequence {
    public int longestConsecutive(int[] A) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int x: A){
            map.put(x, 1);
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            if(!map.containsKey(A[i]-1)){
                int count = 0;
                int x = A[i];
                while(map.containsKey(x)){
                    // we will get min numbers many times in array.
                    // whenever we process it, remove it.
                    map.remove(x);
                    count++;
                    x++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}

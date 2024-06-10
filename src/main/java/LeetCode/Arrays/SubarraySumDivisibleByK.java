package LeetCode.Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleByK {
    public int subarraysDivByK(int[] A, int k) {
        int n = A.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + A[i];
        }
        int[] modArray = new int[n];
        for(int i = 0; i < n; i++){
            modArray[i] = prefixSum[i] >= 0 ? prefixSum[i] % k : (k - (Math.abs(prefixSum[i]) % k)) % k;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int result = 0;
        for(int i = 0; i < n; i++){
            // simpler version:
            // pair this occurrence with all the previous occurrences of same mod.
            // these many pairs with previous occurrence is the answer.
            // this keeps on adding.

            // using maths, use the map.
            if(map.containsKey(modArray[i])){
                result += map.get(modArray[i]);
            }
            map.put(modArray[i], map.getOrDefault(modArray[i], 0) + 1);
        }
        return result;
    }
}

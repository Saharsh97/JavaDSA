package LeetCode.DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A_HappyNumber {
    public boolean isHappy(int n) {
        Map<Long, Boolean> cache = new HashMap<>();
        cache.put(1L, true);
        Set<Long> set = new HashSet<>();
        return recur(n, cache, set);
    }

    private boolean recur(long n, Map<Long, Boolean> cache, Set<Long> set){
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        long sum = 0;
        while(n > 0){
            long r = n%10;
            sum += r * r;
            n = n/10;
        }
        // cycle. return false, and stop the cycle.
        if(set.contains(sum)){
            return false;
        }
        // new number
        set.add(sum);
        boolean answer = recur(sum, cache, set);
        cache.put(sum, answer);
        return answer;
    }
}

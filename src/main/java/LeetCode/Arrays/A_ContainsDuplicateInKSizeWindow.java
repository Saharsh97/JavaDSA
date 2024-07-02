package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A_ContainsDuplicateInKSizeWindow {
    public boolean containsNearbyDuplicate(int[] A, int k) {
        int n = A.length;
        // for each number, store its indices.
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.putIfAbsent(A[i], new ArrayList<>());
            map.get(A[i]).add(i);
        }
        for(List<Integer> list: map.values()){
            for(int i = 1; i < list.size(); i++){
                if(list.get(i) - list.get(i-1) <= k) return true;
            }
        }
        return false;
    }
}

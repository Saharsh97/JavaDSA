package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < B; i++){
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }
        result.add(map.size());
        for(int i = B; i < A.size(); i++){
            int x = A.get(i-B);
            map.put(x, map.get(x)-1);
            if(map.get(x) == 0){
                map.remove(x);
            }
            int y = A.get(i);
            map.put(y, map.getOrDefault(y, 0) + 1);

            result.add(map.size());
        }
        return result;
    }
}

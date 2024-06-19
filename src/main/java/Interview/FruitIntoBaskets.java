package Interview;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public int totalFruit(int[] A) {
        int l = 0;
        int r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 1;
        map.put(A[0], 1);
        for(r = 1; r < A.length; r++){
            map.put(A[r], map.getOrDefault(A[r],0) + 1);

            while(map.size() > 2){
                int existingCount = map.get(A[l]);
                int newCount = existingCount - 1;
                if(newCount == 0){
                    map.remove(A[l]);
                } else {
                    map.put(A[l], newCount);
                }
                l++;
            }

            result = Math.max(result, r-l+1);
        }
        return result;
    }
}

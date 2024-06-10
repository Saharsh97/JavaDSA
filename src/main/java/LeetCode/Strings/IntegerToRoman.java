package LeetCode.Strings;

import java.util.*;

public class IntegerToRoman {
    public String intToRoman(int num) {
        List<Integer> mainNumbers = new ArrayList<>(List.of(1, 5, 10, 50, 100, 500, 1000));
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');

        String answer = "";
        int divider = 1000;
        while(num > 0){
            if(num / divider == 0){
                divider = divider/10;
                continue;
            }
            int n = num / divider;
            int target = n * divider;
            if(n == 4 || n == 9) {
                BinarySearchResponse binarySearchResponse = findIndex(mainNumbers, divider);
                int idx = binarySearchResponse.idx;
                int nextIdx = n == 4 ? idx + 1 : idx + 2;
                int x = mainNumbers.get(idx);
                int nextX = mainNumbers.get(nextIdx);
                answer += map.get(x);
                answer += map.get(nextX);
            } else {
                while(target > 0) {
                    BinarySearchResponse binarySearchResponse = findIndex(mainNumbers, target);
                    int idx = binarySearchResponse.idx;
                    if(!binarySearchResponse.isPresent) idx--;
                    int x = mainNumbers.get(idx);
                    target -= x;
                    answer += map.get(x);
                }
            }

            num = num % divider;
            divider = divider / 10;
        }
        return answer;
    }

    class BinarySearchResponse{
        int idx;
        boolean isPresent;

        public BinarySearchResponse(int idx, boolean isPresent) {
            this.idx = idx;
            this.isPresent = isPresent;
        }
    }

    private BinarySearchResponse findIndex(List<Integer> A, int target){
        int n = A.size();
        int lo = 0;
        int hi = n-1;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(A.get(mid) == target){
                return new BinarySearchResponse(mid, true);
            }
            if(A.get(mid) < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return new BinarySearchResponse(lo, false);
    }
}

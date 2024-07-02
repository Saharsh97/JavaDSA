package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class A_SubArrayWithGivenXOR {
    public int solve(ArrayList<Integer> A, int k) {
        int n = A.size();
        ArrayList<Integer> B = new ArrayList<>();
        B.add(A.getFirst());
        for(int i = 1; i < n; i++){
            B.add(A.get(i) ^ B.get(i-1));
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < B.size(); i++){
            if(B.get(i) == k){     // from 0 to i, the total xor is 6, (if k = 6). so add this to answer.
                count++;
            }
            // I know xor from starting, upto i => B[i];
            // if at this point, any subarray of numbers want to have their xor = 6
            // then the subarray before them, let their xor be y. y should be equal to B[i] ^ 6;
            // draw and check this on paper.
            // If I have seen this xor, from 0 to j equal to y many times, that many times is my answer.
            int xorNeededForAnyPreviousSubArray = B.get(i) ^ k;
            if(map.containsKey(xorNeededForAnyPreviousSubArray)){
                count += map.get(xorNeededForAnyPreviousSubArray);
            }

            // So far this subarray from 0 to i, its xor is B[i]
            // this will help in future computation where this will be j, for another greater i.
            map.put(B.get(i), map.getOrDefault(B.get(i), 0) + 1);
        }
        System.out.println(B);
        return count;
    }
}

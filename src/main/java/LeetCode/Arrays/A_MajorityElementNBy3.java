package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class A_MajorityElementNBy3 {
    public List<Integer> majorityElement(int[] A) {
        List<Integer> result = new ArrayList<>();
        int n = A.length;

        // set m1 and m2 to distinct numbers.
        int m1 = A[0]; int c1 = 1;
        int i = 1;
        // initial count for m1
        // if consecutive
        while(i < n && A[0] == A[i]) {
            i++;
            c1++;
        }
        if(i == n){
            result.add(A[0]);
            return result;
        }
        int m2 = A[i]; int c2 = 1;
        i++;

        for(; i < n; i++){
            int x = A[i];
            if(x == m1){
                c1++;
            }
            else if(x == m2){
                c2++;
            }
            else if(c1 == 0){
                c1 = 1;
                m1 = x;
            }
            else if(c2 == 0){
                c2 = 1;
                m2 = x;
            }
            else if(x != m1 && x != m2){
                c1--;
                c2--;
            }
        }

        int count1 = 0;
        int count2 = 0;
        for(int x: A){
            if(x == m1) count1++;
            if(x == m2) count2++;
        }
        if(count1 > n/3) result.add(m1);
        if(count2 > n/3) result.add(m2);
        return result;
    }
}

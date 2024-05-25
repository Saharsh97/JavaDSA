package LeetCode.BinarySearch;

import java.util.ArrayList;

public class AllocateBooks {
    public int books(ArrayList<Integer> A, int B) {
        int max = Integer.MIN_VALUE;
        for(Integer x: A){
            max = Math.max(max, x);
        }
        int n = A.size();
        if(B > n){
            return -1;
        }
        if(B == n){
            return max;
        }

        int lo = 1;
        int hi = 100005;
        int mid;
        int answer = 0;
        while(lo <= hi){
            mid = (lo + hi)/2;

            int res = studentsNeeded(A, mid, max);
            if(res == -1){
                lo = mid+1;
                continue;
            }
            if(res > B){
                lo = mid+1;
            }
            if(res < B){
                hi = mid-1;
            }
            if(res == B){
                hi = mid-1;
                answer = mid;
            }
        }
        return Math.max(answer, max);
    }

    public int studentsNeeded(ArrayList<Integer> A, int k, int max){
        if(k < max){
            return -1;
        }

        int n = A.size();
        int students = 0;
        int sum = A.get(0);
        for(int i = 1; i < n; i++){
            if(sum + A.get(i) > k){
                students++;
                sum = A.get(i);
            } else {
                sum += A.get(i);
            }
        }
        return students+1;
    }
}

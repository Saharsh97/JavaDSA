package LeetCode.Arrays;

import java.util.Arrays;

public class Inversion {
    public static long getInversions(long A[], int n) {
        return inversions(0, n-1, A);
    }

    public static long inversions(int st, int en, long[] A){
        if(st >= en){
            return 0;
        }
        int n = A.length;
        int mid = st + (en-st)/2;
        long left = inversions(st, mid, A);
        long right = inversions(mid+1, en, A);

        long sum = left + right;
        int j = mid+1;
        for(int i = st; i <= mid; i++){
            while(j <= en && A[j] < A[i]){
                j++;
            }
            sum += j-mid-1;
        }

        Arrays.sort(A, st, en+1);
        return sum;
    }
}

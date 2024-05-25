package LeetCode.Arrays;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] A) {
        int n = A.length;
        int i = n-2;
        while(i >= 0 && A[i] >= A[i+1]) i--;
        if(i == -1){
            Arrays.sort(A);
            return;
        }
        int k = n-1;
        for(k = n-1; k > i; k--){
            if(A[k] > A[i]) break;
        }

        int t = A[i];
        A[i] = A[k];
        A[k] = t;
        Arrays.sort(A, i+1, n);
    }
}

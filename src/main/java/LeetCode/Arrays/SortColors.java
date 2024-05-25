package LeetCode.Arrays;

public class SortColors {
    private void swap(int i, int j, int[] A){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public void sortColors(int[] A) {
        int n = A.length;

        int p = 0;
        while(p < n && A[p] == 0) p++;
        int q = n-1;
        while(q >= 0 && A[q] == 2) q--;

        for(int i = p; i < n; i = Math.max(p, i+1)){
            if(A[i] == 0 && p < n){
                swap(i, p, A);
                while(p < n && A[p] == 0) p++;
            }
        }

        for(int i = q; i >= 0; i = Math.min(i-1, q)){
            if(A[i] == 2 && q >= 0){
                swap(i, q, A);
                while(q >= 0 && A[q] == 2) q--;
            }
        }
    }
}

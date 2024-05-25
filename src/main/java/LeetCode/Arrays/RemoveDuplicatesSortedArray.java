package LeetCode.Arrays;

public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        for(int i = 0; i < n-1; i++){
            if(A[i] == A[i+1]){
                A[i] = 1000;
            }
        }
        int p = 0;
        for(int i = 0; i < n; i++){
            if(A[i] != 1000){
                int t = A[i];
                A[i] = A[p];
                A[p] = t;
                p++;
            }
        }
        return p;
    }
}

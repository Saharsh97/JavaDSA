package LeetCode.Arrays;

public class MergeSortedArrayOrderN {
    public void merge(int[] A, int n, int[] B, int m) {
        int i = n-1; int j = m-1; int k = n+m-1;
        while(i >= 0 && j >= 0){
            if(A[i] > B[j]){
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }

        while(j >= 0){
            A[k--] = B[j--];
        }
    }
}

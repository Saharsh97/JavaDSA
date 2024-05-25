package LeetCode.Arrays;

public class FindDuplicateNumber {
    public int findDuplicate(int[] A) {
        int n = A.length;
        for(int i = 0; i < n; i++){
            int idx = Math.abs(A[i]);
            if(A[idx] < 0){ // if already marked 0, mean A[i] had occurred previously
                return A[i];
            }
            A[idx] = -A[idx];
        }
        return -1;
    }
}

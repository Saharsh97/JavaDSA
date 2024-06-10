package LeetCode.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        int REPLACE = 100005;
        int cnt = 1;
        int current = A[0];
        for(int i = 1; i < n; i++){
            if(A[i] == current){
                current++;
                if(current > 2){
                    A[i] = REPLACE;
                }
            } else {

            }
        }
        return 0;
    }
}

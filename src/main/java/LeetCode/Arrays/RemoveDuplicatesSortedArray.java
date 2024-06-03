package LeetCode.Arrays;

public class RemoveDuplicatesSortedArray {
//    public int removeDuplicates(int[] A) {
//        int n = A.length;
//        for(int i = 0; i < n-1; i++){
//            if(A[i] == A[i+1]){
//                A[i] = 1000;
//            }
//        }
//        int p = 0;
//        for(int i = 0; i < n; i++){
//            if(A[i] != 1000){
//                int t = A[i];
//                A[i] = A[p];
//                A[p] = t;
//                p++;
//            }
//        }
//        return p;
//    }


    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int p = 1;
        int current = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] == current) continue;

            // update current before swapping.
            current = nums[i];
            // swap
            int t = nums[i];
            nums[i] = nums[p];
            nums[p] = t;

            p++;
        }
        return p;
    }
}

package LeetCode.Arrays;

public class RainWaterTrapping {
    public int trap(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        left[0] = A[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1], A[i]);
        }
        int[] right = new int[n];
        right[n-1] = A[n-1];
        for(int i = n-2; i >= 0; i--){
            right[i] = Math.max(right[i+1], A[i]);
        }

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += Math.min(left[i], right[i]) - A[i];
        }
        return sum;
    }

//    public int trap(int[] A) {
//        int n = A.length;
//        int sum = 0;
//        int l = 0;
//        int r = n-1;
//        int lMax = A[l];
//        int rMax = A[r];
//        int i = 0;
//        while(l <= r){
//            sum += Math.min(lMax, rMax) - A[i];
//            i++;
//            if(lMax < r){
//                l++;
//                lMax = Math.max(lMax, A[l]);
//            } else {
//                r--;
//                rMax = Math.max(rMax, A[r]);
//            }
//        }
//        return sum;
//    }
}

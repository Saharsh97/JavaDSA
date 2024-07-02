package LeetCode.BinarySearch;


public class A_MatrixMedian {
    public int median(int A[][], int n, int m) {
        int min = A[0][0]; int max = A[0][m-1];
        for(int i = 0; i < n; i++){
            min = Math.min(A[i][0], min);
            max = Math.max(A[i][m-1], max);
        }
        int target = n*m/2;
        int lo = min;
        int hi = max;
        int mid;
        while(lo <= hi){
            mid = (lo + hi)/2;
            int cnt = 0;
            for(int i = 0; i < n; i++){
                cnt += numbersLessThanEqualTo(A[i], mid);
            }
            if(cnt <= target) lo = mid+1;
            else hi = mid-1;
        }
        return lo;
    }

    private int numbersLessThanEqualTo(int[] A, int k){
        int n = A.length;
        int lo = 0;
        int hi = n-1;
        int mid;
        while(lo <= hi){
            mid = (lo + hi)/2;
            if(A[mid] <= k){
                lo = mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return lo;
    }
}

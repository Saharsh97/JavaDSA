package LeetCode.BinarySearch;

public class MedianOf2SortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if(n > m){  // ensure A is Bigger than B
            return findMedianSortedArrays(B, A);
        }
        int total = n + m;
        int leftSideNumbers = (total+1)/2;
        // if total 5 numbers, then take 3 on left side, median is max on left side.
        int lo = 0;
        int hi = n;
        int mid1, mid2;
        while(lo <= hi){
            mid1 = (lo + hi)/2;
            mid2 = leftSideNumbers - mid1;

            int l1 = Integer.MIN_VALUE; int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE; int r2 = Integer.MAX_VALUE;

            if(mid1-1 < n) l1 = A[mid1-1];
            if(mid2-1 < m) l2 = B[mid2-1];
            if(mid1 < n) r1 = A[mid1];
            if(mid2 < m) r2 = B[mid2];

            if(l1 <= r2 && l2 <= r1){
                return total%2==0 ? (Math.max(l1, l2) + Math.min(r1, r2))/2.0: Math.max(l1, l2);
            }
            if(l1 > r2){
                hi = mid1 - 1;
            } else {
                lo = mid1 + 1;
            }
        }
        return 0.0;
    }
}

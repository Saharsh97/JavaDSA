package LeetCode.BinarySearch;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if(m == 0){
            return n == 0 ? 0 : (n%2!=0 ? A[n/2] : (A[n/2] + A[n/2 - 1])/2.0);
        }
        if(n == 0 || m > n){
            return findMedianSortedArrays(B, A);
        }
        int totalLength = m+n;
        if(A[n-1] < B[0]){
            if(n == m){
                return (A[n-1] + B[0])/2.0;
            } else {
                return totalLength%2!=0 ? A[totalLength/2] : (A[totalLength/2] + A[totalLength/2 -1 ])/2.0;
            }
        }
        if(A[0] > B[m-1]){
            if(n == m){
                return (A[0] + B[m-1])/2.0;
            } else {
                return totalLength%2!=0 ? A[totalLength/2 - m] : (A[totalLength/2 - m] + A[totalLength/2 - m - 1 ])/2.0;
            }
        }
        int numbersPerSide = totalLength/2;
        int lo = 0;
        int hi = n-1;
        int mid;
        while(lo <= hi){
            mid = (lo + hi)/2;

            int numbersLeftSideA = mid+1;
            int numbersLeftSideB = numbersPerSide - numbersLeftSideA;
            int bIndex = numbersLeftSideB-1;

            int res = isValidPartition(mid, bIndex, A, B);
            if(res == 0){
                if(totalLength%2!=0){
                    return mid+1 < n && bIndex+1 < m ? Math.min(A[mid+1], B[bIndex+1]) : A[mid+1];
                } else {
                    int left = bIndex >= 0 && bIndex < m ? Math.max(A[mid], B[bIndex]) : A[mid];
                    int right = mid+1 < n && bIndex + 1 < m ?
                            Math.min(A[mid+1], B[bIndex+1]) :
                            mid + 1 < n ? A[mid+1] : left;
                    return (left + right)/2.0;
                }
            }
            if(res == -1){
                hi = mid-1;
            } else {
                lo = mid+1;
            }
        }
        return 0;
    }

    private int isValidPartition(int mid, int bIndex, int[] A, int[] B){
        if(bIndex < 0){
            if(A[mid] <= B[bIndex+1]){
                return 0;
            }
            return -1;
        }
        if(bIndex+1 == B.length){
            // all numbers of B taken.
            if(B[bIndex] <= A[mid+1]){
                return 0;
            }
            return 1;
        }
        if(A[mid] <= B[bIndex+1] && B[bIndex] <= A[mid+1]){
            return 0;
        }
        if(A[mid] > B[bIndex+1]){
            return -1;
        }
        if(B[bIndex] > A[mid+1]) {
            return 1;
        }
        return 1;
    }
}

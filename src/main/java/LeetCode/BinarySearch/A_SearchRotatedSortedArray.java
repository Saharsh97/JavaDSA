package LeetCode.BinarySearch;

public class A_SearchRotatedSortedArray {
    public int search(int[] A, int target) {
        int n = A.length;
        if(A[0] < A[n-1]){
            return binarySearch(0, n-1, A, target);
        }
        int max = A[n-1];
        int lo = 1;
        int hi = n-2;
        int mid = (lo+hi)/2;
        while(lo <= hi){
            mid = (lo + hi)/2;
            if(A[mid-1] < A[mid] && A[mid] > A[mid+1]){
                break;  // this mid is pivot.
            }
            if(A[mid] > max){
                lo = mid+1;
                max = A[mid];
            } else {
                hi = mid-1;
            }
        }
        int res = binarySearch(0, mid, A, target);
        return res == -1 ? binarySearch(mid+1, n-1, A, target) : res;
    }

    public int binarySearch(int lo, int hi, int[] A, int k){
        int mid;
        while(lo <= hi){
            mid = (lo + hi)/2;
            if(A[mid] == k){
                return mid;
            }
            if(A[mid] > k){
                hi = mid-1;
            }
            if(A[mid] < k){
                lo = mid+1;
            }
        }
        return -1;
    }
}

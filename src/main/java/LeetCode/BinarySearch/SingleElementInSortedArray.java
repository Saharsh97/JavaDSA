package LeetCode.BinarySearch;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] A) {
        int n = A.length;
        int lo = 0;
        int hi = n-1;
        int answer;
        while(lo < hi){
            int mid = (lo + hi)/2;
            int numbersLeftSide = mid;
            if(numbersLeftSide%2 == 0){
                // even numbers on left. So this number SHOULD match with right number.
                // if it does, single element on right side.
                // if it doesn't, single element on left side.
                if(A[mid] == A[mid+1]){
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            } else {
                // odd numbers on left. So this number SHOULD match with left number.
                if(A[mid] == A[mid-1]){
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
        }
        return A[lo];
    }
}

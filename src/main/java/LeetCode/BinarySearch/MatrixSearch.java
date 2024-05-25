package LeetCode.BinarySearch;

public class MatrixSearch {
    public boolean searchMatrix(int[][] A, int target) {
        int n = A.length;
        int m = A[0].length;

        int lo = 0;
        int hi = n-1;
        int mid;
        int possibleRow = 0;
        while(lo <= hi){
            mid = (lo + hi)/2;
            int rowEnd = A[mid][m-1];
            if(target > rowEnd){
                lo = mid+1;
            }
            if(target < rowEnd){
                possibleRow = mid;
                hi = mid-1;
            }
            if(target == rowEnd){
                return true;
            }
        }

        int i = possibleRow;
        lo = 0;
        hi = m-1;
        while(lo <= hi){
            mid = (lo + hi)/2;

            if(A[i][mid] == target){
                return true;
            }

            if(A[i][mid] > target){
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        return false;
    }
}

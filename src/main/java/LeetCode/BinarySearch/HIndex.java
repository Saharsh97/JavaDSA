package LeetCode.BinarySearch;

public class HIndex {
    public int hIndex(int[] A){
        int n = A.length;
        int lo = 0;
        int hi = n;
        int possibleAnswer = 0;
        while(lo <= hi){
            int mid = (lo + hi)/2;
            int numberOfCitations = 0;
            for(int i = 0; i < n; i++){
                if(A[i] >= mid) numberOfCitations++;
            }
            if(numberOfCitations >= mid){
                possibleAnswer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return possibleAnswer;
    }
}

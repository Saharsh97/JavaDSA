package LeetCode.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthMedianOfTwoSortedArray {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        List<Integer> A = new ArrayList<>();
        for(int x: arr1) A.add(x);
        List<Integer> B = new ArrayList<>();
        for(int x: arr2) B.add(x);
        int lo = 0;
        int prevlo = lo;
        int hi = n-1;
        int prevhi = hi;
        int mid;

        while(lo <= hi){
            mid = (lo+hi)/2;
            int numbersLessThanMid = mid;
            int pos = Collections.binarySearch(B, A.get(mid));
            pos = -(pos + 1);
            int totalNumbersLessThanMid = numbersLessThanMid + pos;
            if(totalNumbersLessThanMid == k-1){
                return A.get(mid);
            }
            if(totalNumbersLessThanMid < k-1){
                prevlo = pos-1;
                lo = mid+1;
            }
            if(totalNumbersLessThanMid > k-1){
                prevhi = pos-1;
                hi = mid-1;
            }
        }

        lo = prevlo;
        hi = prevhi;
        while(lo <= hi){
            mid = (lo+hi)/2;
            int numbersLessThanMid = mid;
            int pos = Collections.binarySearch(A, B.get(mid));
            pos = -(pos + 1);
            int totalNumbersLessThanMid = numbersLessThanMid + pos;
            if(totalNumbersLessThanMid == k-1){
                return B.get(mid);
            }
            if(totalNumbersLessThanMid < k-1){
                lo = mid+1;
            }
            if(totalNumbersLessThanMid > k-1){
                hi = mid-1;
            }
        }

        return 0;
    }
}

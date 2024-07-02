package LeetCode.BinarySearch;

import java.util.Random;

public class A_KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length-1, nums.length-k);
    }

    private int find(int[] A, int st, int en, int k){
        int n = A.length;
        int rdx = new Random(System.currentTimeMillis()).nextInt(en-st+1) + st;
        int partitionIndex = partition(A, st, en, rdx);
        if(partitionIndex == k){
            return A[partitionIndex];
        }
        if(partitionIndex > k){ // go left
            // handle duplicates
            int root = A[partitionIndex];
            while(A[partitionIndex] == root) partitionIndex--;
            // search left side of partitionIndex.
            return find(A, st, partitionIndex, k);
        }
        // go right
        int root = A[partitionIndex];
        while(A[partitionIndex] == root) partitionIndex++;
        return find(A, partitionIndex, en, k);
    }

    private int partition(int[] A, int st, int en, int rdx){
        swap(A, rdx, en);
        int pivot = A[en];
        int q = st;
        for(int p = st; p < en; p++){
            // ensure that the number, greater than pivot
            // is on the righter side.
            if(A[p] <= pivot){
                swap(A, p, q);
                q++;
            }
        }
        swap(A, q, en);
        return q;
    }

    private void swap(int[] A, int i, int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}

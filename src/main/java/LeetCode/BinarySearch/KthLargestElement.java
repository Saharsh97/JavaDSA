package LeetCode.BinarySearch;

import java.util.Random;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length-1, nums.length-k);
    }

    private int find(int[] A, int st, int en, int k){
        int n = A.length;
        int rdx = new Random(System.currentTimeMillis()).nextInt(en-st+1) + st;
        int q = partition(A, st, en, rdx);
        if(q == k){
            return A[q];
        }
        if(q > k){
            int root = A[q];
            while(A[q] == root) q--;
            return find(A, st, q, k);
        }
        int root = A[q];
        while(A[q] == root) q++;
        return find(A, q, en, k);
    }

    private int partition(int[] A, int st, int en, int rdx){
        swap(A, rdx, en);
        int pivot = A[en];
        int q = st;
        for(int p = st; p < en; p++){
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

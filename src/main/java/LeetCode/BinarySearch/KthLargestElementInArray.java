package LeetCode.BinarySearch;

import java.util.Random;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        return find(0, nums.length-1, nums, nums.length-k);
    }

    private int find(int st, int en, int[] nums, int k){
        int n = nums.length;
        int rdx = new Random().nextInt(en-st+1) + st;
        swap(rdx, en, nums);
        int pivot = nums[en];

        int q = st;
        for(int i = st; i < en; i++){
            if(nums[i] < pivot){
                swap(q, i, nums);
                q++;
            }
        }
        swap(q, en, nums);

        // handling duplicates.
        int left = q;
        int right = q;
        while(right <= en && nums[right] == nums[q]) right++;
        while(left >= st && nums[left] == nums[q]) left--;

        if(left < k && k < right){
            return nums[q];
        }
        if(k <= left){
            return find(st, left, nums, k);
        }
        return find(right, en, nums, k);
    }

    private void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

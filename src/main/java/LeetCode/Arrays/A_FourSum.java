package LeetCode.Arrays;

import java.util.*;

public class A_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        findKthSum(nums, 0, Long.valueOf(target), 4, path, result);

        List<List<Integer>> answer = new ArrayList<>();
        for(List<Integer> entry: result){
            answer.add(entry);
        }
        return answer;
    }

    private void findKthSum(int[] A, int st, Long target, int k, List<Integer> path, List<List<Integer>> result){
        if(k == 2){
            findTwoSum(A, st, target, path, result);
            return;
        }
        for(int i = st; i < A.length; i++){
            if(i > st && A[i] == A[i-1]) {
                // already checked for this number;
                continue;
            }
            path.add(A[i]);
            Long newTarget = target - A[i];
            findKthSum(A, i+1, newTarget, k-1, path, result);
            path.removeLast();
        }
    }

    private void findTwoSum(int[] A, int st, Long target, List<Integer> path, List<List<Integer>> result){
        int n = A.length;
        int left = st;
        int right = n-1;
        while(left < right){
            Long sum = Long.valueOf(A[left]) + Long.valueOf(A[right]);
            if(sum.equals(target)){
                path.add(A[left]);
                path.add(A[right]);
                result.add(new ArrayList<>(path));
                path.removeLast();
                path.removeLast();
            }
            while(left < right && A[left] == A[left+1]) left++;
            while(right > left && A[right] == A[right-1]) right--;
            left++;
            right--;
            if(sum < target){
                left++;
            } else {
                right--;
            }
        }
    }
}
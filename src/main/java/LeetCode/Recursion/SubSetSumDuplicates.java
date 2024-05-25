package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSumDuplicates {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        permute(0, nums, path, answer, false);
        return answer;
    }

    private void permute(int st, int[] nums, List<Integer> path, List<List<Integer>> answer, boolean isPicked){
        if(st >= nums.length){
            return;
        }

        permute(st+1, nums, path, answer, false);
        if(st > 0 && nums[st] == nums[st-1] && !isPicked){
            return;
        }
        path.add(nums[st]);
        permute(st+1, nums, path, answer, true);
        answer.add(new ArrayList<>(path));
        path.removeLast();

    }

//    private int findSum(List<Integer> path){
//        int sum = 0;
//        for(int i = 0; i < path.size(); i++){
//            sum += path.get(i);
//        }
//        return sum;
//    }
}

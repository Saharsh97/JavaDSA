package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        recur(0, candidates, target, path, answer);
        return answer;
    }

    private void recur(int st, int[] A, int target, List<Integer> path, List<List<Integer>> answer){
        if(target == 0){
            answer.add(new ArrayList<>(path));
            return;
        }
        int n = A.length;
        for(int i = st; i < n; i++){
            if(target - A[i] < 0){
                return;
            }
            path.add(A[i]);
            recur(i, A, target-A[i], path, answer);
            path.removeLast();
        }
    }
}

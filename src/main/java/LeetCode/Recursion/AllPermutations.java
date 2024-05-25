package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {
    public List<List<Integer>> permute(int[] A) {
        int n = A.length;
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        permute(A, path, result);
        return result;
    }

    public void permute(int[] A, List<Integer> path, List<List<Integer>> result){
        if(path.size() == A.length){
            result.add(new ArrayList<>(path));
        }
        for(int i = 0; i < A.length; i++){
            if(!path.contains(A[i])){
                path.add(A[i]);
                permute(A, path, result);
                path.removeLast();
            }
        }
    }
}

package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(i > 0 && A[i] == A[i-1]) continue;
            path.add(A[i]);
            twoSum(i+1, -A[i], A, path, result);
            path.remove(path.size()-1);
        }
        return result;
    }

    public void twoSum(int st, int target, int[] A, List<Integer> path, List<List<Integer>> result){
        int n = A.length;
        int l = st;
        int r = n-1;
        while(l < r){
            if(A[l] + A[r] == target){
                path.add(A[l]);
                path.add(A[r]);
                result.add(new ArrayList<>(path));
                path.remove(path.size()-1);
                path.remove(path.size()-1);
                int currentRight = A[r];
                while(r > l && A[r] == currentRight) r--;
                int currentLeft = A[l];
                while(l < r && A[l] == currentLeft) l++;
            }
            else if(A[l] + A[r] > target){
                int currentRight = A[r];
                while(r > l && A[r] == currentRight) r--;
            } else {
                int currentLeft = A[l];
                while(l < r && A[l] == currentLeft) l++;
            }
        }
    }
}

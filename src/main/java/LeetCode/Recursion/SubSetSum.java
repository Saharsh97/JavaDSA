package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSum {

    public ArrayList<Integer> subsetSums(ArrayList<Integer> A, int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(0);
        recur(0, A, 0, answer);
        return answer;
    }

    public void recur(int i, ArrayList<Integer> A, int sum, List<Integer> answer){
        if(i >= A.size()){
            return;
        }

        recur(i+1, A, sum, answer); // dont pick this number

        sum += A.get(i);    // pick this number
        recur(i+1, A, sum, answer); // whatever updates happen with this number.
        // now this number is alone. add it to list.
        answer.add(sum);    // Important!
        // remove this number.
        sum -= A.get(i);
    }
}

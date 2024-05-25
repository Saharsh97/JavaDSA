package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumber {
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int n = A.size();
        Long sum1 = 1L * n * (n+1) / 2;
        Long sum2 = 0L;
        for(int x: A) sum2 += Long.valueOf(x);

        Long x = sum1 - sum2;


        Long sum3 = 1L * n * (n+1) * (2*n + 1) / 6;
        Long sum4 = 0L;
        for(int k: A) sum4 += 1L*k*k;

        Long y = sum3 - sum4;

        Long B = ((y/x) + x)/2;
        Long C = B - x;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(C.intValue());
        result.add(B.intValue());
        return result;
    }
}

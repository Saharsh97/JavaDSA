package LeetCode.BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class Power {
    public double myPow(double x, int n) {
        if(x == 0){
            return 0.0;
        }

        Map<Integer, Double> dp = new HashMap<>();
        dp.put(0, 1.0);
        dp.put(1, x);
        dp.put(-1, 1.0/x);
        return pow(x, n, dp);
    }

    private double pow(double x, int n, Map<Integer, Double> dp){
        if(dp.containsKey(n)){
            return dp.get(n);
        }

        if(n%2 == 0){
            double res = pow(x, n/2, dp) * pow(x, n/2, dp);
            dp.put(n, res);
            return res;
        } else {
            double res = pow(x, n/2, dp) * pow(x, n > 0 ? n/2+1 : n/2-1, dp);
            dp.put(n, res);
            return res;
        }
    }
}

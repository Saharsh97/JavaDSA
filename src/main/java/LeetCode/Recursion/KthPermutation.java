package LeetCode.Recursion;

import java.util.*;

public class KthPermutation {

    public String getPermutation(int n, int k) {
        List<Integer> available = new ArrayList<>();
        for(int i = 1; i <= n; i++) available.add(i);
        k--;
        String str = "";
        return permute(str, available, n-1, k);
    }

    private String permute(String str, List<Integer> available, int n, int k){
        if(k == 0){
            while(available.size() > 0){
                str += available.get(0);
                available.remove(0);
            }
            return str;
        }

        int idx = k / factorial(n);
        available.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        str += available.get(idx);
        available.remove(idx);
        k = k % factorial(n);
        return permute(str, available, n-1, k);
    }

    private int factorial(int n){
        int x = 1;
        for(int i = 1; i <= n; i++){
            x = x*i;
        }
        return x;
    }

}

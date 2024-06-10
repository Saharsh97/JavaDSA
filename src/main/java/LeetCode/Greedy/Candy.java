package LeetCode.Greedy;

import java.util.Arrays;

public class Candy {
    public int candy(int[] rating) {
        int n = rating.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for(int i = 1; i < n; i++){
            if(rating[i-1] < rating[i]){
                candies[i] = candies[i-1] + 1;
            }
        }

        for(int i = n-2; i >= 0; i--){
            if(rating[i] > rating[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        int sum = 0;
        for(int x: candies) sum += x;
        return sum;
    }
}

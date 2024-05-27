package LeetCode.DynamicProgramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Knapsack {
    private class Item{
        int value;
        int weight;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public int knapSack(int w, int weights[], int values[], int n) {
        List<Item> items = new ArrayList<>();
        for(int i = 0; i < n; i++){
            items.add(new Item(weights[i], values[i]));
        }
        items.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.weight - o2.weight;
            }
        });

        int[][] dp = new int[n][w+1];
        for(int j = items.get(0).weight; j <= w; j++){
            dp[0][j] = items.get(0).value;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= w; j++){
                Item item = items.get(i);
                if(j < item.weight) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], item.value + dp[i-1][j-item.weight]);
            }
        }
        return dp[n-1][w];
    }
}

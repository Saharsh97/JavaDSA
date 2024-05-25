package LeetCode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    public double fractionalKnapsack(int w, Item A[], int n) {
        Arrays.sort(A, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.value*1.0/o2.weight - o1.value*1.0/o1.weight < 0.0 ? -1 : 1;  // important to send -1 or 1.
            }
        });
        int totalWeight = 0;
        double sum = 0.0;
        for(int i = 0; i < n; i++){
            if(w-totalWeight > A[i].weight){
                sum += A[i].value;
                totalWeight += A[i].weight;
            } else {
                int remainingWeight = w-totalWeight;
                sum += (1.0*A[i].value/A[i].weight) * remainingWeight;
                break;
            }
        }
        return sum;
    }
}

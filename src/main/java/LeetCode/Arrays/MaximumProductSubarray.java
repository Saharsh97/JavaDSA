package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class MaximumProductSubarray {

    public int maxProduct(int[] A) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        for(int x: A) numbers.add(x);
        numbers.add(0);

        List<Integer> subArray = new ArrayList<>();
        int maxProduct = 0;
        for(int i = 1; i < numbers.size(); i++){
            if(numbers.get(i) == 0){
                maxProduct = Math.max(maxProduct, computeSubArray(subArray));
                subArray = new ArrayList<>();
            }
            subArray.add(numbers.get(i));
        }
        return maxProduct;
    }

    private int computeSubArray(List<Integer> subArray){
        int n = subArray.size();
        long totalProduct = 1;
        long maxProduct = 0;
        for(int x: subArray) totalProduct *= x;

        long productSoFar = 1;
        for(int i = 0; i < n; i++){
            productSoFar *= subArray.get(i);
            long productRightSide = totalProduct / productSoFar;
            maxProduct = Math.max(maxProduct, Math.max(productSoFar, productRightSide));
        }
        return (int) maxProduct;
    }
}

package LeetCode.Greedy;

public class MinimumTrainPlatforms {
    public  int findPlatform(int arr[], int dep[], int n) {
        int[] counter = new int[2400];
        for(int i = 0; i < n; i++){
            counter[arr[i]]++;
            counter[dep[i]+1]--;
        }
        int sum = 0;
        int maxSum = 0;
        for(int i = 0; i < 2400; i++){
            sum += counter[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}

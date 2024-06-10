package LeetCode.BitManipulation;

public class NumberRepeatNTimesExceptOne {
    public int singleNumber(int[] A) {
        int n = A.length;
        int k = 3; // this could be based on question
        int answer = 0;
        for(int i = 0; i < 32; i++){
            int sum = 0;    // sum of 1s in this position.
            for(int j = 0; j < n; j++){
                int thisBit = (A[j] >> i) & 1;
                sum += thisBit;
            }
            sum %= k;
            if(sum == 1){
                answer |= 1 << i;
            }
        }
        return answer;
    }
}

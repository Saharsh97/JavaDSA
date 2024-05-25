package LeetCode.Arrays;

public class MajorityElementNBy2 {
    public int majorityElement(int[] A) {
        int n = A.length;
        int count = 1;
        int major = A[0];
        for(int i = 1; i < n; i++){
            if(count == 0){
                major = A[i];
                count++;
                continue;
            }
            if(A[i] == major){
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}

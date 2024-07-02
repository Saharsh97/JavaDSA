package LeetCode.Arrays;

public class A_MajorityElementNBy2 {
    public int majorityElement(int[] A) {
        int n = A.length;
        int count = 1;
        int major = A[0];
        for(int i = 1; i < n; i++){
            if(A[i] == major){
                count++;
            } else {
                count--;
            }

            if(count == 0){
                major = A[i];
                count = 1;
            }
        }
        return major;
    }
}

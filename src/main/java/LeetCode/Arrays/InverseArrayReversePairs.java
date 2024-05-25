package LeetCode.Arrays;

public class InverseArrayReversePairs {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return reverse(0, n-1, nums);
    }

    private int reverse(int st, int en, int[] A){
        int n = A.length;
        if(st >= en){
            return 0;
        }

        int mid = st + (en-st)/2;
        int left = reverse(st, mid, A);
        int right = reverse(mid+1, en, A);

        int sum = left + right;
        int j = mid+1;
        for(int i = st; i <= mid; i++){
            while(j <= en && Long.valueOf(A[i]) > 2L*A[j]){
                j++;
            }
            sum += j-(mid+1);
        }

        mergeSort(A, st, mid, en);
        return sum;
    }

    private void mergeSort(int[] A, int st, int mid, int en){
        int[] temp = new int[en-st+1];
        int p = st; int q = mid+1;
        int k = 0;
        while(p <= mid && q <= en && k < en-st+1){
            if(A[p] <= A[q]){
                temp[k] = A[p];
                p++;
            } else {
                temp[k] = A[q];
                q++;
            }
            k++;
        }
        while(p <= mid){
            temp[k] = A[p];
            k++; p++;
        }
        while(q <= en){
            temp[k] = A[q];
            k++; q++;
        }
        for(int i = st; i <= en; i++){
            A[i] = temp[i-st];
        }
    }
}

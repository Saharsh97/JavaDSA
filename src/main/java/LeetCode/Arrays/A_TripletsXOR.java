package LeetCode.Arrays;

public class A_TripletsXOR {
    // O(n^3)
    public int countTripletsONCube(int[] A) {
        int n = A.length;
        int[] xorSum = new int[n];
        xorSum[0] = A[0];
        for(int i = 1; i < n; i++) xorSum[i] = A[i] ^ xorSum[i-1];

        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j; k < n; k++){
                    int leftHalf = i-1 >= 0 ? xorSum[j-1] ^ xorSum[i] : xorSum[j-1] ^ 0;
                    int rightHalf = xorSum[k] ^ xorSum[j-1];
                    if(leftHalf == rightHalf){
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    // O(n^2)
    public int countTripletsONSquare(int[] A) {
        int n = A.length;
        int[] xorSum = new int[n];
        xorSum[0] = A[0];
        for(int i = 1; i < n; i++){
            xorSum[i] = A[i] ^ xorSum[i-1];
        }

        int sum = 0;
        // from i to k, if xorSum is 0, means we can break this into 2 arrays at any point,
        // j can move from i+1 to k (including both). thus answer is k-i count;
        for(int i = 0; i < n; i++){
            int currentXor = A[i];
            // from i to k, if xorSum is 0.
            // then we can take any leftHalf and rightHalf.
            for(int k = i+1; k < n; k++){
                currentXor ^= A[k];
                if(currentXor == 0){
                    sum += k-i;
                }
            }
        }
        return sum;
    }
}

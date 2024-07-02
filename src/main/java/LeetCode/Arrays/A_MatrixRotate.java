package LeetCode.Arrays;

public class A_MatrixRotate {
    public void rotate(int[][] A) {
        int n = A.length;
        for(int i = 0; i < n/2; i++) {
            rotateMatrix(A, i, n);
        }
    }

    private void rotateMatrix(int[][] A, int iteration, int n){
        for(int i = iteration; i < n - 1 - iteration; i++){
            swap4TimesEachNumber(A, iteration, i, n);
        }
    }

    private void swap4TimesEachNumber(int[][] A, int iteration, int i, int n){
        int x = A[iteration][i];
        int y = A[i][n-1-iteration];
        int z = A[n-1-iteration][n-1-i];
        int w = A[n-1-i][iteration];

        A[i][n-1-iteration] = x;
        A[n-1-iteration][n-1-i] = y;
        A[n-1-i][iteration] = z;
        A[iteration][i] = w;
    }
}

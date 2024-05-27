package LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    int size;
    int[] row;
    int[] column;
    int[] rightDiagonal;
    int[] leftDiagonal;
    int[][] chessBoard;

    public List<List<String>> solveNQueens(int n) {
        initialise(n);
        List<List<String>> result = new ArrayList<>();
        recur(0, result);
        return result;
    }

    private boolean recur(int row, List<List<String>> result){
        if(row == size) {
            result.add(convertBoardToList());
            return true;
        }
        for(int j = 0; j < size; j++){
            if(!isValidPosition(row, j)) continue;
            populatePosition(row, j, 1);
            recur(row+1, result);
            populatePosition(row, j, 0);
        }
        return false;
    }

    private boolean isValidPosition(int i, int j){
        return row[i] == 0 && column[j] == 0 &&
                rightDiagonal[computeRightDiagonalNumber(i,j)] == 0 &&
                leftDiagonal[computeLeftDiagonalNumber(i,j)] == 0;
    }

    private void populatePosition(int i, int j, int value){
        chessBoard[i][j] = value;
        row[i] = value;
        column[j] = value;
        leftDiagonal[computeLeftDiagonalNumber(i, j)] = value;
        rightDiagonal[computeRightDiagonalNumber(i, j)] = value;
    }

    private int computeLeftDiagonalNumber(int i, int j){
        return i + j;
    }

    private int computeRightDiagonalNumber(int i, int j){
        return size-1 + j-i;
    }

    private List<String> convertBoardToList(){
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < size; i++){
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = 0; j < size; j++){
                stringBuilder.append(chessBoard[i][j] == 1 ? "Q" : ".");
            }
            answer.add(stringBuilder.toString());
        }
        return answer;
    }

    private void initialise(int n){
        size = n;
        row = new int[n];
        column = new int[n];
        rightDiagonal = new int[2*n];
        leftDiagonal = new int[2*n];
        chessBoard = new int[n][n];
    }
}

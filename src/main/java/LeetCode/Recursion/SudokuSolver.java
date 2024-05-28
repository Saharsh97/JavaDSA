package LeetCode.Recursion;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        recur(0, 0, board);
        return;
    }

    public boolean recur(int sti, int stj, char[][] board){
        int i = 0; int j = 0;
        boolean foundDot = false;
        for(i = sti; i < 9; i++) {
            for (j = i == sti ? stj : 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    foundDot = true;
                    break;
                }
            }
            if(foundDot) break;
        }

        if(!foundDot) return true;

        for(char k = '1'; k <= '9'; k++){
            if(isValid(board, i, j, k)){
                board[i][j] = k;
                if(recur(i, j, board)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char k){
        for(int j = 0; j < 9; j++){
            if(board[row][j] == k) return false;
        }
        for(int i = 0; i < 9; i++){
            if(board[i][col] == k) return false;
        }
        int boxi = row/3;
        int boxj = col/3;
//        System.out.println(boxi + " " + boxj);
        for(int i = 3 * boxi; i < 3 * (boxi + 1); i++){
            for(int j = 3 * boxj; j < 3 * (boxj + 1); j++){
                if(board[i][j] == k) return false;
            }
        }
        return true;
    }
}

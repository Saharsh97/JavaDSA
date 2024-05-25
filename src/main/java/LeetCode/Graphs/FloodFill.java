package LeetCode.Graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class FloodFill {
    class Cell{
        int i;
        int j;
        int value;

        Cell(int i, int j, int value){
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }

    public int[][] floodFill(int[][] A, int sr, int sc, int color) {
        int n = A.length;
        int m = A[0].length;
        Deque<Cell> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(new Cell(sr, sc, A[sr][sc]));

        while(!bfsQueue.isEmpty()){
            Cell currentCell = bfsQueue.poll();
            int i = currentCell.i;
            int j = currentCell.j;
            int value = currentCell.value;

            A[i][j] = -1;
            if(i-1 >= 0 && A[i-1][j] == value) bfsQueue.add(new Cell(i-1, j, value));
            if(j+1 < m && A[i][j+1] == value) bfsQueue.add(new Cell(i, j+1, value));
            if(i+1 < n && A[i+1][j] == value) bfsQueue.add(new Cell(i+1, j, value));
            if(j-1 >= 0 && A[i][j-1] == value) bfsQueue.add(new Cell(i, j-1, value));
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(A[i][j] == -1) A[i][j] = color;
            }
        }
        return A;
    }
}

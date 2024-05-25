package LeetCode.Graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands {
    class Pair{
        Integer i;
        Integer j;

        public Pair(Integer i, Integer j) {
            this.i = i;
            this.j = j;
        }
    }

    public int numIslands(char[][] A) {
        int n = A.length;
        int m = A[0].length;
        int islands = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(A[i][j] == '1'){
                    islands++;
                    bfs(i, j, A);
                }
            }
        }
        return islands;
    }

    private void bfs(int row, int col, char[][] A){
        int n = A.length;
        int m = A[0].length;
        Deque<Pair> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(new Pair(row, col));

        while(!bfsQueue.isEmpty()){
            Pair cell = bfsQueue.poll();
            int i = cell.i;
            int j = cell.j;
            if(A[i][j]=='-') continue;  // already visited
            A[i][j] = '-';  // now visited;

            if(i > 0 && A[i-1][j]=='1') bfsQueue.add(new Pair(i-1, j));
            if(i < n-1 && A[i+1][j]=='1') bfsQueue.add(new Pair(i+1, j));
            if(j > 0 && A[i][j-1]=='1') bfsQueue.add(new Pair(i, j-1));
            if(j < m-1 && A[i][j+1]=='1') bfsQueue.add(new Pair(i, j+1));
        }
    }
}

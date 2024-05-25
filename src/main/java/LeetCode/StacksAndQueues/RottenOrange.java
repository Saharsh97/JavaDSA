package LeetCode.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottenOrange {
    class Tuple{
        int i;
        int j;
        int time;

        public Tuple(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        Deque<Tuple> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(A[i][j] == 2){
                    q.add(new Tuple(i, j, 0));
                    A[i][j] = -1;
                }
            }
        }

        int maxTime = 0;
        while(!q.isEmpty()){
            Tuple pair = q.pollFirst();
            int i = pair.i;
            int j = pair.j;
            int time = pair.time;

            maxTime = Math.max(maxTime, time);
            if(i-1 >= 0 && A[i-1][j]==1) {
                q.add(new Tuple(i-1, j, time+1));
                A[i-1][j] = -1;
            }
            if(i+1 < n && A[i+1][j]==1){
                q.add(new Tuple(i+1, j, time+1));
                A[i+1][j] = -1;
            }
            if(j-1 >= 0 && A[i][j-1]==1){
                q.add(new Tuple(i, j-1, time+1));
                A[i][j-1] = -1;
            }
            if(j+1 < m && A[i][j+1]==1){
                q.add(new Tuple(i, j+1, time+1));
                A[i][j+1] = -1;
            }
        }

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(A[i][j]==1) return -1;
        return maxTime;
    }
}

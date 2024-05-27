package LeetCode.Recursion;

import java.util.ArrayList;

public class RatInAMaze {

    class Movement{
        int r;
        int c;
        String value;

        public Movement(int r, int c, String value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    Movement[] movements = new Movement[]{
            new Movement(0, 1, "R"),
            new Movement(1, 0, "D")
//            new Movement(0, -1, "L"),
//            new Movement(-1, 0, "U")
    };

    public ArrayList<String> findPath(int[][] M, int n) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        recur(0, 0, M, n, path, result);
        return result;
    }

    public void recur(int i, int j, int[][] M, int n, StringBuilder path, ArrayList<String> result){
        if(i == n-1 && j == n-1){
            result.add(path.toString());
            return;
        }

        for(Movement movement: movements){
            int newR = i + movement.r;
            int newC = j + movement.c;
            if(0 <= newR && newR < n && 0 <= newC && newC < n && M[newR][newC]==1){
                path.append(movement.value);
                recur(newR, newC, M, n, path, result);
                path.delete(path.length()-1, 1);
            }
        }
        M[i][j] = -1;
    }
}

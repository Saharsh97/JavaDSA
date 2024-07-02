package LeetCode.StacksAndQueues;

import java.util.Stack;

public class A_CelebrityProblem {
    public int celebrity(int M[][], int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) stack.push(i);
        while(stack.size() > 1){
            int a = stack.pop();
            int b = stack.pop();
            if(M[a][b] == 1){   // a knows b. a cant be celebrity, and b could be celebrity. push b to stack.
                stack.push(b);
            } else if(M[b][a] == 1){
                stack.push(a);
            }
        }
        if(stack.isEmpty()) return -1;
        int celeb = stack.pop();
        // celeb should not know anyone.
        for(int j = 0; j < n; j++){
            if(M[celeb][j] == 1) return -1;
        }
        // everyone else should know celeb.
        for(int i = 0; i < n; i++) {
            if(i == celeb) continue;
            if(M[i][celeb] != 1) return -1;
        }
        return celeb;
    }
}

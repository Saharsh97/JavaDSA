package LeetCode.StacksAndQueues;

import java.util.*;

public class MaxOfMinOfEveryWindow {

    public int[] maxMinWindow(int[] A, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        left[0] = -1;
        stack.push(0);
        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]) stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        right[n-1] = n;
        stack.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!stack.isEmpty() && A[stack.peek()] >= A[i]) stack.pop();
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // this number's window size, for which it will be the least.
        int[] minForWindowSize = new int[n];
        for(int i = 0; i < n; i++){
            minForWindowSize[i] = right[i] - left[i] - 1;
        }

        int[] answer = new int[n];
        Arrays.fill(answer, Integer.MIN_VALUE);
        for(int i = 0; i < n; i++){
            int key = minForWindowSize[i];
            answer[key-1] = Math.max(answer[key-1], A[i]);
        }
        for(int i = n-2; i >= 0; i--){
            answer[i] = Math.max(answer[i], answer[i+1]);
        }
        return answer;
    }
}

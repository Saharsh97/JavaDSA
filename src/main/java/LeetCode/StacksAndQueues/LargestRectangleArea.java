package LeetCode.StacksAndQueues;

import java.util.Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) stack.pop();
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        right[n-1] = n;
        while (!stack.isEmpty()) stack.pop();
        stack.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!stack.isEmpty() && A[stack.peek()] > A[i]) stack.pop();
            right[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            int length = right[i]-left[i]-1;
            max = Math.max(max, A[i] * length);
        }
        return max;
    }
}

package LeetCode.StacksAndQueues;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Integer min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        // push old min to stack, then this number x
        if(x <= min){
            stack.push(min);
            x = min;
        }
        stack.push(x);
    }

    public void pop() {
        int x = stack.pop();
        if(x == min) min = stack.pop(); // get the next min.
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

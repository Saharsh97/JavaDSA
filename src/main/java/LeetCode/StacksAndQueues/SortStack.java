package LeetCode.StacksAndQueues;

import java.util.*;

public class SortStack {
    public void sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()){
            int x = stack.pop();
            while(!temp.isEmpty() && temp.peek() > x)
                stack.push(temp.pop());
            temp.push(x);
        }
        while(!temp.isEmpty())
            stack.push(temp.pop());
    }
}
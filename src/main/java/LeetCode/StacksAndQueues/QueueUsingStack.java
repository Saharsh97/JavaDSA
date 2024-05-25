package LeetCode.StacksAndQueues;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        // both empty.
        if(s1.isEmpty() && s2.isEmpty()){
            s1.push(x);
        }
        // s1 filled.
        else if(!s1.isEmpty() && s2.isEmpty()){
            s1.push(x);
        }
        // s2 is filled.
        else if(s1.isEmpty() && !s2.isEmpty()){
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            s1.push(x);
        }
    }

    public int pop() {
        if(!s1.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if(!s1.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

package LeetCode.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingQueue {
    private Deque<Integer> q;

    public StackUsingQueue() {
        q = new ArrayDeque<>();
    }

    public void push(int x) {
        q.addLast(x);
    }

    public int pop() {
        return q.pollLast();
    }

    public int top() {
        return q.peekLast();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

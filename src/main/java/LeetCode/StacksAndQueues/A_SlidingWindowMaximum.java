package LeetCode.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class A_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] A, int k) {
        int n = A.length;
        int[] result = new int[n-k+1];
        int p = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < k; i++){
            while(!deque.isEmpty() && deque.peekLast() < A[i]) deque.pollLast();
            deque.add(A[i]);    // descending order of queue
        }
        result[p++] = deque.peekFirst();
        for(int i = k; i < n; i++){
            if(!deque.isEmpty() && deque.peekFirst() == A[i-k]) deque.pollFirst();
            while(!deque.isEmpty() && deque.peekLast() < A[i]) deque.pollLast();
            deque.add(A[i]);
            result[p++] = deque.peekFirst();
        }
        return result;
    }
}

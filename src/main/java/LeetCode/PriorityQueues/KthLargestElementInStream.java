package LeetCode.PriorityQueues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInStream {

    final PriorityQueue<Integer> pq;
    final int k;

    public KthLargestElementInStream(int k, int[] A) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for(int x: A){
            add(x);
        }
    }

    public int add(int n) {
        if(pq.size() < k){
            pq.add(n);
        }
        // now my queue contains only k numbers.
        // the least of these k numbers in Min PriorityQueue, will be the kth largest of these k numbers.
        // if new number, is smaller than the top (kth largest). Ignore it.
        // otherwise if we push this to pq, the the top is (k+1)th largest.

        // if the new number, is greater than top (kth largest).
        // means if we push this to pq, it will update the kth largest. hence remove the older kth largest.
        else if(pq.peek() > n){
            pq.poll();
            pq.add(n);
        }
        return pq.peek();   // the top element of k numbers in min pq, is the kth largest.
    }
}

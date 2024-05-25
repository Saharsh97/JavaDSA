package LeetCode.PriorityQueues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int x: nums){
            pq.add(x);
        }
        for(int i = 0; i < k-1; i++){
            pq.poll();
        }
        return pq.peek();
    }
}

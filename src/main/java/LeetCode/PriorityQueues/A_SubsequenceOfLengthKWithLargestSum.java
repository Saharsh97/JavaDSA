package LeetCode.PriorityQueues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A_SubsequenceOfLengthKWithLargestSum {

    class Pair{
        Integer first;
        Integer second;

        Pair(Integer first, Integer second){
            this.first = first;
            this.second = second;
        }
    }

    public int[] maxSubsequence(int[] A, int k) {
        int n = A.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.first - o1.first;
            }
        });
        for(int i = 0; i < n; i++) {
            Pair pair = new Pair(A[i], i);
            pq.add(pair);
        }
        // sorting the pair by descending values

        PriorityQueue<Pair> indexPQ = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.second - o2.second;
            }
        });
        // you just need to have top k numbers.
        // then just get the answer in ascending order of the indices.
        while (indexPQ.size() < k){
            indexPQ.add(pq.poll());
        }

        int[] result = new int[k];
        int idx = 0;
        while(!indexPQ.isEmpty()){
            result[idx] = indexPQ.poll().first;
            idx++;
        }
        return result;
    }
}

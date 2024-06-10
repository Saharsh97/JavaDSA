package LeetCode.PriorityQueues;

import LeetCode.GeneralDS.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Pair<Integer, Integer>> tasks = new ArrayList<>();
        int n = profits.length;
        for(int i = 0; i < n; i++){
            tasks.add(new Pair<>(profits[i], capital[i]));
        }
        tasks.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.second - o2.second;   // ascending order of capital
            }
        });
        int i = 0;
        PriorityQueue<Pair<Integer, Integer>> maxPQ = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o2.first - o1.first;     // descending order of profit. max PQ of profit.
            }
        });
        while(k > 0){
            // 1st iteration: add all the affordable tasks
            // 2nd iteration: pick the next set of tasks, given the new budget w.
            // since profits are positive, you will always have a better budget, hence you will add more tasks with more capital requirement.
            // so no need to reset i.
            while(i < n && tasks.get(i).second <= w){
                maxPQ.add(tasks.get(i));
                i++;
            }

            if(maxPQ.isEmpty()) break;
            Pair<Integer, Integer> mostProfitableTask = maxPQ.poll();
            w += mostProfitableTask.first;

            k--;
        }
        return w;
    }
}

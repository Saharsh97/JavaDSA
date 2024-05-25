package LeetCode.PriorityQueues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFromDataStream {

    private PriorityQueue<Integer> minPQ;
    private PriorityQueue<Integer> maxPQ;
    private double currentMedian;
    private int totalNumbers;

    public MedianFromDataStream() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        currentMedian = 0.0;
        totalNumbers = 0;
    }

    public void addNum(int num) {
        if(totalNumbers == 0){
            minPQ.add(num);
            currentMedian = num*1.0;
        }
        else if(totalNumbers == 1){
            int top = minPQ.poll();
            if(top < num){
                minPQ.add(num);
                maxPQ.add(top);
            } else {
                minPQ.add(top);
                maxPQ.add(num);
            }
            currentMedian = 1.0*(minPQ.peek() + maxPQ.peek())/2;
        }
        else {
            rearrange(num);
        }
        totalNumbers++;
    }

    private void rearrange(int num) {
        if(totalNumbers%2 == 0){
            if(maxPQ.peek() < num && num < minPQ.peek()){
                currentMedian = num;
            }
            if(maxPQ.peek() >= num){
                currentMedian = maxPQ.poll();
                maxPQ.add(num);
            }
            else if(minPQ.peek() <= num){
                currentMedian = minPQ.poll();
                minPQ.add(num);
            }
        } else {
            if(num > currentMedian){
                maxPQ.add((int) currentMedian);
                minPQ.add(num);
            } else {
                maxPQ.add(num);
                minPQ.add((int)currentMedian);
            }
            currentMedian = 1.0*(minPQ.peek() + maxPQ.peek())/2.0;
        }
    }

    public double findMedian() {
        return currentMedian;
    }
}

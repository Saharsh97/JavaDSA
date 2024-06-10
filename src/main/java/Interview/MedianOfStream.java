package Interview;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class MedianOfStream {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    //  6 5 3 1 2 4 8
    //  6
    //  5 max 6 min
    //  max 3, 5, min 6
    // max 1, 3, min 5, 6, => 3
    //  2 with max 3, 2 with min 5
    // max 1, 2, 3 med, min 5 , 6



    public static List<Integer> runningMedian(List<Integer> A) {
        int n = A.size();
        // if(n == 1){
        //     return List.of(A.get(0));
        // }
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });

        List<Integer> result = new ArrayList<>();

        result.add(A.get(0));
        if(n == 1){
            return result;
        }

        int min = A.get(0) < A.get(1) ? A.get(0) : A.get(1);
        int max = A.get(0) > A.get(1) ? A.get(0) : A.get(1);
        maxPQ.add(min);
        minPQ.add(max);
        result.add(maxPQ.peek());

        for(int i = 2; i < n; i++){
            if((i+1) % 2 != 0) {
                result.add(handleOddNumbers(maxPQ, minPQ, A.get(i)));
            } else {
                result.add(handleEvenNumbers(maxPQ, minPQ, A.get(i)));
            }
        }

        return result;
    }

    private static int handleOddNumbers(PriorityQueue<Integer> maxPQ, PriorityQueue<Integer> minPQ, int num){
        if(num < minPQ.peek()){
            maxPQ.add(num);
        } else {
            int x = minPQ.poll();
            maxPQ.add(x);
            minPQ.add(num);
        }
        return maxPQ.peek();
    }

    private static int handleEvenNumbers(PriorityQueue<Integer> maxPQ, PriorityQueue<Integer> minPQ, int num){
        if(maxPQ.peek() < num){
            minPQ.add(num);
        } else {
            int x = maxPQ.poll();
            minPQ.add(x);
            maxPQ.add(num);
        }
        return maxPQ.peek();
    }

}

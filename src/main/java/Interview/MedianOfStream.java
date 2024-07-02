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
        PriorityQueue<Integer> leftPQ = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        PriorityQueue<Integer> rightPQ = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });

        List<Integer> result = new ArrayList<>();

        // n == 1
        result.add(A.get(0));
        if(n == 1){
            return result;
        }

        // n == 2
        int min = A.get(0) < A.get(1) ? A.get(0) : A.get(1);
        int max = A.get(0) > A.get(1) ? A.get(0) : A.get(1);
        leftPQ.add(min);
        rightPQ.add(max);
        result.add(leftPQ.peek());

        // n > 2
        for(int i = 2; i < n; i++){
            if((i+1) % 2 != 0) {
                result.add(handleOddNumbersInPQs(leftPQ, rightPQ, A.get(i)));
            } else {
                result.add(handleEvenNumbersInPQs(leftPQ, rightPQ, A.get(i)));
            }
        }

        return result;
    }

    private static int handleOddNumbersInPQs(PriorityQueue<Integer> leftPQ, PriorityQueue<Integer> rightPQ, int num){
        if(num < rightPQ.peek()){
            leftPQ.add(num);
        } else {
            int x = rightPQ.poll();
            leftPQ.add(x);
            rightPQ.add(num);
        }
        return leftPQ.peek();
    }

    private static int handleEvenNumbersInPQs(PriorityQueue<Integer> leftPQ, PriorityQueue<Integer> rightPQ, int num){
        if(leftPQ.peek() < num){
            rightPQ.add(num);
        } else {
            int x = leftPQ.poll();
            rightPQ.add(x);
            leftPQ.add(num);
        }
        return leftPQ.peek();
    }

}

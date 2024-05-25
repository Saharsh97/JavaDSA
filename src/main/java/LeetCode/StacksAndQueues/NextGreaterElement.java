package LeetCode.StacksAndQueues;

import java.util.*;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] queries, int[] A) {
        int n = A.length;
        Stack<Integer> stk = new Stack<>();
        int[] nextGreater = new int[n];
        nextGreater[n-1] = -1;
        stk.push(A[n-1]);
        for(int i = n-2; i >= 0; i--){
            while(!stk.isEmpty() && stk.peek() < A[i]) stk.pop();
            nextGreater[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(A[i]);
        }

        Map<Integer, Integer> aIndex = new HashMap<>();
        for(int i = 0; i < n; i++){
            aIndex.put(A[i], i);
        }

        n = queries.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = nextGreater[aIndex.get(queries[i])];
        }
        return result;
    }

    public ArrayList<Integer> nextSmallerElement(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> nextSmaller = new ArrayList<>();
        if(n == 0) return nextSmaller;
        nextSmaller.add(-1);
        stk.push(A.get(0));
        for(int i = 1; i < n; i++){
            while(!stk.isEmpty() && stk.peek() >= A.get(i)) stk.pop();
            nextSmaller.add(stk.isEmpty() ? -1 : stk.peek());
            stk.push(A.get(i));
        }
        return nextSmaller;
    }
}

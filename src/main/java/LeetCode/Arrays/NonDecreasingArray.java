package LeetCode.Arrays;

import java.util.Stack;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] A) {
        int n = A.length;

        int[] leftSmaller = new int[n];
        leftSmaller[0] = -1;
        Stack<Integer> nextSmallerOnLeft = new Stack<>();
        nextSmallerOnLeft.push(0);
        for(int i = 1; i < n; i++){
            while(!nextSmallerOnLeft.isEmpty() && A[nextSmallerOnLeft.peek()] > A[i])
                nextSmallerOnLeft.pop();
            leftSmaller[i] = nextSmallerOnLeft.isEmpty() ? -1 : nextSmallerOnLeft.peek();
            nextSmallerOnLeft.push(i);
        }

        int[] rightGreater = new int[n];
        rightGreater[n-1] = n;
        Stack<Integer> nextGreaterOnRight = new Stack<>();
        nextGreaterOnRight.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!nextGreaterOnRight.isEmpty() && A[nextGreaterOnRight.peek()] < A[i])
                nextGreaterOnRight.pop();
            rightGreater[i] = nextGreaterOnRight.isEmpty() ? n : nextGreaterOnRight.peek();
            nextGreaterOnRight.push(i);
        }

        boolean leftNotPossible = false;
        int leftIncidents = 0;
        for(int i = 0; i < n; i++){
            if(i - leftSmaller[i] == 2) leftIncidents++;
            if(i - leftSmaller[i] > 2) leftNotPossible = true;
        }
        boolean rightNotPossible = false;
        int rightIncidents = 0;
        for(int i = n-1; i >= 0; i--){
            if(rightGreater[i] - i == 2) rightIncidents++;
            if(rightGreater[i] - i> 2) rightNotPossible = true;
        }
        if(leftNotPossible && rightNotPossible) return false;
        if(leftIncidents > 1 || rightIncidents > 1) return false;
        return true;
    }
}

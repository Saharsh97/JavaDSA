package LeetCode.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {

    class Data{
        Integer value;
        Integer index;

        public Data(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }
    }

    Stack<Data> stack;
    int idx;

    public StockSpanProblem() {
        stack = new Stack<>();
        stack.push(new Data(Integer.MAX_VALUE, -1));
        idx = 0;
    }

    public int next(int price) {
        while(stack.peek().value < price)
            stack.pop();
        int answer = idx - stack.peek().index;
        stack.push(new Data(price, idx++));
        return answer;
    }
}

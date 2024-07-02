package LeetCode.StacksAndQueues;

import java.util.Stack;

/*
The span of the stock's price in one day is the maximum number of
consecutive days (starting from that day and going backward)
for which the stock price was less than or equal to the price of that day.
 */
public class A_StockSpanProblem {

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

    public A_StockSpanProblem() {
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

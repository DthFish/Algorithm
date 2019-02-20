package stack;

import java.util.Stack;

/**
 * LeetCode 155
 * 最小栈：用额外的一个栈来存取每次的最小值
 */
public class MinStack {
    private Stack<Integer> data;
    private Stack<Integer> minData;

    public MinStack() {
        data = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int x) {
        if (minData.isEmpty() || x < minData.peek()) {
            minData.push(x);
        } else {
            minData.push(minData.peek());
        }
        data.push(x);

    }

    public void pop() {
        data.pop();
        minData.pop();

    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minData.peek();
    }
}

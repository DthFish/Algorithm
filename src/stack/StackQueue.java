package stack;

import java.util.Stack;

/**
 * LeetCode 232
 * 栈实现队列：两个栈相互倒
 */
public class StackQueue {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public StackQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        while (!second.empty()) {
            first.push(second.pop());
        }
        first.push(x);
    }

    public int pop() {
        while (!first.empty()) {
            second.push(first.pop());
        }
        return second.pop();
    }

    public int peek() {
        while (!first.empty()) {
            second.push(first.pop());
        }
        return second.peek();
    }

    public boolean empty() {
        return first.empty() && second.empty();
    }
}

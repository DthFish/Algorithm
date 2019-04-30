package offer;

import java.util.Stack;

/**
 * 剑指 offer 9：用两个栈实现队列
 */
public class Question9 {

    private static class MyQueue<T> {
        private Stack<T> stack;
        private Stack<T> stack2;

        public MyQueue() {
            this.stack = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public T deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.pop();
            } else if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    stack2.push(stack.pop());
                }
                return stack2.pop();
            } else {
                return null;
            }

        }

        public void appendTail(T t) {
            stack.push(t);
        }

        public boolean isEmpty() {
            return stack.isEmpty() && stack2.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.appendTail(i);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.deleteHead());
        }

    }
}

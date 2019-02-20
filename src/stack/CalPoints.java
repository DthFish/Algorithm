package stack;

import java.util.Stack;

/**
 * LeetCode 682
 * 棒球比赛:用栈就完事了
 */
public class CalPoints {

    public static void main(String[] args) {
        String[] ops1 = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops1));
        String[] ops2 = {"5"};
        System.out.println(calPoints(ops2));
        String[] ops3 = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(ops3));
    }

    public static int calPoints(String[] ops) {
        int total = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);

                    break;
                case "+":
                    int temp = stack.pop();
                    int num = temp + stack.peek();
                    stack.push(temp);
                    stack.push(num);
                    break;
                default:
                    stack.push(Integer.valueOf(ops[i]));
                    break;
            }
        }
        while (!stack.empty()) {
            total += stack.pop();
        }
        return total;
    }
}

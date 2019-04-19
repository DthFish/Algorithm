package leetcode;

import java.util.Stack;

/**
 * leetcode 32:最长有效括号
 */
public class Question32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses("))))()"));
        System.out.println(longestValidParentheses("((())))"));
        System.out.println(longestValidParentheses("(()(((()"));
        System.out.println(longestValidParentheses("((((()))"));
    }


    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.empty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    max = stack.empty() ? Math.max(max, i - start + 1) : Math.max(max, i - stack.peek());
                }
            }
        }
        return max;

    }
}

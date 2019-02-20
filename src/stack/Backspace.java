package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * LeetCode 844
 * 比较含退格的字符串"#"表示退格:用栈处理字符串后比较
 */
public class Backspace {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));

    }

    public static boolean backspaceCompare(String S, String T) {
        if (null == S && null == T) {
            return true;
        }
        if (null == S) {
            S = "";
        }
        if (null == T) {
            T = "";
        }
        return backspace(S).equals(backspace(T));

    }

    public static String backspace(String value) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            switch (c) {
                case '#':
                    if (!stack.empty()) {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }
        return Arrays.toString(stack.toArray());

    }
}

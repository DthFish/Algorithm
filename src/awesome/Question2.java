package awesome;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 输入 1 + 2 * 3 - 2 =，输出 5
 * 这里直接从控制台输入，可以修改成字符串输入
 * 思路：
 * 需要通过把输入的内容转换成逆波兰表达式，再计算。
 * 使用两个栈 s1，s2，如果是数字存入 s1，
 * 如果是符号先判断 s2 里面是否有优先级大于等于该符号的符号，如果有，先出栈添加到 s1，再把本次的符号添加到 s2
 * 等结束的时候把所有 s1 中的元素，出栈压到 s2，这样再从 s2 中出来的顺序就是逆波兰表达式。
 * 如果需要考虑括号则遇到 ( 直接放入 s2，当遇到 ) 时，则把两个括号中的符号拿出来，添加到 s1
 */
public class Question2 {
    public static void main(String[] args) {

        String c;
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        do {
            c = scanner.nextLine().trim();
            if (isNumber(c)) {
                stack.push(c);
            } else if ("+".equals(c) || "-".equals(c)) {
                while (!stack2.isEmpty()) {
                    String pop = stack2.pop();
                    stack.push(pop);
                }
                stack2.push(c);
            } else if ("*".equals(c) || "/".equals(c)) {
                while (!stack2.isEmpty() && (stack2.peek().equals("*") || stack2.peek().equals("/"))) {
                    String pop = stack2.pop();
                    stack.push(pop);
                }
                stack2.push(c);
            }

        } while (!"=".equals(c));

        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }

        while (!stack2.isEmpty()) {
            String pop = stack2.pop();
            if (isNumber(pop)) {
                stack.push(pop);
            } else if ("+".equals(pop)) {
                int result = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                stack.push(String.valueOf(result));
            } else if ("-".equals(pop)) {
                String second = stack.pop();
                String first = stack.pop();
                int result = Integer.parseInt(first) - Integer.parseInt(second);
                stack.push(String.valueOf(result));
            } else if ("*".equals(pop)) {
                int result = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                stack.push(String.valueOf(result));
            } else if ("/".equals(pop)) {
                String second = stack.pop();
                String first = stack.pop();
                int result = Integer.parseInt(first) / Integer.parseInt(second);
                stack.push(String.valueOf(result));
            }
        }
        System.out.println(stack.pop());

    }

    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(str).matches();
    }
}

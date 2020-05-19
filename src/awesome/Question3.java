package awesome;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 解析 xml 字符串为树状节点
 * <a>
 *     <b>
 *     </b>
 *     <c>
 *     </c>
 *     <d>
 *         <d>
 *         </d>
 *     </d>
 * </a>
 * 思路：
 * 遇到 < 表示一个 tag 的开始，
 *            如果后面又遇到 / 表示一个这个是 tag 的结束，
 * 期间遇到的非空字母记录下来就是 tag 的名称，
 * 当遇到 > 时，如果是开始则创建节点压入栈 s1，
 *            如果是结束则 s1 中出栈一个元素，此时栈为空则解析完毕，如果不为空则将当前出栈的元素添加为栈顶元素的孩子
 *
 */
public class Question3 {

    public static class Node2 {
        String name;
        List<Node2> children = new ArrayList<>();
    }

    public static Node2 parse(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        char[] chars = str.toCharArray();
        Stack<Node2> stack = new Stack<>();
        String name = "";
        boolean isStartTag = false;
        Node2 current;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '<') {
                isStartTag = true;
                name = "";
            } else if (chars[i] == '>') {
                if (isStartTag) {
                    current = new Node2();
                    current.name = name;
                    stack.push(current);
                } else {
                    if (!stack.isEmpty()) {
                        Node2 pop = stack.pop();
                        if (!pop.name.equals(name)) {
                            throw new IllegalStateException("输入错误");
                        }
                        if (!stack.isEmpty()) {
                            stack.peek().children.add(pop);
                        } else {
                            return pop;
                        }
                    } else {
                        throw new IllegalStateException("输入错误");
                    }
                }

            } else if (chars[i] == '/') {
                isStartTag = false;

            } else if (chars[i] == ' ' || chars[i] == '\t' || chars[i] == '\n') {
            } else {
                name += chars[i];
            }
        }
        throw new IllegalStateException("输入错误");
    }
}

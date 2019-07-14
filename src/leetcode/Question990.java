package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 990. 等式方程的可满足性
 */
public class Question990 {

    public boolean equationsPossible(String[] equations) {
        // 建立图
        ArrayList<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                graph[x].add(y);
                graph[y].add(x);
            }
        }
        // 对图里相等的元素上同样的颜色
        int[] color = new int[26];
        int t = 0;
        for (int i = 0; i < 26; i++) {
            if (color[i] == 0) {
                t++;
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    for (int nodeI : graph[node]) {
                        if (color[nodeI] == 0) {
                            color[nodeI] = t;
                            stack.push(nodeI);
                        }


                    }
                }
            }
        }
        // 对不等式进行判断，如果不等式里的两个元素颜色相等则为 false
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                if (x == y || color[x] != 0 && color[x] == color[y]) {
                    return false;
                }

            }
        }

        return true;
    }


}

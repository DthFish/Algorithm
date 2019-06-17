package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * leetcode 207. 课程表
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 */
public class Question207 {

    public static void main(String[] args) {
        int[][] arr = {{1, 0}};
        System.out.println(canFinish(2, arr));
    }

    /**
     * 统计入度，把入度为 0 的先放进链表；
     * 只要链表非空，就取出节点放到结果集，取出的同时将与这个节点接邻的节点的入度减一，若为 0 则放进链表；
     * 直到链表为空，判断结果集的大小和 numCourses 是否一致
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        if (prerequisites.length == 0) {
            return true;
        }
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                linkedList.addLast(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            Integer i = linkedList.pop();
            res.add(i);
            for (int[] pre : prerequisites) {
                if (pre[1] == i) {
                    inDegree[pre[0]]--;
                    if (inDegree[pre[0]] == 0) {
                        linkedList.addLast(pre[0]);
                    }
                }
            }
        }

        return res.size() == numCourses;
    }

    /**
     * 更加高效的方法
     */
    public static int[] visitStatus;
    public static ArrayList<ArrayList<Integer>> adjList;

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {

        adjList = new ArrayList<>();
        visitStatus = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        // 构建逆接邻表
        for (int[] tmp : prerequisites) {
            adjList.get(tmp[1]).add(tmp[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visitStatus[i] != 0)
                continue;
            if (!dfs(i))
                return false;
        }
        return true;
    }

    /**
     * 深度优先，visitStatus = 1 表示正在访问中 visitStatus = 2 表示已经访问过了
     */
    public static boolean dfs(int i) {
        visitStatus[i] = 1;
        for (int j = 0; j < adjList.get(i).size(); j++) {
            int m = adjList.get(i).get(j);
            if (visitStatus[m] == 2)
                continue;
            // 如果出现等于 1，表示存在环，所以不能完成全部课程s
            if (visitStatus[m] == 1)
                return false;
            if (!dfs(m))
                return false;
        }
        visitStatus[i] = 2;
        return true;
    }
}

package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序：
 */
public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 4);
        graph.addEdge(4, 1);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.topoSortByKahn();
        System.out.println("-------");
        graph.topoSortByDFS();
    }

    private int v;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    /**
     * 1. 统计各个节点的入度
     */
    public void topoSortByKahn() {
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                inDegree[adj[i].get(j)]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            System.out.println("-->" + poll);
            for (int i = 0; i < adj[poll].size(); i++) {
                int get = adj[poll].get(i);
                inDegree[get]--;
                if (inDegree[get] == 0) {
                    queue.offer(get);
                }
            }
        }
    }

    /**
     * 借助逆接邻表的深度优先遍历达到拓扑排序的目的
     */
    public void topoSortByDFS() {
        LinkedList<Integer>[] reverseAdj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            reverseAdj[i] = new LinkedList<>();
        }

        for (int i = 0; i < adj.length; i++) {// 通过接邻表生成逆接邻表
            for (int j = 0; j < adj[i].size(); j++) {
                int k = adj[i].get(j);
                reverseAdj[k].add(i);
            }
        }

        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {// 对于任意一个顶点，先遍历该顶点可达顶点，在遍历自己（因为是逆接邻表，最终表现出来的就是先遍历出无依赖的顶点）
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, reverseAdj, visited);
            }
        }

    }

    private void dfs(int i, LinkedList<Integer>[] reverseAdj, boolean[] visited) {
        for (int j = 0; j < reverseAdj[i].size(); j++) {
            int k = reverseAdj[i].get(j);
            if (visited[k]) continue;
            visited[k] = true;
            dfs(k, reverseAdj, visited);
        }
        System.out.println("-->" + i);
    }
}

package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序：
 */
public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0,4);
        graph.addEdge(4,1);
        graph.addEdge(1,5);
        graph.addEdge(2,3);
        graph.addEdge(3,5);
        graph.topoSortByKahn();
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

}

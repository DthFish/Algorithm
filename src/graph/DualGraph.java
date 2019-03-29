package graph;

import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class DualGraph {
    private int v;
    private LinkedList<Integer>[] adj;

    public DualGraph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public static void main(String[] args) {
        DualGraph graph = new DualGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

        graph.bfs(0, 6);
        System.out.println("-----------");
        graph.dfs(0, 6);

    }

    /**
     * Breadth-First-Search
     */
    public void bfs(int s, int t) {
        if (s == t) return;
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            @SuppressWarnings("ConstantConditions")
            int w = queue.poll();

            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }

        }


    }

    private void print(int[] pre, int s, int t) {
        if (pre[t] != -1 && s != t) {
            print(pre, s, pre[t]);
        }
        System.out.println(String.valueOf(t));
    }

    private boolean found = false;

    /**
     * Depth-First-Search
     */
    public void dfs(int s, int t) {
        found = false;
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        boolean[] visited = new boolean[v];
        dfsPart(s, t, prev, visited);
        print(prev, s, t);
    }

    private void dfsPart(int s, int t, int[] prev, boolean[] visited) {
        if (s == t) {
            found = true;
        }
        if (found) return;
        visited[s] = true;
        for (int i = 0; i < adj[s].size(); i++) {
            int q = adj[s].get(i);
            if (!visited[q]) {
                prev[q] = s;
                dfsPart(q, t, prev, visited);

            }
        }
    }

}

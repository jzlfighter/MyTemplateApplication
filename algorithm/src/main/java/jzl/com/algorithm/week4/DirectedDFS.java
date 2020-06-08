package jzl.com.algorithm.week4;

public class DirectedDFS {

    boolean marked[];
    private int count;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        validateVertext(s);
        dfs(G, s);
    }

    private void dfs(Digraph G, int v) {
        count++;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int count() {
        return count;
    }

    private void validateVertext(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }
}

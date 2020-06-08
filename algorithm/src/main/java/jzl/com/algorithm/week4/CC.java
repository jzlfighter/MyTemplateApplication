package jzl.com.algorithm.week4;

public class CC {

    private boolean[] marked;
    private int[] id;
    private int[] size;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int id(int v) {
        validateVertext(v);
        return id[v];
    }

    public int size(int v){
        validateVertext(v);
        return size[v];
    }

    public boolean connected(int v,int w){
        validateVertext(v);
        validateVertext(w);
        return id(v) == id(w);
    }

    private void validateVertext(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

}

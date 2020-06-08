package jzl.com.algorithm.week4;

import jzl.com.algorithm.week1.Bag;

public class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    private int[] indegree;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    private void validateVertext(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    public void addEdge(int v, int w) {
        validateVertext(v);
        validateVertext(w);
        adj[v].add(w);
        indegree[w]++;
        E++;
    }

    public Iterable<Integer> adj(int v) {
        validateVertext(v);
        return adj[v];
    }

    public int outdegree(int v) {
        validateVertext(v);
        return adj[v].size();
    }

    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for (int v = 0; v < V; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}

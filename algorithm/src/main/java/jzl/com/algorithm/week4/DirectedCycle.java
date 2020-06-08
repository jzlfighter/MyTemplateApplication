package jzl.com.algorithm.week4;

import jzl.com.algorithm.week2.MyStack;

public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private MyStack<Integer> cycle;

    public DirectedCycle(Digraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i] && cycle == null) {
                dfs(G, i);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new MyStack();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                assert check();
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }

    private boolean check() {
        if (hasCycle()) {
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) {
                    first = v;
                }
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }
        return true;
    }

}

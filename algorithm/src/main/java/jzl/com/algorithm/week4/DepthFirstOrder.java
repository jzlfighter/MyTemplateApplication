package jzl.com.algorithm.week4;

import jzl.com.algorithm.week2.MyQueue;
import jzl.com.algorithm.week2.MyStack;

public class DepthFirstOrder {

    private boolean marked[];
    private int[] pre;
    private int[] post;
    private MyQueue<Integer> preorder;
    private MyQueue<Integer> postorder;
    private int preCounter;
    private int postCounter;

    public DepthFirstOrder(Digraph G) {
        pre = new int[G.V()];
        post = new int[G.V()];
        marked = new boolean[G.V()];
        postorder = new MyQueue<>();
        preorder = new MyQueue<>();
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
        assert check();
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        preorder.enqueue(v);
        pre[v] = preCounter++;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                marked[w] = true;
                dfs(g, w);
            }
        }
        postorder.enqueue(v);
        post[v] = postCounter++;
    }

    private void dfs(EdgeWeightedGraph G, int v) {

    }

    public int pre(int v) {
        validateVertex(v);
        return pre[v];
    }

    public int post(int v) {
        validateVertex(v);
        return post[v];
    }

    public Iterable<Integer> pre() {
        return preorder;
    }

    public Iterable<Integer> post() {
        return postorder;
    }

    public Iterable<Integer> reversePost() {
        MyStack<Integer> reverse = new MyStack<>();
        for (int v : postorder) {
            reverse.push(v);
        }
        return reverse;
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    private boolean check() {

        // check that post(v) is consistent with post()
        int r = 0;
        for (int v : post()) {
            if (post(v) != r) {
                System.out.println("post(v) and post() inconsistent");
                return false;
            }
            r++;
        }

        // check that pre(v) is consistent with pre()
        r = 0;
        for (int v : pre()) {
            if (pre(v) != r) {
                System.out.println("pre(v) and pre() inconsistent");
                return false;
            }
            r++;
        }

        return true;
    }
}

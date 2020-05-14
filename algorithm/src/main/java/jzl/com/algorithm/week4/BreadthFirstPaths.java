package jzl.com.algorithm.week4;

import java.util.Queue;
import java.util.Stack;

import jzl.com.algorithm.week2.MyQueue;

public class BreadthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private final int S;

    public BreadthFirstPaths(Graph G,int S){
        this.S = S;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        bfs(G,S);
    }

    private void bfs(Graph g, int s) {
        MyQueue queue = new MyQueue();
        marked[s] = true;
        queue.enqueue(s);
        while (!queue.isEmpty()){
            int v = queue.dequeue();
            for (int w:g.adj(v)){
                if (!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i!=S;i = edgeTo[v]){
            stack.push(i);
        }
        stack.push(S);
        return stack;
    }

}

package jzl.com.algorithm.week4;

import jzl.com.algorithm.week2.MyQueue;

public class DirectedBFS {

    private boolean marked[];
    private int count;


    public DirectedBFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        bfs(G, s);
    }

    private void bfs(Digraph g, int v) {
        MyQueue queue = new MyQueue();
        queue.enqueue(v);
        marked[v] = true;
        count++;
        while (!queue.isEmpty()) {
            queue.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    count++;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public int  count(){
        return count;
    }

}

package jzl.com.algorithm.week4;

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int S;//起点
    public DepthFirstPaths(Graph G,int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        S = s;
        dfs(G,S);
    }

    private void dfs(Graph g, int s) {
        marked[s] = true;
        for (int i:g.adj(s)){
            if (!marked[i]){
                edgeTo[i] = s;
                dfs(g,s);
            }
        }
    }

    private boolean hasPathTo(int v){
        return marked[v];
    }

    private Iterable<Integer> pathTo(int v){
        if (!hasPathTo(v)){
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int i = v;i!=S;i = edgeTo[i]){
            path.push(i);
        }
        path.push(S);
        return path;
    }
}

package jzl.com.algorithm.week4;

import java.util.Iterator;

import jzl.com.algorithm.week1.Bag;

public class Graph {

    private final int V;//定点的数目
    private int E;//边的数目
    private Bag<Integer>[] adj;//邻接表
    public Graph(int v){
        V = v;
        E = 0;
        adj = new Bag[V];
        for (int i = 0;i<V;i++){
            adj[i] = new Bag();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v ,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}

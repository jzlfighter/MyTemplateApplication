package jzl.com.algorithm.week5;

import jzl.com.algorithm.week2.MyQueue;

public class TrieST<Value> {

    private static final int R = 256;
    private Node root;

    public void put(String key, Value val) {
        put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == key.length()) {
            x.value = val;
            return x;
        }
        char c = key.charAt(d);
        return put(x.next[c], key, val, d + 1);
    }

    private Value get(String key) {
        Node node = get(root, key, 0);
        return node == null ? null : (Value) node.value;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        Node node = x.next[c];
        return get(node, key, d + 1);
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    private Iterable<String> keysWithPrefix(String pre) {
        MyQueue q = new MyQueue();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node node, String pre, MyQueue q) {
        if (node == null) {
            return;
        }
        if (node.value != null) {
            q.enqueue(pre);
        }
        for (char c = 0; c < R; c++) {
            collect(node.next[c], pre + c, q);
        }
    }

    public Iterable<String> keysThatMatch(String pat) {
        MyQueue<String> queue = new MyQueue<>();
        collect(root, "", pat, queue);
        return queue;
    }

    private void collect(Node root, String pre, String pat, MyQueue<String> queue) {
        int d = pre.length();
        if (root == null) {
            return;
        }
        if (d == pat.length() && root.value != null) {
            queue.enqueue(pre);
        }
        if (d == pat.length()) {
            return;
        }
        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {
                collect(root.next[c], pre + c, pat, queue);
            }
        }
    }

    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node node, String s, int d, int length) {
        if (node == null) {
            return length;
        }
        if (node.value != null) {
            length = d;
        }
        if (d == s.length()) {
            return length;
        }
        return search(node.next[s.charAt(d)], s, d + 1, length);
    }

    public void delete(String s) {
        root = delete(root, s, 0);
    }

    private Node delete(Node node, String s, int i) {
        if (node == null) {
            return null;
        }
        if (i == s.length()) {
            return null;
        } else {
            node.next[s.charAt(i)] = delete(node.next[s.charAt(i)], s, i + 1);
        }
        if (node.value != null) {
            return node;
        }
        for (char c = 0; c < R; c++) {
            if (node.next[c] != null) {
                return node;
            }
        }
        return null;
    }

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }

}

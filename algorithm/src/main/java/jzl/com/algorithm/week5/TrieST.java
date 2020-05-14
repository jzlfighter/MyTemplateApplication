package jzl.com.algorithm.week5;

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

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }

}

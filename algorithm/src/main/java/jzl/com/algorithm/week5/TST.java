package jzl.com.algorithm.week5;

public class TST<Value> {

    private Node root;

    public void put(String s, Value val) {
        put(root, s, val, 0);
    }

    private Node put(Node node, String s, Value val, int d) {
        char c = s.charAt(d);
        if (node == null) {
            node = new Node();
            node.c = c;
        }
        if (c < node.c) {
            node.left = put(node.left, s, val, d);
        } else if (c > node.c) {
            node.right = put(node.right, s, val, d);
        } else if (d < s.length() - 1) {
            node.mid = put(node.mid, s, val, d + 1);
        } else {
            node.val = val;
        }
        return node;
    }

    public Value get(String key) {
        return get(root, key, 0).val;
    }

    private Node get(Node node, String key, int d) {
        char c = key.charAt(d);
        if (node == null) {
            return null;
        }
        if (c < node.c) {
            return get(node.left, key, d);
        } else if (c > node.c) {
            return get(node.left, key, d);
        } else if (d < key.length() - 1) {
            return get(node.mid, key, d + 1);
        } else {
            return node;
        }
    }

    private class Node {
        private char c;
        private Value val;
        private Node left, mid, right;
    }

}

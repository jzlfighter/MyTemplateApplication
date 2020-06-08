package jzl.com.algorithm.week3;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node rotateLeft(Node node) {
        assert isRed(node.right);
        Node rightChild = node.right;
        rightChild.color = node.color;
        node.color = RED;
        node.right = rightChild.left;
        rightChild.left = node;
        return rightChild;
    }

    private Node rotateRight(Node node) {
        assert isRed(node.left);
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        leftChild.color = node.color;
        node.color = RED;
        return leftChild;
    }

    private void flipColors(Node node) {
        assert isRed(node.left);
        assert isRed(node.right);
        assert !isRed(node);
        node.left.color = BLACK;
        node.right.color = BLACK;
        node.color = RED;
    }

    private boolean isRed(Node node) {
        return node.color == RED;
    }

    private class Node {
        Node left, right;
        Key key;
        Value val;
        int N;
        boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }
}

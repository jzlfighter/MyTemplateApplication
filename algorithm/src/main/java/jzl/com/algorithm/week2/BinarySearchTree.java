package jzl.com.algorithm.week2;

/**
 * com.example.administrator.mytemplateapplication.network.utils
 * Created by kingj on 2020/4/9 0009.
 */
public class BinarySearchTree extends SortAlgorithm implements SampleTree {

    private int N = 0;
    private Node rootNode;

    @Override
    public void put(Comparable a, Object value) {
        N++;
        if (rootNode == null) {
            rootNode = new Node();
            rootNode.key = a;
            rootNode.value = value;
            return;
        }
        put(a, value, rootNode);
    }

    private void put(Comparable key, Object value, Node node) {
        node.count++;
        if (less(key, node.key)) {
            if (node.leftChild == null) {
                Node leftChild = new Node();
                leftChild.key = key;
                leftChild.value = value;
                node.leftChild = leftChild;
            } else {
                put(key, value, node.leftChild);
            }
        } else {
            if (node.rightChild == null) {
                Node rightChild = new Node();
                rightChild.key = key;
                rightChild.value = value;
                node.rightChild = rightChild;
            } else {
                put(key, value, node.rightChild);
            }
        }
    }

    public Object get(Comparable key) {
        if (rootNode == null) {
            return null;
        }
        return get(key, rootNode);
    }

    private Object get(Comparable key, Node node) {
        if (node.key == key) {
            return node.value;
        }
        if (less(node.key, key)) {
            if (node.rightChild == null) {
                return null;
            }
            return get(key, node.rightChild);
        } else {
            if (node.leftChild == null) {
                return null;
            }
            return get(key, node.leftChild);
        }
    }

    public int getChildCount(Comparable key) {
        if (rootNode == null) {
            return -1;
        }
        return getChildCount(key, rootNode);
    }

    private int getChildCount(Comparable key, Node node) {
        if (node.key == key) {
            return node.count;
        }
        if (less(node.key, key)) {
            if (node.rightChild == null) {
                return -1;
            }
            return getChildCount(key, node.rightChild);
        } else {
            if (node.leftChild == null) {
                return -1;
            }
            return getChildCount(key, node.leftChild);
        }
    }

    @Override
    public void delete(Comparable k) {

    }

    private class Node {

        Comparable key;
        Object value;
        Node leftChild;
        Node rightChild;
        int count = 0;

    }
}

package jzl.com.algorithm.week1;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{

    private Node<Item> first = null;
    private int n= 0;

    public Bag(){}

    public boolean isEmpty(){
        return n==0;
    }

    public void add(Item item){
        Node<Item> node = new Node(item);
        Node old = first;
        first = node;
        first.next = old;
        n++;
    }

    public int size(){
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator(first);
    }

    private class BagIterator<Item> implements Iterator{

        private Node<Item> currNode;

        public BagIterator(Node<Item> node){
            currNode = node;
        }

        @Override
        public boolean hasNext() {
            return currNode!=null;
        }

        @Override
        public Item next() {
            Item value = currNode.value;
            currNode = currNode.next;
            return value;
        }
    }

    private class Node<Item>{
        private Item value;
        private Node<Item> next;
        public Node(Item value){
            this.value = value;
        }
    }
}

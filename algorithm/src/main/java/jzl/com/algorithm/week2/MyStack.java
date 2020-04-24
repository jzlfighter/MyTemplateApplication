package jzl.com.algorithm.week2;

import java.util.Iterator;

/**
 * com.example.administrator.mytemplateapplication.network.utils
 * Created by kingj on 2020/3/27 0027.
 */
public class MyStack implements Iterable{

    private Node first;

    public void push(int i){
        if (first==null){
            first = new Node();
            first.value = i;
            return;
        }
        Node node = new Node();
        node.value = i;
        Node temp = first;
        first = node;
        first.next = temp;
    }

    public int pop(){
        if (first == null){
            return -1;
        }
        int value = first.value;
        if (first.next == null){
            first = null;
            return value;
        }
        first = first.next;
        return value;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator{
        @Override
        public boolean hasNext() {
            return first.next!=null;
        }

        @Override
        public Object next() {
            int item = first.value;
            first  = first.next;
            return item;
        }
    }

    private class Node{
        Node next;
        int value;
    }
}

package jzl.com.algorithm.week2;

import java.util.Iterator;

/**
 * com.example.administrator.mytemplateapplication.network.utils
 * Created by kingj on 2020/3/27 0027.
 */
public class MyQueue<Value> implements Iterable<Value> {

    private Object[] queue = new Object[1];
    private int pointer = -1;
    private int start = 0;

    public void enqueue(Value i) {
        pointer++;
        if (pointer >= queue.length) {
            resizeArray();
        }
        queue[pointer] = i;
    }

    private void resizeArray() {
        Object[] newArray = new Object[queue.length * 2];
        for (int i = 0; i < queue.length; i++) {
            newArray[i] = queue[i];
        }
        queue = newArray;
    }

    public Value dequeue() {
        if (pointer == -1) {
            return null;
        }
        if (start > pointer) {
            return null;
        }
        Value result = (Value) queue[start];
        start++;
        if ((pointer - start) < queue.length / 4) {
            downsizeArray();
        }
        return result;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return pointer - start + 1;
    }

    private void downsizeArray() {
        Object[] newArray = new Object[queue.length / 2];
        for (int i = 0; i <= pointer; i++) {
            newArray[i] = queue[i];
        }
        queue = newArray;
        start = 0;
        pointer = queue.length - 1;
    }

    public boolean isEmpty() {
        return start > pointer;
    }

    @Override
    public Iterator<Value> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Value> {

        @Override
        public boolean hasNext() {
            return !isEmpty();
        }

        @Override
        public Value next() {
            return dequeue();
        }
    }
}

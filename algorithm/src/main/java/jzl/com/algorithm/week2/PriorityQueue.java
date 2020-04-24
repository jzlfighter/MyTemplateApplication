package jzl.com.algorithm.week2;

/**
 * com.example.administrator.mytemplateapplication.network.utils
 * Created by kingj on 2020/4/3 0003.
 */
public class PriorityQueue {

    private Comparable[] items;
    private int n = 1;

    public PriorityQueue(int capacity) {
        items = new Comparable[capacity];
    }

    public int insert(Comparable comparable) {
        items[n++] = comparable;
        return swim(n);
    }

    public Comparable getMax() {
        return items[1];
    }

    public void dequeue() {
        Sort.exch(items, 1, n);
        items[n] = null;
        n--;
        sink(1);
    }

    private int swim(int i) {
        int result = 0;
        if (i == 1) {
            result = 1;
            return result;
        }
        while (Sort.less(items[i / 2], items[i])) {
            Sort.exch(items, i, i / 2);
            result = i / 2;
            i = i / 2;
            if (i == 1) {
                break;
            }
        }
        return result;
    }

    private void sink(int i) {
        while (2 * i < n) {
            if (Sort.less(items[i], items[2 * i]) || Sort.less(items[i], items[2 * i + 1])) {
                int j = Sort.less(items[2 * i], items[2 * i + 1]) ? 2 * i + 1 : 2 * i;
                Sort.exch(items, i, j);
                i = j;
            } else {
                return;
            }
        }
    }
}

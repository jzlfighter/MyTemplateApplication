package jzl.com.algorithm.week2;

/**
 * com.example.administrator.mytemplateapplication.network.utils
 * Created by kingj on 2020/4/9 0009.
 */
public abstract class SortAlgorithm {

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i1, int i2) {
        Comparable temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
}

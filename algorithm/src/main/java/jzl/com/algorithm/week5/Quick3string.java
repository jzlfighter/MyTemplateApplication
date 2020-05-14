package jzl.com.algorithm.week5;

public class Quick3string {

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }

    public static void sort(String[] a) {
        sort(a, 0, a.length, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) {
                exch(a, lt++, i++);
            }
            if (t > v) {
                exch(a, gt--, i);
            }
            if (t == v) {
                i++;
            }
        }
        sort(a, lo, lt - 1, d);
        if (v >= 0) {
            sort(a, lt, gt, d + 1);
        }
        sort(a, gt + 1, hi, d);
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i1, int i2) {
        Comparable temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
}

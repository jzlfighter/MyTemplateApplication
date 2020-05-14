package jzl.com.algorithm.week2;

public class InsertionSort extends Sort {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (less(a[i + 1], a[i])) {
                for (int j = i; j >= 0; j--) {
                    if (less(a[j + 1], a[j])) {
                        exch(a, j, j + 1);
                    }
                }
            }
        }
    }

    public static void sort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i < hi; i++) {
            if (charAt(a[i + 1], d) < charAt(a[i], d)) {
                for (int j = i; j >= lo; j--) {
                    if (charAt(a[j + 1], d) < charAt(a[j], d)) {
                        exch(a, j, j + 1);
                    }
                }
            }
        }
    }

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }

}

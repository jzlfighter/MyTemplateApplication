package jzl.com.algorithm.week2;


/**
 * com.example.administrator.mytemplateapplication.network.utils
 * Created by kingj on 2020/3/30 0030.
 */
public class Sort {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 11, 12, 10};
        QuickSort.quickSort(array);
//        HashMap a = new HashMap();
//        arrayMap.put("A",1);
//        arrayMap.put("B",1);
//        arrayMap.put(new A(),1);
//        arrayMap.put(new A(),3);
        System.out.println(",");
    }

    public static void mergeSort(int[] a) {
        if (a.length == 0 || a.length == 1) {
            return;
        }
        int[] aux = new int[a.length];
        sort(aux, a, 0, a.length - 1);
    }

    private static void sort(int[] aux, int[] a, int l, int h) {
        if ((h - l) > 1) {
            sort(aux, a, l, l + (h - l) / 2);
            sort(aux, a, l + (h - l) / 2 + 1, h);
            merge(aux, a, l, l + (h - l) / 2 + 1, h);
        } else if ((h - l) == 1) {
            if (less(a[h], a[l])) {
                exch(a, l, h);
            }
        }
    }

    private static void merge(int[] aux, int[] a, int l, int mid, int h) {
        System.out.println(l + "." + mid + "." + h);
        for (int i = l; i <= h; i++) {
            aux[i] = a[i];
        }
        int curr = l;
        int p1 = l;
        int p2 = mid;
        while (p1 < mid || p2 <= h) {
            System.out.println(p1 + "," + p2 + "," + curr);
            if (p2 > h) {
                a[curr] = aux[p1];
                p1++;
            } else if (p1 >= mid) {
                a[curr] = aux[p2];
                p2++;
            } else if (less(aux[p2], aux[p1])) {
                a[curr] = aux[p2];
                p2++;
            } else {
                a[curr] = aux[p1];
                p1++;
            }
            curr++;
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean less(int v, int w) {
        return v < 0;
    }

    public static void exch(Comparable[] a, int i1, int i2) {
        Comparable temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }

    public static void exch(int[] a, int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
}

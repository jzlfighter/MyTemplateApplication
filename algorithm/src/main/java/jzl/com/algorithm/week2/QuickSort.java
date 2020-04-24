package jzl.com.algorithm.week2;

import java.util.Arrays;
import java.util.Collections;

/**
 * com.example.administrator.mytemplateapplication.network.utils
 * Created by kingj on 2020/4/3 0003.
 */
public class QuickSort {

    public static void quickSort(Comparable a[]) {
        Collections.shuffle(Arrays.asList(a));
        System.out.println(Arrays.toString(a));
        int j = partition(a, 0, a.length);
        System.out.println(j);
        System.out.println(Arrays.toString(a));
        sort(a, 0, j);
        sort(a, j, a.length);
    }

    private static void sort(Comparable[] a, int l, int h) {
        if (h <= l + 1) {
            return;
        }
        System.out.println(l + "," + h);
        int j = partition(a, l, h);
        System.out.println(j);
        System.out.println(Arrays.toString(a));
        sort(a, l, j);
        sort(a, j + 1, h);
    }

    private static int partition(Comparable[] a, int l, int h) {
        int j = l;
        int pointL = l;
        int pointH = h;
        while (true) {
            while (Sort.less(a[++pointL], a[j])) {
                if (pointL >= h - 1) {
                    break;
                }
            }
            while (Sort.less(a[j], a[--pointH])) {
                if (pointH <= 0) {
                    break;
                }
            }
            ;
            if (pointL < pointH) {
                Sort.exch(a, pointL, pointH);
            } else {
                Sort.exch(a, j, pointH);
                j = pointH;
                break;
            }
        }
        return j;
    }

}

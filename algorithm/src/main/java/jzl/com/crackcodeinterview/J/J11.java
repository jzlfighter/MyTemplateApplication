package jzl.com.crackcodeinterview.J;

/**
 * jzl.com.crackcodeinterview.J
 * Created by kingj on 2020/6/18 0018.
 * 10. 11 　 峰 与 谷。 在 一个 整数 数组 中，“ 峰” 是 大于 或 等于 相邻 整数 的 元素， 相应 地，“ 谷” 是 小于 或 等于 相邻 整数 的 元素。
 * 例如， 在 数组{ 5, 8, 6, 2, 3, 4, 6} 中，{ 8, 6} 是 峰，{ 5, 2} 是 谷。 现在 给定 一个 整数 数组， 将 该 数组数组 按 峰 与 谷 的 交替 顺序 排序。
 *
 *
 */
public class J11 {

    void sortValleyPeak(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            int biggestIndex = maxIndex(array, i - 1, i, i + 1);
            if (i != biggestIndex) {
                swap(array, i, biggestIndex);
            }
        }
    }

    int maxIndex(int[] array, int a, int b, int c) {
        int len = array.length;
        int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;
        int max = Math.max(aValue, Math.max(bValue, cValue));
        if (aValue == max) {
            return a;
        } else if (bValue == max) {
            return b;
        } else {
            return c;
        }
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}

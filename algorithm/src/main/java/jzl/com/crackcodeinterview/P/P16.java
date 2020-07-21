package jzl.com.crackcodeinterview.P;

/**
 * jzl.com.crackcodeinterview.P
 * Created by kingj on 2020/6/24 0024.
 * 16. 16 　 部分 排序。 给定 一个 整数 数组， 编写 一个 函数， 找出 索引 m 和 n， 只要 将 m 和 n 之间 的 元素 排好 序， 整个 数组 就是 有序 的。 注意： n- m 尽量 最小， 也就是说， 找出 符合 条件 的 最短 序列。
 */
public class P16 {

    private class Index {
        int start;
        int end;

        @Override
        public String toString() {
            return start + "," + end;
        }
    }

    public Index partSort(int[] array) {
        Index result = new Index();
        int start = -1;
        int startNum = Integer.MAX_VALUE;
        int end = -1;
        int endNum = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                if (array[i] < startNum) {
                    startNum = array[i];
                }
                if (array[i - 1] > endNum) {
                    endNum = array[i - 1];
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (start == -1 && array[i] > startNum) {
                start = i;
            } else if (end == -1 && array[i] > endNum) {
                end = i - 1;
            }
        }
        if (start != -1 && end != -1) {
            result.start = start;
            result.end = end;
            return result;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P16().partSort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19}));
    }

}

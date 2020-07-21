package jzl.com.crackcodeinterview.Q;

import java.util.Random;

/**
 * jzl.com.crackcodeinterview.Q
 * Created by kingj on 2020/6/30 0030.
 * 17. 3 　 随机 集合。 编写 一个 方法， 从 大小 为的 数组 中 随机 选出 个 整数。 要求 每个 元素 被选 中的 概率 相同。
 */
public class Q3 {

    int[] pickMIteratively(int[] original, int m) {
        int[] subset = new int[m];
        for (int i = 0; i < m; i++) {
            subset[i] = original[i];
        }
        for (int i = m; i < original.length; i++) {
            int k = rand(0, i);
            if (k < m) {
                subset[k] = original[i];
            }
        }
        return subset;
    }

    private int rand(int lower, int higher) {
        return lower + (int) (Math.random() * (higher - lower + 1));
    }

}

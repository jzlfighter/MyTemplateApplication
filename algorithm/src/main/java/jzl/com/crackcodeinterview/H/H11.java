package jzl.com.crackcodeinterview.H;

import java.util.ArrayList;

/**
 * jzl.com.crackcodeinterview.H
 * Created by kingj on 2020/6/15 0015.
 * 8. 11 　 硬币。 给定 数量 不限 的 硬币， 币值 为 25 分、 10 分、 5 分 和 1 分， 编写 代码 计算 n分 有 几种 表示 法。
 */
public class H11 {

    int[] coins = new int[]{25, 10, 5, 1};
    int[][] cache;

    int makeChange(int n) {
        cache = new int[n + 1][coins.length];
        return makeChange(n, 0);
    }

    int makeChange(int n, int index) {
        if (index == coins.length - 1) {
            return 1;
        }
        if (cache[n][index] > 0) {
            System.out.println(n + "," + index + "," + cache[n][index]);
            return cache[n][index];
        }
        int ways = 0;
        for (int i = 0; i * coins[index] <= n; i++) {
            int remain = n - i * coins[index];
            ways += makeChange(remain, index + 1);
        }
        cache[n][index] = ways;
        return ways;
    }

    public static void main(String[] args) {
        System.out.println("ways:" + new H11().makeChange(100));
    }

}

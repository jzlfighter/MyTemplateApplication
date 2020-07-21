package jzl.com.crackcodeinterview.Q;

/**
 * jzl.com.crackcodeinterview.Q
 * Created by kingj on 2020/6/29 0029.
 * 17. 2 　 洗牌。 设计 一个 用来 洗牌 的 函数。 要求 做到 完美 洗牌， 也就是说， 这副 牌 52! 种 排列 组合 出现 的 概率 相同。 假设 给定 一个 完美 的 随机数 发生器。
 */
public class Q2 {

    /* lower 和 higher（ 含） 之间 的 随机数 */
    int rand(int lower, int higher) {
        return lower + (int) (Math.random() * (higher - lower + 1));
    }

    int[] shuffleArrayRecursively(int[] cards, int i) {
        if (i == 0) {
            return cards;
        }
        shuffleArrayRecursively(cards, i - 1);
        int k = rand(0, i);
        int temp = cards[k];
        cards[k] = cards[i];
        cards[i] = temp;

        return cards;
    }

    //迭代法
    void shuffleArrayIteratively(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            int k = rand(0, i);
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }
    }
}

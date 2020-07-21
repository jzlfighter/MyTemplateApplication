package jzl.com.crackcodeinterview.P;

import java.util.Random;

/**
 * jzl.com.crackcodeinterview.P
 * Created by kingj on 2020/7/7 0007.
 * 16. 23 　 Rand5 与 Rand7。 给定 rand5()， 实现 一个 方法 rand7()， 即 给定 一个 生成 0 到 4（ 含 0 和 4） 随机数 的 方法， 编写 一个 生成 0 到 6（ 含 0 和 6） 随机数 的 方法。
 */
public class P23 {

    public int rand7() {
        while (true) {
            int num = 5 * rand5() + rand5();
            if (num < 21) {
                return num % 7;
            }
        }
    }

    public int rand5() {
        return new Random().nextInt(5);
    }

}

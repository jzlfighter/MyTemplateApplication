package jzl.com.crackcodeinterview.Q;

/**
 * jzl.com.crackcodeinterview.Q
 * Created by kingj on 2020/6/29 0029.
 * 17. 1 　 不用 加号 的 加法。 设计 一个 函数 把 两个 数字 相加。 不得 使用 + 或者 其他 算术 运算符。
 */
public class Q1 {

    int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }

}

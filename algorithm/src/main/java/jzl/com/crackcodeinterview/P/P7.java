package jzl.com.crackcodeinterview.P;

/**
 * jzl.com.crackcodeinterview.P
 * Created by kingj on 2020/6/22 0022.
 * 16. 7 　 最大 数值。 编写 一个 方法， 找出 两个 数字 中最 大的 那 一个。 不得 使用 if- else 或 其他 比较 运算符。
 */
public class P7 {

    int getMax(int a, int b) {
        int c = a - b;

        int sa = sign(a);//如果a>=0则返回1
        int sb = sign(b);//如果b>=0则返回1
        int sc = sign(c);//取决于a-b是否溢出
//如果a和b有不同的符号，则k = sign(a)
        int use_sign_of_a = sa ^ sb;
//如果a和b有x相同的符号，则k = sign(a-b)
        int use_sign_of_c = flip(sa ^ sb);

        int k = use_sign_of_a * sa + use_sign_of_c * sc;

        int q = flip(k);

        return a * k + b * q;
    }

    /*
    将1翻转为0，0翻转为1
     */
    int flip(int bit) {
        return 1 ^ bit;
    }

    /*
    如果是正数，就返回1；如果是负数，则返回0
     */
    int sign(int a) {
        return flip((a >> 31) & 0x1);
    }

    public static void main(String[] args) {
        System.out.println(new P7().getMax(10,20));
    }

}

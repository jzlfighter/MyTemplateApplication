package jzl.com.crackcodeinterview.J;

/**
 * jzl.com.crackcodeinterview.J
 * Created by kingj on 2020/6/18 0018.
 * 10.8 寻找 重 复数。 给定 一个 数组， 包含 1 到 的 整数， 最大 为 32 000， 数组 可能含有 重复 的 值，
 * 且 的 取值 不定。 若 只有 4 KB 内存 可用， 该 如何 打印 数组 中 所有 重复 的 元素。
 */
public class J8 {

    void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1;//bitset从0开始，数字从1开始
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }

    class BitSet {
        int[] bitset;

        public BitSet(int size) {
            bitset = new int[size >> 5 + 1]; // 除以 32
        }

        boolean get(int pos) {
            int wordNumber = (pos >> 5);//除以32
            int bitNumber = (pos & 0x1F);//除以32取余数
            return (bitset[wordNumber] & (1 << bitNumber)) != 0;
        }

        void set(int pos) {
            int wordNumber = (pos >> 5);
            int bitNumber = (pos & 0x1F);
            bitset[wordNumber] |= 1 << bitNumber;
        }
    }

}

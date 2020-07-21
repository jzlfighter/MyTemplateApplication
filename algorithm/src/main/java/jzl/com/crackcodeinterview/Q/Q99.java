package jzl.com.crackcodeinterview.Q;

import java.util.Arrays;
import java.util.function.IntPredicate;

/**
 * jzl.com.crackcodeinterview.Q
 * Created by kingj on 2020/7/3 0003.
 * 数组中其他元素出现5次，找出只出现一次的元素
 */
public class Q99 {

    public static int findNumber(int[] nums) {
        int seenOnce = 0;
        int seenTwice = 0;
        int seenThird = 0;
        int seenFourth = 0;
        for (int num : nums) {
            seenOnce = ~seenFourth & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
            seenThird = ~seenTwice & (seenThird ^ num);
            seenFourth = ~seenThird & (seenFourth ^ num);
        }
        return seenOnce;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{2, 2, 2, 2, 2, 1, 4, 4, 4, 4, 4};
        boolean b = Arrays.stream(testArray).anyMatch(value -> value ==7);
        System.out.println(b);
    }

}

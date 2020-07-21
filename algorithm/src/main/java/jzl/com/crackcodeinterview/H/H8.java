package jzl.com.crackcodeinterview.H;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * jzl.com.crackcodeinterview
 * Created by kingj on 2020/6/15 0015.
 * 重复 字符串 的 排列 组合。 编写 一种 方法， 计算 字符串 所有 的 排列 组合， 字符串 中 可能有 字符 相同， 但 结果 不能 有 重复 组合。
 */
public class H8 {

    ArrayList<String> printPerms(String s) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = buildFreqTable(s);
        printPerms(map, "", s.length(), result);
        return result;
    }

    HashMap<Character, Integer> buildFreqTable(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        return map;
    }

    void printPerms(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }
        //用剩余的字符生成其余的排列组合
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count>0){
                map.put(c,count-1);
                printPerms(map,prefix+c,remaining-1,result);
                map.put(c,count);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new H8().printPerms("abcd").toString());
    }
}

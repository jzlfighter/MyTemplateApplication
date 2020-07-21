package jzl.com.crackcodeinterview.H;

import java.util.ArrayList;

/**
 * jzl.com.crackcodeinterview
 * Created by kingj on 2020/6/15 0015.
 * 8. 9 　 括号。 设计 一种 算法， 打印 对 括号 的 所有 合法 的（ 例如， 开闭 一一 对应） 组合。
 */
public class H9 {

    void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) {
            return;
        }
        if (leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParen(list, leftRem - 1, rightRem, str, index + 1);
            str[index] = ')';
            addParen(list, leftRem, rightRem - 1, str, index + 1);
        }
    }

    ArrayList<String> generateParent(int count){
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<>();
        addParen(list,count,count,str,0);
        return list;
    }

}

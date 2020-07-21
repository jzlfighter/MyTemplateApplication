package jzl.com.algorithm.week5;

import java.util.Arrays;

public class LSD {

    public static void sort(String[] a, int w) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[R];
        for (int d = w - 1; d >= 0; d--) {
            int[] count = new int[R + 1];
            //计数
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            //将次数转换为数组下标
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] testArray = new String[]{"qoidajdsfkl", "asdkjfddda", "eifqjda", "fajdurns", "mivaejrd"};
        sort(testArray, 5);
        System.out.println(Arrays.toString(testArray));
    }
    public static class Example{
        String str=new String("tarena");
        int a = 3;
        char[]ch={'a','b','c'};
        public static void main(String args[]){
            Example ex=new Example();
            ex.change(ex.str,ex.ch,ex.a);
            System.out.print(ex.str+" and ");
            System.out.print(ex.ch);
            System.out.print(ex.a);
        }
        public void change(String str,char ch[],int a){
            //引用类型变量，传递的是地址，属于引用传递。
            System.out.print(str+" dddddddddd");
            str = str.toUpperCase();
            ch[0]='g';
            a = 10;
        }
    }
}

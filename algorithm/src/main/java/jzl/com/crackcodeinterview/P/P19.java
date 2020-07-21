package jzl.com.crackcodeinterview.P;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import jzl.com.algorithm.week2.MyQueue;

/**
 * jzl.com.crackcodeinterview.P
 * Created by kingj on 2020/6/28 0028.
 * 16. 19 　 水域 大小。 你有 一个 用于 表示 一片 土地 的 整数 矩阵， 该 矩阵 中 每个 点 的 值 代表 对应 地点 的 海拔 高度。 若 值 为 0 则 表示 水域。 由 垂直、 水平 或 对角 连接 的 水域 为 池塘。 池塘 的 大小 是指 相 连接 的 水域 的 个数。 编写 一个 方法 来 计算 矩阵 中 所有 池塘 的 大小。
 */
public class P19 {

    private boolean[][] marked;

    public List<Integer> waterArea(int[][] land) {
        marked = new boolean[land.length][land[0].length];
        ArrayList<Integer> result = new ArrayList<>();
        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[0].length; c++) {
                if (land[r][c] == 0 && !marked[r][c]) {
                    result.add(bfs(r, c, land));
                }
            }
        }
        return result;
    }

    private int[][] direction = new int[][]{{1, 0}, {1, 1}, {0, 1}, {-1, -1}, {0, -1}, {-1, 0}, {1, -1}, {-1, 1}};

    private int bfs(int r, int c, int[][] land) {
        marked[r][c] = true;
        MyQueue<Point> queue = new MyQueue<>();
        queue.enqueue(new Point(r, c));
        int count = 1;
        while (!queue.isEmpty()) {
            Point point = queue.dequeue();
            for (int i = 0; i < direction.length; i++) {
                int newR = point.x + direction[i][0];
                int newC = point.y + direction[i][1];
                if (newR >= land.length || newR < 0 || newC < 0 || newC >= land[0].length) {
                    continue;
                }
                if (!marked[newR][newC]) {
                    marked[newR][newC] = true;
                    if (land[newR][newC] == 0) {
                        queue.enqueue(new Point(newR, newC));
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] testArray = new int[][]{{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        System.out.println(new P19().waterArea(testArray));
    }

}

package jzl.com.crackcodeinterview.H;

/**
 * jzl.com.crackcodeinterview.eight
 * Created by kingj on 2020/6/15 0015.
 * 8. 10 　 颜色 填充。 编写 函数， 实现 许多 图片 编辑 软件 都 支持 的“ 颜色 填充” 功能。 给定 一个 屏幕（ 以 二维 数组 表示， 元素 为 颜色 值）、 一个 点 和 一个 新的 颜色 值，
 * 将新 颜色 值 填入 这个 点 的 周围 区域， 直到 原来 的 颜色 值 全都 改变。
 */
public class H10 {

    private enum Color {
        Red, Green, Blue
    }

    private int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    void paintFill(Color[][] array, int colume, int row, Color color) {
        Color oldColor = array[row][colume];
        paintFill(array, colume, row, color, oldColor);
    }

    void paintFill(Color[][] array, int colume, int row, Color newColor, Color oldColor) {
        if (colume < 0 || row < 0 || colume >= array[0].length || row >= array.length) {
            return;
        }
        if (array[row][colume] == oldColor) {
            array[row][colume] = newColor;
            for (int i = 0; i < direction.length; i++) {
                paintFill(array, colume + direction[i][1], row + direction[i][0], newColor, oldColor);
            }
        }
    }
}

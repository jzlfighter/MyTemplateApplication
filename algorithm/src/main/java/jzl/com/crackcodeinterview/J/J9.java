package jzl.com.crackcodeinterview.J;

/**
 * jzl.com.crackcodeinterview.J
 * Created by kingj on 2020/6/18 0018.
 * 10. 9 　 排序 矩阵 查找。 给定 矩阵， 每一 行、 每 一列 都 按 升序 排列， 请 编写 代码 找出 某 元素。
 */
public class J9 {

    boolean findElement(int[][] matrix, int elem) {
        return recursion(matrix, 0, 0, elem);
    }

    boolean recursion(int[][] matrix, int row, int colume, int elem) {
        if (row == matrix.length || colume == matrix[0].length) {
            return false;
        }
        if (matrix[row][colume] == elem) {
            return true;
        }
        if (recursion(matrix, row, colume + 1, elem)) {
            return true;
        } else {
            return recursion(matrix, row + 1, colume, elem);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5}, {2, 4, 6}, {3, 5, 7}};
        System.out.println(new J9().findElement(matrix, 6));
    }

}

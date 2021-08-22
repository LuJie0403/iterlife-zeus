package com.iterlife.zeus.leetcode.matrix;

/**
 * @desc:https://leetcode-cn.com/problems/matrix-diagonal-sum/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/5/27 10:54
 **/
public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int mat[][] = {{5}};
        System.out.println(new MatrixDiagonalSumSolution().diagonalSum(mat));
    }
}


class MatrixDiagonalSumSolution {
    public int diagonalSum(int[][] mat) {
        int result = 0;
        int i = 0, j = mat[0].length;
        for (; i < mat[0].length && j > 0; ++i, --j) {
            result += (mat[i][i] + mat[i][j - 1]);
        }
        if (i % 2 == 0) {
            return result;
        }
        return result - mat[i / 2][i / 2];
    }
}
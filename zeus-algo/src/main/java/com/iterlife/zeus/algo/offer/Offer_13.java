package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/13 12:45
 **/
public class Offer_13 {

    public static void main(String args[]) {
        //     System.out.println(new Offer_13_Solution().movingCount(2, 3, 1));
        //     System.out.println(new Offer_13_Solution().movingCount(3, 2, 17));
        System.out.println(new Offer_13_Solution().movingCount(11, 8, 18));
    }
}

class Offer_13_Solution {

    public int movingCount(int m, int n, int k) {
        //默认每一位置都是0
        int[][] matrix = new int[m][n];
        return k == 0 ? 1 : dfs(matrix, 0, 0, k);
    }

    /**
     * 矩阵遍历方法
     *
     * @param matrix 原始字母矩阵
     * @param x      检索起始位置横坐标
     * @param y      检索起始位置纵坐标
     * @param k      行坐标和列坐标的数位之和最大值
     * @return
     */
    private int dfs(int[][] matrix, int x, int y, int k) {
        if (x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1 || outOfBound(x, y, k) || matrix[x][y] == 1) {
            return 0;
        }
        matrix[x][y] = 1;
        //继续递归从各个方向找下一个字符，任意方向找到即可
        return dfs(matrix, x + 1, y, k) +
                dfs(matrix, x - 1, y, k) +
                dfs(matrix, x, y - 1, k) +
                dfs(matrix, x, y + 1, k) + 1;
    }

    /**
     * 检查坐标数位之和是否超过指定的数字 k
     *
     * @param x
     * @param y
     * @param k
     * @return true - 越界 false 没有越界
     */
    public boolean outOfBound(int x, int y, int k) {
        int r = outOfBound(x, k);
        return r < 0 ? true : outOfBound(y, r) < 0;
    }

    /**
     * @param n
     * @param k
     * @return 边界计算后剩余的 k 值
     */
    public int outOfBound(int n, int k) {
        while (n > 0) {
            k -= n % 10;
            if (k < 0) {
                return k;
            }
            n -= n % 10;
            if (n >= 10) {
                n /= 10;
            }
        }
        return k;
    }
}

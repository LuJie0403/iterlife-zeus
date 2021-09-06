package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/4 22:54
 **/
public class Offer_47 {
    public static void main(String args[]) {
        int[][] grid1 = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Offer_47_Solution().maxValue(grid1));
    }
}


class Offer_47_Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] maxValue = new int[m][n];
        maxValue[0][0] = grid[0][0];
        //向下移动
        for (int i = 1; i < m; i++) {
            maxValue[i][0] = maxValue[i - 1][0] + grid[i][0];
        }
        //向右移动
        for (int j = 1; j < n; j++) {
            maxValue[0][j] = maxValue[0][j - 1] + grid[0][j];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format(" %s |", maxValue[i][j]));
            }
            System.out.println("");
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                maxValue[i][j] = Math.max(maxValue[i - 1][j], maxValue[i][j - 1]) + grid[i][j];
            }
        }
        return maxValue[m - 1][n - 1];
    }
}

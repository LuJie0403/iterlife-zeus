package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/30 22:47
 **/
public class Offer_04 {
}

/**
 * 从右上角开始走，利用这个顺序关系可以在O(m+n)的复杂度下解决这个题：
 * 如果当前位置元素比target小，则row++
 * 如果当前位置元素比target大，则col--
 * 如果相等，返回true
 * 如果越界了还没找到，说明不存在，返回false
 */
class Offer_04_Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int counter = 0;
        System.out.println(String.format("row=%s,col=%s", row, col));
        for (int i = 0, j = col - 1; i < row && j >= 0; ) {
            System.out.println(String.format("第 %s 比较，matrix[%s][%s]=%s,target=%s", ++counter, i, j, matrix[i][j], target));
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
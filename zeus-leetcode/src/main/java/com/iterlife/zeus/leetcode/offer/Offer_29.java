package com.iterlife.zeus.leetcode.offer;

import java.util.ArrayList;

/**
 * @desc:https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/18 22:05
 **/
public class Offer_29 {
    public static void main(String args[]) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.print(new Offer_29_Solution().spiralOrder(matrix));
    }
}


class Offer_29_Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        ArrayList<Integer> list = new ArrayList<>(matrix.length);

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (true) {
            //上：从左往右
            for (int i = left; i <= right; ++i) {
                list.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; ++i) {
                list.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        int[] array = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < list.size(); ++i) {
            array[i] = list.get(i);
        }
        return array;
    }
}
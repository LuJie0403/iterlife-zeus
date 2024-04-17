package com.iterlife.zeus.algo.offer;

import java.util.Arrays;

/**
 * @desc:https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/8 00:05
 **/
public class Offer_61 {
    public static void main(String args[]) {
        new Offer_61_Solution().isStraight1(new int[]{1, 4, 3, 1, 5});
    }
}


class Offer_61_Solution {
    /**
     * 排序后前后数字（万能牌0除外）差的和小于5即成顺子，但中间不能有0以外的对子
     */
    public boolean isStraight1(int[] nums) {
        int[] result = Arrays.stream(nums).sorted().toArray();
        int diff = 0;
        for (int k = 0; k < result.length - 1; ++k) {
            if (result[k] == 0) {
                continue;
            }
            if (result[k] == result[k + 1]) {
                return false;
            }
            diff += (result[k + 1] - result[k]);
        }
        return diff < 5;
    }


    /**
     * 排序后前后数字（万能牌0除外）差的和如果与wang(0)的数量相等则构成顺子
     */
    public boolean isStraight2(int[] nums) {
        int[] result = Arrays.stream(nums).sorted().toArray();
        int zeroCounter = 0, diff = 0;
        for (int k = 0; k < result.length - 1; ++k) {
            if (result[k] == 0) {
                zeroCounter++;
                continue;
            }
            if (result[k] == result[k + 1]) {
                return false;
            }
            if (result[k] != result[k + 1] - 1) {
                diff += (result[k + 1] - result[k]);
            }
        }
        return diff <= zeroCounter;
    }
}
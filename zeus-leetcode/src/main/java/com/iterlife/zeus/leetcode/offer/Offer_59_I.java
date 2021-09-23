package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/19 15:46
 **/
public class Offer_59_I {
    public static void main(String args[]) {
        // new Offer_59_I_Solution().maxSlidingWindow(new int[]{1, -1, 2, 5, 3, 6, 7}, 3);
        new Offer_59_I_Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}


class Offer_59_I_Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[]{};
        }

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; ++i) {
            result[i] = Integer.MIN_VALUE;
        }

        int windows = k - 1, counter = 0;
        for (int index = 0; index < nums.length; windows--) {
            if (counter > nums.length - k) {
                break;
            }

            if (nums[index] >= result[counter]) {
                result[counter] = nums[index];
            }
            if (windows > 0) {
                index++;
                continue;
            }
            windows = k;
            index = ++counter;
        }
        return result;
    }
}
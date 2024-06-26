package com.iterlife.zeus.algo.offer;

import java.util.Arrays;

/**
 * @desc:https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/25 23:08
 **/
public class Offer_03 {
    public static void main(String args[]) {
        int nums[] = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(new Offer_03_Solution().findRepeatNumber1(nums));
    }


}


class Offer_03_Solution {
    /**
     * 时间优先算法
     */
    public int findRepeatNumber1(int[] nums) {
        int[] counter = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            counter[nums[i]]++;
            if ((counter[nums[i]]) > 1) {
                return nums[i];
            }
        }
        return -1;
    }


    /**
     * 空间优先算法
     */
    public int findRepeatNumber2(int[] nums) {
        int result = 0;
        nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}

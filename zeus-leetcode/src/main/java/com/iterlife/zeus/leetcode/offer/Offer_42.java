package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/4 22:52
 **/
public class Offer_42 {
}

class Offer_42_Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (sum + nums[i] > nums[i]) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            result = result > sum ? result : sum;
        }
        return result;
    }
}
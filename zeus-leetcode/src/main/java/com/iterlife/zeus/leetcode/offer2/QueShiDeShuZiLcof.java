package com.iterlife.zeus.leetcode.offer2;

/**
 * @desc:https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/29 19:09
 **/
public class QueShiDeShuZiLcof {
}


class QueShiDeShuZiLcofSolution {
    public int missingNumber(int[] nums) {
        int i = 0;
        for (i = 0; i < nums.length; ++i) {
            if (nums[i] != i) {
                return i;
            }
        }
        return i;
    }
}
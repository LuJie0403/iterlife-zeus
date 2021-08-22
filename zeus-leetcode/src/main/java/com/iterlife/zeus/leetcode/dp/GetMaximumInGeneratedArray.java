package com.iterlife.zeus.leetcode.dp;

/**
 * @desc:https://leetcode-cn.com/problems/get-maximum-in-generated-array/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 19:33
 **/
public class GetMaximumInGeneratedArray {
}

class GetMaximumInGeneratedArraySolution {
    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int maxNum = 1;
        for (int i = 2; i < n + 1; ++i) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[i / 2] + nums[(i / 2) + 1];
            }
            maxNum = maxNum < nums[i] ? nums[i] : maxNum;
        }
        return maxNum;
    }
}

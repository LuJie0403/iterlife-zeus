package com.iterlife.zeus.leetcode;

/**
 * @desc:https://leetcode-cn.com/problems/contiguous-sequence-lcci/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 23:53
 **/
public class ContiguousSequenceLcci {

}


class ContiguousSequenceLcciSolution {
    public int maxSubArray(int[] nums) {

        int sum = nums[0], result = nums[0];
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

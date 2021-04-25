package com.iterlife.zeus.leetcode;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/25 14:26
 **/
public class MaximumSubArray {
    public static void main(String[] args) {
        int nums[] = {2, 4, -1, 4};
        System.out.print(new MaximumSubArraySolution().maxSubArray(nums));
    }
}

class MaximumSubArraySolution {
    public int maxSubArray(int[] nums) {
        int result = nums[0], sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (sum + nums[i] > nums[i]) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }
            result = result > sum ? result : sum;
        }
        return result;
    }
}

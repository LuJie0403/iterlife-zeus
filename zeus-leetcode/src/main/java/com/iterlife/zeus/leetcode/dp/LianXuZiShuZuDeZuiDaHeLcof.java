package com.iterlife.zeus.leetcode.dp;

/**
 * @desc:https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 22:49
 **/
public class LianXuZiShuZuDeZuiDaHeLcof {
    public static void main(String args[]) {
        // int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-2};
        System.out.println(new LianXuZiShuZuDeZuiDaHeLcofSolution().maxSubArray(nums));
    }
}


class LianXuZiShuZuDeZuiDaHeLcofSolution {
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

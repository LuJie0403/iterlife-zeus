package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/NUPfPr/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/22 15:49
 **/
public class NUPfPr {
}

class NUPfPrSolution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        if (nums.length <= 1) {
            return false;
        }
        for (int num : nums) {
            sum += num;
        }
        //如果数组之和是奇数，则不可能拆分为两个整数子序列的和
        if ((sum & 0b0001) == 1) {
            return false;
        }
        //拆分成和相等的两组，则两子序列和的目标值为数组和的一般
        int target = sum >> 1;
        boolean[][] dp = new boolean[nums.length][target + 1];// dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和等于 j。
        //初始化,处理状态矩阵第一行
        for (int i = 1; i < target + 1; ++i) {
            if (nums[0] == i) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int tTarget = 0; tTarget < target + 1; tTarget++) {
                dp[i][tTarget] = dp[i - 1][tTarget];
                if (tTarget >= nums[i]) {
                    dp[i][tTarget] = dp[i - 1][tTarget] || dp[i - 1][tTarget - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}

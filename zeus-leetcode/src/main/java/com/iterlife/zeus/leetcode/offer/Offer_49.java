package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/chou-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 22:01
 **/
public class Offer_49 {
}

/**
 * 动态规划问题
 */
class Offer_49_Solution {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; ++i) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
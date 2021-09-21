package com.iterlife.zeus.leetcode.offer;

import java.util.Arrays;

/**
 * @desc:https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 22:13
 **/
public class Offer_60 {
}

class Offer_60_Solution {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0d);
        for (int i = 2; i <= n; ++i) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }
}
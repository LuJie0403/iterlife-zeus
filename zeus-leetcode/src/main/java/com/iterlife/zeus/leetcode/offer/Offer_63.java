package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/30 23:49
 **/
public class Offer_63 {
}


class Offer_63_Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] profits = new int[prices.length];
        for (int i = prices.length - 1; i > 0; i--) {
            profits[i] = prices[i] - prices[i - 1];
        }
        profits[0] = prices[0];

        int maxProfit = 0, maxPriceFluctuations = 0;
        for (int i = 1; i < profits.length; ++i) {
            if (maxPriceFluctuations + profits[i] > profits[i]) {
                maxPriceFluctuations = maxPriceFluctuations + profits[i];
            } else {
                maxPriceFluctuations = profits[i];
            }
            maxProfit = maxProfit > maxPriceFluctuations ? maxProfit : maxPriceFluctuations;
        }
        return maxProfit;
    }
}
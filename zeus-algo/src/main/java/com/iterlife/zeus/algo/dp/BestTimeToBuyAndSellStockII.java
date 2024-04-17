package com.iterlife.zeus.algo.dp;

/**
 * @desc:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 16:04
 **/
public class BestTimeToBuyAndSellStockII {
    public static void main(String args[]) {
        int[] stockPrices1 = {7, 1, 5, 3, 6, 4};
        int[] stockPrices2 = {1, 2, 3, 4, 5};
        int[] stockPrices3 = {7, 6, 4, 3, 1};
        System.out.println(new BestTimeToBuyAndSellStockIISolution().maxProfit(stockPrices1));
        System.out.println(new BestTimeToBuyAndSellStockIISolution().maxProfit(stockPrices2));
        System.out.println(new BestTimeToBuyAndSellStockIISolution().maxProfit(stockPrices3));

    }
}

class BestTimeToBuyAndSellStockIISolution {

    public int maxProfit(int[] prices) {
        int priceFluctuations, totalProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            priceFluctuations = prices[i] - prices[i - 1];
            totalProfit += priceFluctuations > 0 ? priceFluctuations : 0;
        }
        return totalProfit;
    }
}

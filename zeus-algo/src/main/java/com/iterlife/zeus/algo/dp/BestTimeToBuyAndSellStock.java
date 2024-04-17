package com.iterlife.zeus.algo.dp;

/**
 * @desc:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 16:04
 **/
public class BestTimeToBuyAndSellStock {
    public static void main(String args[]) {
        int[] stockPrices1 = {7, 1, 5, 3, 6, 4};
        int[] stockPrices2 = {7, 6, 4, 3, 1};
        System.out.println(new BestTimeToBuyAndSellStockSolution().maxProfit(stockPrices1));
        System.out.println(new BestTimeToBuyAndSellStockSolution().maxProfit(stockPrices2));

    }
}

class BestTimeToBuyAndSellStockSolution {

    /**
     * 求股票利润最大，就是求买入股票以后价格增长最大
     */
    public int maxProfit(int[] prices) {
        int[] priceFluctuations = calPriceFluctuation(prices);
        return calMaxStockProfit(priceFluctuations);
    }

    private int[] calPriceFluctuation(int[] prices) {
        int[] priceFluctuations = new int[prices.length];
        for (int i = 0; i < prices.length; ++i) {
            if (i == 0) {
                priceFluctuations[i] = prices[i];
            } else {
                priceFluctuations[i] = prices[i] - prices[i - 1];
            }
        }
        return priceFluctuations;
    }

    public int calMaxStockProfit(int[] priceFluctuations) {
        int maxProfit = 0, maxPriceFluctuations = 0;
        for (int i = 1; i < priceFluctuations.length; ++i) {
            if (maxPriceFluctuations + priceFluctuations[i] > priceFluctuations[i]) {
                maxPriceFluctuations = maxPriceFluctuations + priceFluctuations[i];
            } else {
                maxPriceFluctuations = priceFluctuations[i];
            }
            maxProfit = maxProfit > maxPriceFluctuations ? maxProfit : maxPriceFluctuations;
        }
        return maxProfit;
    }
}

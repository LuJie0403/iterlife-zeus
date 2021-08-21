package com.iterlife.zeus.leetcode;

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
        int[] priceFluctuations = calPriceFluctuation(prices);
        return calMaxStockProfit(1, priceFluctuations);
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

    public int calMaxStockProfit(int index, int[] priceFluctuations) {
        int totalProfit = 0;
        for (int i = index; i < priceFluctuations.length; ++i) {
            totalProfit += priceFluctuations[i] > 0 ? priceFluctuations[i] : 0;
        }
        return totalProfit;
    }
}

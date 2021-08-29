package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/GzCJIP/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 22:12
 **/
public class Offer_II_088 {
    public static void main(String args[]) {
        int[] cost1 = new int[]{10, 15, 20};
        System.out.println(new Offer_II_088_Solution().minCostClimbingStairs(cost1));
    }
}

class Offer_II_088_Solution {
    public int minCostClimbingStairs(int[] cost) {
        int pre1StairCost = 0, pre2StairCost = 0, minCost = 0;
        if (cost.length < 2) {
            return 0;
        }
        for (int i = 2; i <= cost.length; ++i) {
            minCost = Math.min(pre1StairCost + cost[i - 1], pre2StairCost + cost[i - 2]);
            pre2StairCost = pre1StairCost;
            pre1StairCost = minCost;
        }
        return minCost;
    }
}

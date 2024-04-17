package com.iterlife.zeus.algo.dp;

/**
 * @desc:https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 18:37
 **/
public class MinCostClimbingStairs {
    public static void main(String args[]) {
        int[] cost1 = {10, 15, 20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost3 = {1, 100};
        System.out.println(new MinCostClimbingStairsSolution().minCostClimbingStairs(cost1));
        System.out.println(new MinCostClimbingStairsSolution().minCostClimbingStairs(cost2));
        System.out.println(new MinCostClimbingStairsSolution().minCostClimbingStairs(cost3));
    }
}

class MinCostClimbingStairsSolution {
    public int minCostClimbingStairs(int[] cost) {
        int pre2StairCost = 0, pre1StairCost = 0, minCost = 0;
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

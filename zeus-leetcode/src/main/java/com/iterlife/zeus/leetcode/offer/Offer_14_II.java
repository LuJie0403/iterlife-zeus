package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 17:44
 **/
public class Offer_14_II {
}


class Offer_14_II_Solution {
    public int cuttingRope(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int ans = 1;
        while (n > 4) {
            ans *= 3;
            ans %= 1000000007;
            n -= 3;
        }
        return (int) (ans * n % 1000000007);
    }
}

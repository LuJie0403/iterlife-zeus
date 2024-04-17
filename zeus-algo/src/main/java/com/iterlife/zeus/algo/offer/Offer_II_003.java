package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/w3tCBm/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 21:42
 **/
public class Offer_II_003 {
    public static void main(String args[]) {
        new Offer_II_003_Solution().countBits(0);
        // new Offer_II_003_Solution().countBits(10);
    }
}


class Offer_II_003_Solution {
    public int[] countBits(int n) {
        int counter[] = new int[n + 1];
        counter[0] = 0;
        if (n >= 1) {
            counter[1] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            counter[i] = (i & 0b0001) == 0 ? counter[i >> 1] : counter[i >> 1] + 1;
            System.out.print(String.format("counter[%s]=%s\n", i, counter[i]));
        }
        return counter;
    }
}
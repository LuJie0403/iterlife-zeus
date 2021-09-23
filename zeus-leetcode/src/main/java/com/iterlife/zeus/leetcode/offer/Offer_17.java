package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 16:24
 **/
public class Offer_17 {
}


class Offer_17_Solution {
    public int[] printNumbers(int n) {
        int maxInt = (int) Math.pow(10, n);
        int[] ans = new int[maxInt - 2];
        for (int index = 0; index < ans.length; ++index) {
            ans[index] = index + 1;
        }
        return ans;
    }
}
package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/19 15:17
 **/
public class Offer_20 {
}


class Offer_20_Solution {
    public boolean isNumber(String s) {
        try {
            Double.valueOf(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
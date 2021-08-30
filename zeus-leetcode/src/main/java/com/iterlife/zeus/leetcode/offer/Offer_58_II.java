package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/30 22:42
 **/
public class Offer_58_II {
}


class Offer_58_II_Solution {
    public String reverseLeftWords(String s, int n) {
        return new StringBuilder(s.substring(n, s.length())).append(s.substring(0, n)).toString();
    }
}

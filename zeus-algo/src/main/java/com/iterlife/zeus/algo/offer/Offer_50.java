package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/30 23:38
 **/
public class Offer_50 {
}


class Offer_50_Solution {
    public char firstUniqChar(String s) {
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (counter[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
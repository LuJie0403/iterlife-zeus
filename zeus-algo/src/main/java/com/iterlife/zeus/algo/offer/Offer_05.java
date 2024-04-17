package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/30 22:31
 **/
public class Offer_05 {
}


class Offer_05_Solution {
    public String replaceSpace(String s) {
        // return s.replace(" ", "%20");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
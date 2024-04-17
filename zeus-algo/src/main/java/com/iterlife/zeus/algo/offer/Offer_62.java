package com.iterlife.zeus.algo.offer;

import java.util.ArrayList;

/**
 * @desc:https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/18 20:49
 **/
public class Offer_62 {
    public static void main(String args[]) {
        System.out.println(new Offer_62_Solution().lastRemaining(5, 3));
        System.out.println(new Offer_62_Solution().lastRemaining(10, 17));
    }
}


class Offer_62_Solution {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> array = new ArrayList<Integer>(n);
        for (int i = 0; i < n; ++i) {
            array.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            array.remove(index);
            n--;
        }
        return array.get(0);
    }
}
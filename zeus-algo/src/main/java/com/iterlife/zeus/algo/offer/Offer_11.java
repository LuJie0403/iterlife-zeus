package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/30 23:27
 **/
public class Offer_11 {
}


class Offer_11_Solution {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        for (int i = 0; i < numbers.length - 1; ++i) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }
}
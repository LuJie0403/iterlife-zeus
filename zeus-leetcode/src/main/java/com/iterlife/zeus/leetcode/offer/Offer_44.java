package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 18:21
 **/
public class Offer_44 {

    public static void main(String args[]) {
        System.out.println(new Offer_44_Solution().findNthDigit(1000000000));
    }
}

class Offer_44_Solution {
    public int findNthDigit(int n) {
        //位数
        int digit = 1;
        //在 digit 位数时数字的起始值
        long start = 1;
        //在 digit 位数时数位（非数字，一个数字可以包括n个数位）的个数
        long count = 9;
        //超过一位数字的情况
        while (n > count) {
            //从低位逐步往高位累加计算
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}

package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 13:32
 **/
public class Offer_15 {
    public static void main(String args[]) {
        System.out.println(new Offer_15_Solution().hammingWeight1(3));
        System.out.println(new Offer_15_Solution().hammingWeight1(-3));
        System.out.println(new Offer_15_Solution().hammingWeight2(3));
        System.out.println(new Offer_15_Solution().hammingWeight2(-3));
        System.out.println(new Offer_15_Solution().hammingWeight3(3));
        System.out.println(new Offer_15_Solution().hammingWeight3(-3));
    }
}


class Offer_15_Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        String val = Integer.toBinaryString(n);
        int counter = 0;
        for (int i = 0; i < val.length(); ++i) {
            if (val.charAt(i) == '1') {
                counter++;
            }
        }
        return counter;
    }

    public int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }

    /**
     * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     */
    public int hammingWeight3(int n) {
        int counter = 0;
        while (n != 0) {
            n = n & (n - 1);
            counter++;
        }
        return counter;
    }
}
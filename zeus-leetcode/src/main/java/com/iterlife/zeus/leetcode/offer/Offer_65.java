package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/11 23:28
 **/
public class Offer_65 {

    public static void main(String args[]) {
        //  System.out.println(new Offer_65_Solution().add(2, 3));
        System.out.println(new Offer_65_Solution().add(111, 899));
    }
}

class Offer_65_Solution {
    /**
     * 输入参数: a<b
     *
     * @param a=2 = 0010
     * @param b=3 = 0011
     * @return a+b=5 0101
     * a^b = 0001 无进位计算当前值 a+b
     * a&b = 0010 当前位是否有进位（0-无，1-有）
     * (a&b)<<1 = 0100 每位的进位
     */
    public int add(int a, int b) {
        // return (a ^ b) ^ （(a & b) << 1）;
        int value = a ^ b;
        int flag = (a & b) << 1;
        int ans = b == 0 ? a : add(value, flag);
        System.out.println(String.format("a=%d[%s]\nb=%d[%s]\nvalue=%d [%s],flag=%d [%s],ans=%d [%s]",
                a, Integer.toBinaryString(a),
                b, Integer.toBinaryString(b),
                value, Integer.toBinaryString(value),
                flag, Integer.toBinaryString(flag),
                ans, Integer.toBinaryString(ans)));

        return ans;
    }
}
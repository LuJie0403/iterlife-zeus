package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/19 15:17
 **/
public class Offer_20 {
    public static void main(String args[]) {

        // String[] numbers = new String[]{"-1E-16", "0123", "+100", "5e2", "-123", "3.1416"};
        String[] numbers = new String[]{"1 ", "12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"};

        for (int i = 0; i < numbers.length; ++i) {
            System.out.println(String.format("[%s]\t%s", numbers[i], new Offer_20_Solution().isNumber(numbers[i])));
        }
    }
}


class Offer_20_Solution {

    public boolean isNumber(String s) {
        boolean hasNum = false, hasE = false;
        boolean hasSign = false, hasDot = false;
        int index = 0;
        //为了减少遍历次数，本操作忽略，在识别过程中同时处理
        //s = s.trim().toUpperCase();
        for (; index < s.length(); ++index) {
            char tChar = s.charAt(index);
            if (tChar == ' ') {
                if (hasNum || hasE || hasSign || hasDot) {
                    break;
                }
                continue;
            }
            if (tChar >= '0' && tChar <= '9') {
                hasNum = true;
                continue;
            }
            if (tChar == 'e' || tChar == 'E') {
                //非第一个E，或者E前面没有数字时：非法
                if (hasE || !hasNum) {
                    return false;
                }
                hasE = true;
                //E 之前的部分满足条件时，则从此开始校验后半部分
                hasNum = false;
                hasSign = false;
                hasDot = false;
                continue;
            }
            //符号位只能出现在第一个位置
            if (tChar == '+' || tChar == '-') {
                if (hasSign || hasNum || hasDot) {
                    return false;
                }
                hasSign = true;
                continue;
            }
            if (tChar == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
                continue;
            }
            return false;
        }
        //处理后置的空格
        for (; index < s.length() && s.charAt(index) == ' '; ++index) ;
        return hasNum && index == s.length();
    }
}
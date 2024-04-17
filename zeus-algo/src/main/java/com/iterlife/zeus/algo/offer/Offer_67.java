package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 13:03
 **/
public class Offer_67 {
    public static void main(String args[]) {

        System.out.println(new Offer_67_Solution().strToInt("   -42"));
        System.out.println(new Offer_67_Solution().strToInt("42"));
        System.out.println(new Offer_67_Solution().strToInt("4193 with words"));
        System.out.println(new Offer_67_Solution().strToInt("words and 987"));
        System.out.println(new Offer_67_Solution().strToInt("+"));
        System.out.println(new Offer_67_Solution().strToInt("-   234"));
        System.out.println(new Offer_67_Solution().strToInt("2147483648"));
        System.out.println(new Offer_67_Solution().strToInt("   +0 123"));
    }
}

class Offer_67_Solution {
    public int strToInt(String str) {
        String symbolChar = "";
        int result = 0;
        StringBuilder tStr = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            char tChar = str.charAt(i);
            if (tChar == '+' || tChar == '-' || tChar == ' ') {
                if (tStr.length() > 0 || symbolChar != "") {
                    break;
                }
                if (tChar != ' ') {
                    symbolChar = String.valueOf(tChar);
                }
                continue;
            }
            if ((tChar >= '0' && tChar <= '9')) {
                tStr.append(tChar);
                continue;
            }
            break;
        }
        try {
            if (tStr.length() > 0) {
                result = Integer.valueOf(new StringBuilder(symbolChar).append(tStr).toString());
            }
        } catch (NumberFormatException e) {
            if (symbolChar.equals("-")) {
                result = Integer.MIN_VALUE;
            } else {
                result = Integer.MAX_VALUE;
            }
        }
        return result;
    }
}

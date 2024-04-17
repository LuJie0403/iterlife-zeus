package com.iterlife.zeus.algo.string;

/**
 * @desc:https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/5/27 20:09
 **/
public class StringToIntegerAtoi {

    public static void main(String[] args) {
        // System.out.println(new StringToIntegerAtoiSolution1().myAtoi("00000-42a1234"));
        // System.out.println(new StringToIntegerAtoiSolution1().myAtoi("0000000000012345678"));
        //System.out.println(new StringToIntegerAtoiSolution1().myAtoi("2147483648"));
        System.out.println(new StringToIntegerAtoiSolution1().myAtoi("  +  413"));

    }
}


class StringToIntegerAtoiSolution1 {
    public int myAtoi(String s) {

        String strValue = "";
        int intValue = 0, signBit = 0, preFixZero = 0; //signBit为0和1表示正数，-1表示负数;signBit 不为0时，符号与之前相同则保持原符号，不同则保持为正负号
        String maxPositive = "2147483647"; // Integer.MAX_VALUE：2^31-1 = 2147483647
        String minPositive = "2147483648"; // Integer.MIN_VALUE：-2^31 = -2147483648;


        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == ' ') {
                if (!"".equals(strValue) || signBit != 0) {
                    break;
                }
                continue;
            }
            if ((s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
                strValue = strValue + ("".equals(strValue) && s.charAt(index) == 0 ? "" : s.charAt(index));
                continue;
            }

            if ((s.charAt(index) == '-' || s.charAt(index) == '+')) {
                if (signBit != 0 || !"".equals(strValue)) {
                    break;
                }
                signBit = 44 - s.charAt(index);//"+" ASCII 编号为43，"-" ASCII 编号为45
                continue;
            }
            break;
        }
        //去掉先导0：找到第一个不等于0的字符所在的位置
        while (preFixZero < strValue.length()) {
            if (strValue.charAt(preFixZero) != '0') {
                break;
            }
            preFixZero++;
        }
        strValue = strValue.substring(preFixZero);
        strValue = ("".equals(strValue) ? "0" : strValue);

        //解决数字大小越界问题的问题,2^32 值的位数是10位
        if (strValue.length() > maxPositive.length()) {
            strValue = (signBit < 0) ? minPositive : maxPositive;
        }
        if ((strValue.length() == maxPositive.length())) {
            //负数的场景
            strValue = (signBit < 0 && strValue.compareTo(minPositive) > 0) ? minPositive : strValue;
            //正数的场景
            strValue = (signBit >= 0 && strValue.compareTo(maxPositive) > 0) ? maxPositive : strValue;
        }
        intValue = Integer.valueOf(signBit < 0 ? "-".concat(strValue) : strValue);
        return intValue;
    }
}
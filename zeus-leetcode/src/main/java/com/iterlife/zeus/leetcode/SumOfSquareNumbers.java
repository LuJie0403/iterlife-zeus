package com.iterlife.zeus.leetcode;

/**
 * @desc:https://leetcode-cn.com/problems/sum-of-square-numbers/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/28 09:12
 **/
public class SumOfSquareNumbers {


}


class SumOfSquareNumbersSolution {
    public boolean judgeSquareSum(int c) {
        int maxB = (int) Math.sqrt(c);
        for (int a = 0; a <= maxB; ++a) {
            int t = c - a * a;
            int b = (int) Math.sqrt(t);
            if (a * a + b * b == c) {
                return true;
            }
        }
        return false;
    }
}

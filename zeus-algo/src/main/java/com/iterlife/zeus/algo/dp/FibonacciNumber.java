package com.iterlife.zeus.algo.dp;

/**
 * @desc:https://leetcode-cn.com/problems/fibonacci-number/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 18:51
 **/
public class FibonacciNumber {
    public static void main(String args[]) {

    }
}


class FibonacciNumberSolution {
    public int fib1(int n) {
        if (n < 2) {
            return n;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public int fib2(int n) {
        int res = 0;
        int pre2Res = 0, pre1Res = 1;
        if (n < 2) {
            return n;
        }
        for (int i = 2; i <= n; ++i) {
            res = pre1Res + pre2Res;
            pre2Res = pre1Res;
            pre1Res = res;
        }
        return res;
    }
}
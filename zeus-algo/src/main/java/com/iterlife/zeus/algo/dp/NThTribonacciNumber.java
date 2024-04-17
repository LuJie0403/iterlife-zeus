package com.iterlife.zeus.algo.dp;

/**
 * @desc:https://leetcode-cn.com/problems/n-th-tribonacci-number/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 19:24
 **/
public class NThTribonacciNumber {


}

class NThTribonacciNumberSolution {
    public int tribonacci(int n) {
        int pre3Res = 0, pre2Res = 1, pre1Res = 1;
        int res = 0;
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        for (int i = 3; i <= n; ++i) {
            res = pre1Res + pre2Res + pre3Res;
            pre3Res = pre2Res;
            pre2Res = pre1Res;
            pre1Res = res;
        }
        return res;
    }
}

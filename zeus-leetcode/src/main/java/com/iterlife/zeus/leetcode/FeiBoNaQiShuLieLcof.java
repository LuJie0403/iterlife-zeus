package com.iterlife.zeus.leetcode;

/**
 * @desc:https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/22 01:28
 **/
public class FeiBoNaQiShuLieLcof {
}

class FeiBoNaQiShuLieLcofSolution {
    public int fib(int n) {
        int pre2Num = 0, pre1Num = 1;
        int result = 0;
        if (n == 0) {
            return pre2Num;
        }
        if (n == 1) {
            return pre1Num;
        }
        for (int i = 2; i <= n; ++i) {
            result = (pre1Num + pre2Num) % 1000000007;
            pre2Num = pre1Num;
            pre1Num = result;
        }
        return result;
    }
}

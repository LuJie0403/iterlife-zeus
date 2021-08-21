package com.iterlife.zeus.leetcode;

/**
 * @desc:https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/22 01:40
 **/
public class QingWaTiaoTaiJieWenTiLcof {
    public static void main(String args[]) {
        new QingWaTiaoTaiJieWenTiLcofSolution().numWays(7);
    }
}

class QingWaTiaoTaiJieWenTiLcofSolution {
    public int numWays(int n) {
        int pre1Step = 1;
        int pre2Step = 2;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return pre1Step;
        }
        if (n == 2) {
            return pre2Step;
        }
        int resultStep = 0;
        for (int i = 3; i <= n; ++i) {
            resultStep = (pre1Step + pre2Step) % 1000000007;
            pre1Step = pre2Step;
            pre2Step = resultStep;
        }
        return resultStep;
    }
}

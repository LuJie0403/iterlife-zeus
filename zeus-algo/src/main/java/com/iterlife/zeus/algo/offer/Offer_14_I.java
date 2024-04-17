package com.iterlife.zeus.algo.offer;

/**
 * @desc: https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/14 22:14
 **/
public class Offer_14_I {
}

class Offer_14_I_Solution {
    /**
     * 任何大于3的正整数 n 均可分解成 n=2*x+3*y (n和m最小值各为1)
     * 且为使得 V=x*y 最大，则应该使得 x 和 y 各自尽可能大
     * 求得：f(x,y)=x*y 最大值 maxF(n)
     * ==> y=(n-2*x)/3
     * ==> f(x)=(-2/3) * x^2 +(n/3)*x (抛物线函数，开口向下)
     * ==> f(x) 在 x= n/4 时取得最大值 maxF(x)
     */
    public int cuttingRope1(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int ans = 1;
        while (n > 4) {
            ans *= 3;
            n -= 3;
        }
        return ans * n;
    }

    /**
     * 动态规划方法
     * 参考：https://leetcode-cn.com/problems/integer-break/solution/zheng-shu-chai-fen-by-leetcode-solution/
     */
    public int cuttingRope2(int n) {
        //    dp[i]表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积
        int[] dp = new int[n + 1];
        if (n >= 0) {
            dp[0] = 0;
        }
        if (n >= 1) {
            dp[1] = 0;
        }
        if (n >= 2) {
            dp[2] = 1;
        }
        if (n >= 3) {
            dp[3] = 2;
        }
        if (n >= 4) {
            dp[4] = 4;
        }
        int tMaxValue = 0;
        for (int i = 5; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                tMaxValue = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], tMaxValue);
            }
        }
        return dp[n];
    }


}

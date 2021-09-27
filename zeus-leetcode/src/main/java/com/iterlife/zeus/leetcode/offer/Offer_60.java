package com.iterlife.zeus.leetcode.offer;

import java.util.Arrays;

/**
 * @desc:https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 22:13
 **/
public class Offer_60 {
    public static void main(String args[]) {
        double[] result1 = new Offer_60_Solution().dicesProbability1(2);
        double[] result2 = new Offer_60_Solution().dicesProbability2(2);
        for (int i = 0; i < result1.length; ++i) {
            System.out.print(String.format("%.4f ", result1[i]));
        }
        System.out.println("");
        for (int i = 0; i < result2.length; ++i) {
            System.out.print(String.format("%.4f ", result2[i]));
        }
    }
}

class Offer_60_Solution {
    /**
     * 动态规划
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/jian-zhi-offer-60-n-ge-tou-zi-de-dian-sh-z36d/
     */
    public double[] dicesProbability1(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0d);
        for (int i = 2; i <= n; ++i) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }

    /**
     * 概率计算（空间换时间）
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * P(m个骰子的和为n) = P（m-1个骰子和为n-1）* P(1个骰子的数字为1)
     * + P（m-1个骰子和为n-2）* P(1个骰子的数字为2)
     * + P（m-1个骰子和为n-3）* P(1个骰子的数字为3)
     * + P（m-1个骰子和为n-4）* P(1个骰子的数字为4)
     * + P（m-1个骰子和为n-5）* P(1个骰子的数字为5)
     * + P（m-1个骰子和为n-6）* P(1个骰子的数字为6)
     * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/gai-lu-lun-cheng-fa-gong-shi-dong-tai-gu-77ts/
     */
    public double[] dicesProbability2(int n) {
        double ans[] = new double[5 * n + 1];
        // dp[i][j]表示 i 个骰子和为 j的概率
        // 因 dp[0][j]和 dp[i][0]是不使用的，所以数组的大小为 (n+1)*(6*n+1)
        double[][] dp = new double[n + 1][6 * n + 1];
        //初始化只有一个骰子的情况
        //Arrays.fill(dp[1], 1.0 / 6.0d);
        for (int k = 1; k <= 6; ++k) {
            dp[1][k] = 1.0 / 6.0d;
        }
        //其他场景的数据初始化（因不会读取到该列元素，此步骤可以忽略）
        //Arrays.fill(dp[0], 0.0d);
        //计算有n个骰子的情况
        for (int i = 2; i <= n; ++i) {
            //i 个骰子和的取值范围是[i，6*i]
            for (int j = i; j <= 6 * i; ++j) {
                for (int k = 1; k <= 6; ++k) {
                    if (j > k) {
                        dp[i][j] += dp[i - 1][j - k] * dp[1][k];
                    }
                }
            }
        }
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                System.out.print(String.format("dp[%d][%d]=%.4f ", i, j, dp[i][j]));
            }
            System.out.println("");
        }
        //因为n个骰子最小和为n，所以 dp[n][0]~dp[n][n-1]的值是无效的
        for (int i = n; i <= 6 * n; ++i) {
            ans[i - n] = dp[n][i];
        }
        return ans;
    }
}
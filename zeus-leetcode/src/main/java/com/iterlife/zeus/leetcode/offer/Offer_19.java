package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 22:25
 **/
public class Offer_19 {
}

/**
 * 动态规划问题
 */
class Offer_19_Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        // f[i][j]f[i][j] 表示 ss 的前 ii 个字符与 pp 中的前 jj 个字符是否能够匹配
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sLen; ++i) {
            for (int j = 1; j <= pLen; ++j) {
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }

                }
            }
        }
        return dp[sLen][pLen];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
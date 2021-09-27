package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 22:25
 **/
public class Offer_19 {
    public static void main(String[] args) {
        //  System.out.println(new Offer_19_Solution().matchText("aabbcd", "ab*.d", 0, 0));
        System.out.println(new Offer_19_Solution().matchText("aa", "a", 0, 0));
    }
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
                if (p.charAt(j - 1) == '*') {
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

    /**
     * 逐位检查字符串 s.charAt[i] 与 p.charAt[j] 是否匹配
     */
    public boolean matchText(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        }
        //需要比较的两个字符，匹配串的后一位是*号的情况
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // *  号表示的字符出现0次的情况
            boolean asterisk0Times = matchText(s, p, i, j + 2);
            // *  号表示的字符出现1次及以上的情况(当前字符匹配，且依次递归后续字符是否匹配)
            boolean asteriskMoreThan1Times = i < s.length() && matchChar(s.charAt(i), p.charAt(j)) && matchText(s, p, i + 1, j);
            return asterisk0Times || asteriskMoreThan1Times;
        }
        //当前需要验证的两个字符直接匹配
        return i != s.length() && j != p.length() && matchChar(s.charAt(i), p.charAt(j)) && matchText(s, p, i + 1, j + 1);
    }

    /**
     * 检查字符 s、p 是否匹配
     */
    private boolean matchChar(char s, char p) {
        return s == p || p == '.';
    }

}
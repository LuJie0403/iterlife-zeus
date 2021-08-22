package com.iterlife.zeus.leetcode.string;

/**
 * @desc:https://leetcode-cn.com/problems/is-subsequence/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/21 18:01
 **/
public class IsSubsequence {
    public static void main(String args[]) {
        System.out.println(new IsSubsequenceSolution().isSubsequence("abc", "acbcd"));
        System.out.println(new IsSubsequenceSolution().isSubsequence("abc", "abc"));
        System.out.println(new IsSubsequenceSolution().isSubsequence("abc", "abd"));
        System.out.println(new IsSubsequenceSolution().isSubsequence("abc", "ab"));
    }
}

class IsSubsequenceSolution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        for (; i < s.length() && j < t.length(); ++j) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == s.length();
    }
}

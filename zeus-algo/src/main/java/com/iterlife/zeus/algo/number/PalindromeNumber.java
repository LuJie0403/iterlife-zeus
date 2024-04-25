package com.iterlife.zeus.algo.number;

/**
 * @desc:https://leetcode.cn/problems/palindrome-number/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2024/4/24 20:05
 **/
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new PalindromeNumberSolution().isPalindrome(10));

    }
}

class PalindromeNumberSolution {

    public boolean isPalindrome(int x) {

        int result = 0;
        int help = 10;
        if (x < 0 || (x % help == 0 && x != 0)) {
            return false;
        }
        while (x > result) {
            result = result * help + x % help;
            if (x == result) {
                return true;
            }
            x /= help;
        }
        return x == result;
    }
}

package com.iterlife.zeus.leetcode.string;

/**
 * @desc:https://leetcode-cn.com/problems/length-of-last-word/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/29 21:30
 **/
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWordSolution().lengthOfLastWord("b aw  "));
    }
}

class LengthOfLastWordSolution {
    public int lengthOfLastWord(String s) {
        int length = 0, preLength = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == ' ') {
                preLength = length > 0 ? length : preLength;
                length = 0;
            } else {
                length++;
            }
        }
        return length > 0 ? length : preLength;
    }
}

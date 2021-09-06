package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/4 19:30
 **/
public class Offer_58_I {

    public static void main(String args[]) {
        System.out.println(new Offer_58_I_Solution().reverseWords("  Hello  Word   Xu Na   "));
        System.out.println(new Offer_58_I_Solution().reverseWords("  Hello "));
        System.out.println(new Offer_58_I_Solution().reverseWords("Hello"));
        System.out.println(new Offer_58_I_Solution().reverseWords("  "));
        System.out.println(new Offer_58_I_Solution().reverseWords(""));
    }
}

class Offer_58_I_Solution {
    public class WordNode {
        String word;
        WordNode pre;

        private WordNode(String value, WordNode pre) {
            this.word = value;
            this.pre = pre;

        }
    }

    public String reverseWords(String s) {
        WordNode tWord = null;
        String[] wordArray = s.split(" ");

        for (int i = 0; i < wordArray.length; ++i) {
            if (wordArray[i] == null || wordArray[i].length() == 0) {
                continue;
            }
            tWord = new WordNode(wordArray[i], tWord);
        }
        StringBuilder result = new StringBuilder();
        if (tWord == null) {
            return result.toString();
        }

        result.append(tWord.word);
        while (tWord.pre != null) {
            result.append(" ").append(tWord.pre.word);
            tWord = tWord.pre;
        }
        return result.toString();
    }


}
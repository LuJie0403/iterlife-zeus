package com.iterlife.zeus.leetcode;

import java.util.Arrays;

/**
 * @desc:https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/13 14:29
 **/
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharactersSolution().lengthOfLongestSubstring("a"));
        System.out.println(new LongestSubstringWithoutRepeatingCharactersSolution().lengthOfLongestSubstring("aba"));
        System.out.println(new LongestSubstringWithoutRepeatingCharactersSolution().lengthOfLongestSubstring("ababc"));
        System.out.println(new LongestSubstringWithoutRepeatingCharactersSolution().lengthOfLongestSubstring("abacdab"));
    }

}

class LongestSubstringWithoutRepeatingCharactersSolution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastPosition = new int[256];
        Arrays.fill(lastPosition, -1);
        int maxLength = 0;

        int startIndex = 0;
        for (int i = 0; i < s.length(); ++i) {
            startIndex = Math.max(startIndex, lastPosition[s.charAt(i)] + 1);
            maxLength = Math.max(maxLength, i - startIndex + 1);
            lastPosition[s.charAt(i)] = i;
        }
        return maxLength;
    }
}
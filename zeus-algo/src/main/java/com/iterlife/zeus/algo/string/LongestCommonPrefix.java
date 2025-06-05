package com.iterlife.zeus.algo.string;

/**
 * <p>
 * Copyright (C) 2025 Shanghai Shuhe.Co.Ltd. All rights reserved.
 * create date: 2025/6/5 20:08
 * <p>
 *
 * @author lujie
 * @version V1.0.0
 * @desc https://leetcode.cn/problems/longest-common-prefix/
 * @datetime 2025/6/5 20:08
 **/
public class LongestCommonPrefix {
    
    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "floight"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "d3", "dcar"}));
    }
    
    public String longestCommonPrefix(String[] strArray) {
        int commonPrefixIndex = 0;
        while (findCommonPrefixIndex(strArray, commonPrefixIndex)) {
            commonPrefixIndex++;
        }
        return strArray[0].substring(0, commonPrefixIndex);
    }
    
    
    public boolean findCommonPrefixIndex(String[] strs, int index) {
        Character lastChar = null;
        for (int i = 0; i < strs.length; i++) {
            if (index == strs[i].length()) {
                return false;
            }
            if (lastChar == null) {
                lastChar = strs[i].charAt(index);
            } else if (lastChar != strs[i].charAt(index)) {
                return false;
            }
        }
        return true;
    }
}

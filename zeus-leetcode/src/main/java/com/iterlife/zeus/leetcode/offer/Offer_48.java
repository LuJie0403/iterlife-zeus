package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/5 13:38
 **/
public class Offer_48 {

    public static void main(String args[]) {
        System.out.println(new Offer_48_Solution().lengthOfLongestSubstring("abcabcda"));
        System.out.println(new Offer_48_Solution().lengthOfLongestSubstring("bbbbb"));
    }
}


class Offer_48_Solution {
    /**
     * 滑动窗口方案
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        int result = 1, left = 0, right = 1;
        for (left = 0; left < s.length(); left++) {
            for (; right < s.length(); ) {
                String strValue = s.substring(left, right);
                //   System.out.println(String.format("String[%d,%d]=%s,length=%s", left, right, strValue, right - left));
                //如果满足某种条件，right ++;
                if (!strValue.contains(String.valueOf(s.charAt(right)))) {
                    right++;
                    result = result < right - left ? right - left : result;
                    continue;
                }
                left++;
                right = left + 1;
            }
        }
        return result;
    }
}
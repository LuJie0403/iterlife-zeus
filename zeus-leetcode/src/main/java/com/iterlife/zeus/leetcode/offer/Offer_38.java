package com.iterlife.zeus.leetcode.offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @desc:https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 20:55
 **/
public class Offer_38 {
    public static void main(String[] args) {
        String[] result = new Offer_38_Solution().permutation("aabc");
    }
}

class Offer_38_Solution {
    private char[] charArray;
    private List<String> result = new LinkedList<>();

    public String[] permutation(String s) {
        charArray = s.toCharArray();
        //从第一位置开始全排列
        dfs(0);
        return result.toArray(new String[result.size()]);
    }


    private void dfs(int pos) {
        if (pos == charArray.length - 1) {
            result.add(String.valueOf(charArray));      // 添加排列方案
            return;
        }
        //已经加入排列的字符加入集合去重复
        HashSet<Character> usedCharSet = new HashSet<>();
        for (int i = pos; i < charArray.length; ++i) {
            if (!usedCharSet.contains(charArray[i])) {
                usedCharSet.add(charArray[i]);
                swap(i, pos);
                dfs(pos + 1);
                swap(i, pos);
            }
        }
    }

    private void swap(int i, int j) {
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
        System.out.println(String.format("charArray[%d] =%s,charArray[%d]=%s,str=%s", i, charArray[i], j, charArray[j], String.valueOf(charArray)));
    }
}
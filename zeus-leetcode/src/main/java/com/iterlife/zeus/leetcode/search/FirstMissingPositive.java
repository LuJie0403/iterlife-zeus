package com.iterlife.zeus.leetcode.search;

/**
 * @desc:https://leetcode-cn.com/problems/first-missing-positive/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/25 11:43
 **/
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] input = new int[]{2};
        System.out.println(new FirstMissingPositiveSolution().firstMissingPositive(input));
    }
}


class FirstMissingPositiveSolution {
    //所有<0的元素丢弃，所有>0的数字放置位置数组，取位置数组第一个及以后的值
    public int firstMissingPositive(int[] nums) {
        int[] positions = new int[nums.length + 1];
        for (int num : nums) {
            if (num < 0 || num >= positions.length) {
                continue;
            }
            positions[num] = num;
        }
        for (int i = 1; i < positions.length; ++i) {
            if (positions[i] == 0) {
                return i;
            }
        }
        return positions.length;
    }
}

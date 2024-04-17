package com.iterlife.zeus.algo.offer;

import java.util.Arrays;

/**
 * @desc:https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/6 20:51
 **/
public class Offer_45 {

    public static void main(String agrs[]) {

        System.out.println(new Offer_45_Solution().minNumber1(new int[]{10, 1, 2}));
        System.out.println(new Offer_45_Solution().minNumber1(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new Offer_45_Solution().minNumber1(new int[]{121, 12}));
        System.out.println(new Offer_45_Solution().minNumber2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));

        // System.out.println(new Offer_45_Solution().minNumber1(new int[]{12, 121}));
    }
}


class Offer_45_Solution {

    /**
     * a+b<b+a
     */
    public String minNumber1(int[] nums) {
        return Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((a, b) -> (a + b).compareTo((b + a)))
                .reduce("", (a, b) -> a + b);
    }

    public String minNumber2(int[] nums) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums.length - 1; ++j) {
                if (compare(nums[j], nums[j + 1]) >= 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            result.append(nums[i]);
        }
        return result.toString();
    }


    public int compare(int num1, int num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        return new StringBuffer(str1).append(str2).toString().compareTo(new StringBuilder(str2).append(str1).toString());
    }
}
package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 17:48
 **/
public class Offer_56_I {
    public static void main(String args[]) {
        new Offer_56_I_Solution().singleNumbers(new int[]{1, 6});
        new Offer_56_I_Solution().singleNumbers(new int[]{2, 6});
        new Offer_56_I_Solution().singleNumbers(new int[]{4, 4, 2, 10});
        new Offer_56_I_Solution().singleNumbers(new int[]{1, 2, 5, 2});
    }
}

class Offer_56_I_Solution {
    public int[] singleNumbers(int[] nums) {
        //二进制计算，十进制表示
        //所有原始数字的异或结果，最终实际上是唯一仅出现两次的数字的异或结果
        int xorResult = 0;
        //两个仅出现一次的数字的最高差异位置
        int xorPosition = 0;
        //两个只出现一次的数字的二进制表示中的最高差异位位置（从右边往左），依次位为分割，将原始数字分成两组，然后组内分别异或的结果就是目标数字
        int maxXorPosition = 0;

        int ans1 = 0, ans2 = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        xorPosition = xorResult & (-xorResult);
        while (xorPosition > 0) {
            if ((xorPosition & 0b0001) == 0) {
                maxXorPosition++;
            }
            xorPosition >>= 1;
        }
        for (int num : nums) {
            int tResult = num >> maxXorPosition;
            if ((tResult & 0b0001) == 0) {
                ans1 ^= num;
            } else {
                ans2 ^= num;
            }
        }
        return new int[]{ans1, ans2};
    }
}

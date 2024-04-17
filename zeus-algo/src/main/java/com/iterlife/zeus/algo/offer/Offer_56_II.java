package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/12 19:04
 **/
public class Offer_56_II {
}


class Offer_56_II_Solution {
    /**
     * 如果一个数字出现3次，它的二进制每一位也出现的3次。
     * 如果把所有的出现三次的数字的二进制表示的每一位都分别加起来，那么每一位都能被3整除。
     * 我们把数组中所有的数字的二进制表示的每一位都加起来。
     * 如果某一位能被3整除，那么这一位对只出现一次的那个数的这一肯定为0。
     * 如果某一位不能被3整除，那么只出现一次的那个数字的该位置一定为1.
     **/
    public int singleNumber(int[] nums) {
        // 目标值的二进制表示
        int[] binResult = new int[32];
        int index = 31, ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            index = 31;
            while (nums[i] > 0) {
                binResult[index--] += nums[i] & 0b0001;
                nums[i] >>= 1;
            }
        }
        for (int i = 0; i < binResult.length; ++i) {
            if (binResult[i] % 3 == 0) {
                binResult[i] = 0;
            } else {
                binResult[i] = 1;
                ans += Math.pow(2, 31 - i);
            }
        }
        return ans;
    }
}
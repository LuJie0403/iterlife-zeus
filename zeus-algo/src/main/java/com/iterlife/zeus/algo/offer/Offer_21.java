package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/4 17:38
 **/
public class Offer_21 {
    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 4};
        new Offer_21_Solution().exchange(nums);
    }
}


class Offer_21_Solution {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums;
        }
        int i = 0, j = nums.length - 1;
        //第一个偶数出现的位置
        int tNum = 0;
        for (i = 0; i < j; ) {
            if (nums[i] % 2 == 0) {
                tNum = nums[i];
                nums[i] = nums[j];
                nums[j] = tNum;
                j--;
                continue;
            }
            i++;
        }
        return nums;
    }
}

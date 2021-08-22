package com.iterlife.zeus.leetcode.dp;

/**
 * @desc:https://leetcode-cn.com/problems/the-masseuse-lcci/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/22 00:30
 **/
public class TheMasseuseLcci {
    public static void main(String args[]) {
        int[] nums1 = new int[]{1, 1};
        int[] nums2 = new int[]{2, 1, 1, 2};
        int[] nums3 = new int[]{1, 2, 3, 1};
        int[] nums4 = new int[]{2, 7, 9, 3, 1};
        int[] nums5 = new int[]{2, 1, 4, 5, 3, 1, 1, 3};
        int[] nums6 = new int[]{2, 1, 4, 5, 3, 1, 1, 3};
        System.out.println(new TheMasseuseLcciSolution().massage(nums1));
        System.out.println(new TheMasseuseLcciSolution().massage(nums2));
        System.out.println(new TheMasseuseLcciSolution().massage(nums3));
        System.out.println(new TheMasseuseLcciSolution().massage(nums4));
        System.out.println(new TheMasseuseLcciSolution().massage(nums5));
        System.out.println(new TheMasseuseLcciSolution().massage(nums5));
    }
}


class TheMasseuseLcciSolution {
    public int massage(int[] nums) {
        int pre1Cost, pre2Cost;
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        pre2Cost = nums[0];
        pre1Cost = Math.max(nums[0], nums[1]);
        int maxCost = Math.max(pre1Cost, pre2Cost);
        for (int i = 2; i < nums.length; ++i) {
            maxCost = Math.max(pre2Cost + nums[i], pre1Cost);
            pre2Cost = pre1Cost;
            pre1Cost = maxCost;
        }
        return maxCost;
    }
}

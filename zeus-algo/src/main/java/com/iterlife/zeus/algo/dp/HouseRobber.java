package com.iterlife.zeus.algo.dp;

/**
 * @desc:https://leetcode-cn.com/problems/house-robber/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/5/11 21:44
 **/
public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(new HouseRobberSolution().rob(nums));
    }
}


class HouseRobberSolution {
    public int rob(int[] nums) {
        //找到最大值所在的数组下标
        int result = 0;
        int count = nums.length;
        while (count >= 0) {
            int maxIndex = findMaxIndex(nums);
            System.out.println(maxIndex + ":" + nums[maxIndex]);
            result += nums[maxIndex];
            nums[maxIndex] = 0;
            count--;
            if (maxIndex >= 1) {
                nums[maxIndex - 1] = 0;
                count--;
            }
            if (maxIndex <= nums.length - 2) {
                nums[maxIndex + 1] = 0;
                count--;
            }
        }
        return result;
    }

    public int findMaxIndex(int[] nums) {
        int maxNum = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (maxNum < nums[i]) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

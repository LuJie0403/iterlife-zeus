package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/4 18:04
 **/
public class Offer_57 {
    public static void main(String args[]) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        //     int result[] = new Offer_57_Solution().twoSum1(nums, target);
        int result[] = new Offer_57_Solution().twoSum2(nums, target);
    }

}


class Offer_57_Solution {

    /**
     * 适用于小数据量的场景
     */
    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[]{};
        }
        int i, j;
        for (i = 0; i < nums.length - 1; ++i) {
            for (j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return new int[]{};
    }


    /**
     * 适用于全部数据量的场景
     */
    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[]{};
        }
        for (int i = 0; i < nums.length - 1; ++i) {
            int position = search(nums, target - nums[i], i + 1, nums.length - 1);
            if (position > 0) {
                return new int[]{nums[i], nums[position]};
            }
        }
        return new int[]{};
    }

    /**
     * 二分法查找，返回目标值位置
     */
    public int search(int nums[], int num, int low, int high) {
        int position = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < num) {
                low = mid + 1;
            } else if (nums[mid] > num) {
                high = mid - 1;
            } else {
                position = mid;
                break;
            }
        }
        return position;
    }
}
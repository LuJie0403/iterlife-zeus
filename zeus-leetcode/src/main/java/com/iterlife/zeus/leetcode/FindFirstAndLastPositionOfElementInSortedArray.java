package com.iterlife.zeus.leetcode;

/**
 * @desc:https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/25 21:44
 **/
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        new FindFirstAndLastPositionOfElementInSortedArraySolution().searchRange(nums, 8);
    }
}


class FindFirstAndLastPositionOfElementInSortedArraySolution {
    public int[] searchRange(int[] nums, int target) {
        int position[] = {-1, -1};
        for (int i = 0; i < nums.length; ++i) {
            //此处顺序变量，效果不好，最好的办法是二分查找
            if (target > nums[i]) {
                continue;
            }
            if (target < nums[i]) {
                break;
            }
            if (target == nums[i]) {
                if (position[0] < 0) {
                    position[0] = i;
                }
                if (position[0] >= 0) {
                    position[1] = i;
                }
            }
        }
        return position;
    }
}
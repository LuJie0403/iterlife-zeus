package com.iterlife.zeus.leetcode.search;

/**
 * @desc:https://leetcode-cn.com/problems/binary-search/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/4 19:15
 **/
public class BinarySearch {
    public static void main(String args[]) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 12;
        System.out.print(new BinarySearchSolution().search(nums, target));
    }
}

class BinarySearchSolution {
    public int search(int[] nums, int target) {
        int position = -1, low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                position = mid;
                break;
            }
        }
        return position;
    }
}
package com.iterlife.zeus.leetcode.offer;

import java.util.Arrays;

/**
 * @desc:https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/21 19:01
 **/
public class Offer_51 {
    public static void main(String args[]) {
        System.out.println(new Offer_51_Solution().reversePairs(new int[]{7, 5, 6, 4}));
    }
}

//分治法+归并法
class Offer_51_Solution {
    /**
     * 计算数组 nums 的逆序对个数
     */
    public int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] temp = new int[nums.length];
        return reversePairs(copy, 0, nums.length - 1, temp);
    }

    /**
     * 计算数组 nums[left，right] 的逆序对个数
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftReversePairsCounter = reversePairs(nums, left, mid, temp);
        int rightReversePairsCounter = reversePairs(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftReversePairsCounter + rightReversePairsCounter;
        }
        int mergeReversePairsCounter = mergeAndCountReversePairs(nums, left, mid, right, temp);
        return leftReversePairsCounter + rightReversePairsCounter + mergeReversePairsCounter;
    }


    private int mergeAndCountReversePairs(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int reversePairsCounter = 0, i = left, j = mid + 1;
        for (int k = left; k <= right; ++k) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                reversePairsCounter += (mid - i + 1);
            }
        }
        return reversePairsCounter;
    }
}
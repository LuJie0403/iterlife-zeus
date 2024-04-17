package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/29 19:46
 **/
public class Offer_53_I {

    public static void main(String args[]) {
        int[] nums = {};
        int target = 6;
        System.out.println(new Offer_53_I_Solution().search(nums, target));
    }

}


/**
 * 二分法查找
 */
class Offer_53_I_Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1, mid = 0, counter = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
            if (target == nums[mid]) {
                break;
            }
        }
        // 找到 mid 位置
        for (int i = mid; i >= 0; --i) {
            if (target == nums[i]) {
                counter++;
            }
        }
        for (int i = mid + 1; i < nums.length; ++i) {
            if (target == nums[i]) {
                counter++;
            }
        }
        return counter;
    }
}
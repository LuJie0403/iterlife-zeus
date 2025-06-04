package com.iterlife.zeus.algo.sort;

import java.util.Arrays;

/**
 * @desc:https://leetcode-cn.com/problems/merge-sorted-array/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/27 08:34
 **/
public class MergeSortedArray {
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        new MergeSortedArraySolution().merge(nums1, m, nums2, n);
        Arrays.stream(nums1).forEach(num -> System.out.println(num));
    }
}

class MergeSortedArraySolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = (nums1[m] > nums2[n]) ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }
    
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; ++i) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            int[] tNums = new int[m];
            for (int i = 0; i < m; ++i) {
                tNums[i] = nums1[i];
            }
            nums1 = tNums;
            return;
        }
        //数组从最后面开始往前移动
        int i = m, j = n;
        for (; i > 0 && j > 0; ) {
            if (nums1[i - 1] >= nums2[j - 1]) {
                nums1[i - 1 + j] = nums1[i - 1];
                i--;
            } else {
                nums1[i - 1 + j] = nums2[j - 1];
                j--;
            }
        }
        if (j > 0) {
            for (int t = 0; t < j; ++t) {
                nums1[t] = nums2[t];
            }
        }
    }
}

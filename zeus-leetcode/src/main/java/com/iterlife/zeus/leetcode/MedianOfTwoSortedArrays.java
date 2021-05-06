package com.iterlife.zeus.leetcode;

/**
 * @author Lu Jie
 * @desc https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @date 2021-05-06 14:44:00
 * @tags
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 3};
        int[] num2 = {5, 6, 7};
        System.out.println(new MedianOfTwoSortedArraysSolution().findMedianSortedArrays(num1, num2));
    }
}


class MedianOfTwoSortedArraysSolution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int size = length % 2 == 1 ? 1 : 2;
        int position = length / 2 + 1;
        int minIndex1 = 0, minIndex2 = 0;
        int minValue1 = 0, minValue2 = 0;
        for (int i = 0; i < position; i++) {
            //每次循环开始时，前次最小值变成本次的次最小值
            minValue2 = minValue1;
            //从小到大依次取数,每次取一个当前的最小数
            if (minIndex1 < nums1.length && minIndex2 < nums2.length) {
                if (nums1[minIndex1] < nums2[minIndex2]) {
                    minValue1 = nums1[minIndex1++];
                } else {
                    minValue1 = nums2[minIndex2++];
                }
                continue;
            }
            if (minIndex1 < nums1.length) {
                minValue1 = nums1[minIndex1++];
                continue;
            }
            if (minIndex2 < nums2.length) {
                minValue1 = nums2[minIndex2++];
                continue;
            }
        }
        return size == 1 ? minValue1 : (minValue1 + minValue2) / 2d;
    }
}

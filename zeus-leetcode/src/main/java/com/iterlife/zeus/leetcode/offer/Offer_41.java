package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/8 08:46
 **/
public class Offer_41 {
    public static void main(String args[]) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.print();

        medianFinder.addNum(-2);
        medianFinder.print();

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

class MedianFinder {
    /**
     * initialize your data structure here.
     */
    int[] nums = null;
    int counter = 0;

    public MedianFinder() {
        nums = new int[50000];
        counter = 0;
    }

    public void addNum(int num) {
        for (int index = counter; index >= 0; index--) {
            if (index == 0 || counter == 0) {
                nums[index] = num;
                counter++;
                return;
            }
            if (nums[index - 1] > num) {
                nums[index] = nums[index - 1];
            } else {
                nums[index] = num;
                counter++;
                break;
            }
        }
    }

    public double findMedian() {
        if (counter % 2 == 1) {
            return nums[counter / 2];
        }
        return (nums[counter / 2] + nums[counter / 2 - 1]) / 2.0;
    }

    public void print() {
        for (int i = 0; i < counter; ++i) {
            System.out.print(String.format(" %d ", nums[i]));
        }
        System.out.println("\n" + counter);
    }
}


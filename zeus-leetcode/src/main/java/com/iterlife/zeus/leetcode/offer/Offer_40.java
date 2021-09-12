package com.iterlife.zeus.leetcode.offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desc:https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/8 08:09
 **/
public class Offer_40 {
}


class Offer_40_Solution {
    /**
     * （大顶堆）堆排序方案
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[]{};
        }
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            if (heap.size() < k) {
                heap.offer(num);
                continue;
            }
            if (num < heap.peek()) {
                heap.poll();
                heap.offer(num);
            }
        }
        int[] result = new int[k];
        while (!heap.isEmpty()) {
            result[--k] = heap.poll();
        }
        return result;
    }

    /**
     * K 趟冒泡排序，效率真差
     * 执行用时：596 ms, 在所有 Java 提交中击败了5.00%的用户
     * 内存消耗：39.9 MB, 在所有 Java 提交中击败了17.07%的用户
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        for (int i = 0; i < k; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return Arrays.copyOf(arr, k);
    }
}
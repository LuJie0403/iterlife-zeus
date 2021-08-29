package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/24 23:40
 **/
public class Offer_06 {
}


class Offer_06_Solution {

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        int index = 10000;
        int[] inStack = new int[index];

        while (head != null) {
            inStack[--index] = head.val;
            head = head.next;
        }
        int[] outStack = new int[10000 - index];
        for (int i = 0; i < 1000 - index; ) {
            outStack[i++] = inStack[index++];
        }
        return outStack;
    }


}
package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/3 09:21
 **/
public class Offer_22 {
}


class Offer_22_Solution {

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        while (pointer1 != null) {
            pointer1 = pointer1.next;
            k--;
            if (k < 0) {
                pointer2 = pointer2.next;
            }
        }
        if (k > 0) {
            return null;
        }
        return pointer2;
    }
}
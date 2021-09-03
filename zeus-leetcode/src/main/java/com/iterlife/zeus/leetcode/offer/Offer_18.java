package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/3 08:52
 **/
public class Offer_18 {
    public static void main(String args[]) {
        Offer_18_Solution.ListNode l1 = new Offer_18_Solution.ListNode(4, new Offer_18_Solution.ListNode(5, new Offer_18_Solution.ListNode(1, new Offer_18_Solution.ListNode(9, null))));
        new Offer_18_Solution().deleteNode(l1, 5);
    }
}


class Offer_18_Solution {
    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
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

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode preNode = head;
        ListNode pointer = preNode.next;
        while (pointer != null) {
            if (pointer.val == val) {
                preNode.next = pointer.next;
                pointer = pointer.next;
                break;
            }
            preNode = pointer;
            pointer = pointer.next;
        }
        return head;
    }
}
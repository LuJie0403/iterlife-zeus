package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/2 22:57
 **/
public class Offer_25 {

    public static void main(String args[]) {
        Offer_25_Solution.ListNode l1 = new Offer_25_Solution.ListNode(1, new Offer_25_Solution.ListNode(2, new Offer_25_Solution.ListNode(4, null)));
        Offer_25_Solution.ListNode l2 = new Offer_25_Solution.ListNode(1, new Offer_25_Solution.ListNode(3, new Offer_25_Solution.ListNode(4, null)));
        new Offer_25_Solution().mergeTwoLists(l1, l2);
    }
}


class Offer_25_Solution {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    /**
     * l2 拼接到 l1 实现合并排序
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode temp1 = null;
        ListNode temp2 = null;
        ListNode result = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp1 = new ListNode(l1.val);
            }
            if (l1.val > l2.val) {
                temp1 = new ListNode(l2.val);
            }
            if (l1.val <= l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
            if (temp2 == null) {
                temp2 = temp1;
                result = temp2;
            } else {
                temp2.next = temp1;
                temp2 = temp2.next;
            }
        }
        if (l1 != null) {
            temp2.next = l1;
        }
        if (l2 != null) {
            temp2.next = l2;
        }
        return result;
    }


    /**
     * 递归方法
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
        return null;
    }
}

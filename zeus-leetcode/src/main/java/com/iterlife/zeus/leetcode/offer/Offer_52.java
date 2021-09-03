package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/3 14:02
 **/
public class Offer_52 {

    public static void main(String args[]) {
    }

}

class Offer_52_Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        /**
         * 两个链表不一样长，则
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode nodeA = headA;
            ListNode nodeB = headB;
            int lengthA = getListNodeLength(nodeA);
            int lengthB = getListNodeLength(nodeA);
           


            return null;
        }

        private int getListNodeLength(ListNode node) {
            if (node == null) {
                return 0;
            }
            int length = 0;
            while (node != null) {
                length++;
                node = node.next;
            }
            return length;
        }
    }
}
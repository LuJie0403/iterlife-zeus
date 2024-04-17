package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
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
         * 两个链表 A 和 B 相交，则 A+B 和 B+A 长度一致，且两者的末位节点是共享的部分。
         * 如分别遍历一遍 A+B 和 B+A，则最终将同时到达结束的位置，结束位置前的第一个共享节点就是 A 和 B 开始相交的地方
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pNodeA = headA;
            ListNode pNodeB = headB;
            while (pNodeA != pNodeB) {
                pNodeA = (pNodeA == null ? headB : pNodeA.next);
                pNodeB = (pNodeB == null ? headA : pNodeB.next);
            }
            return pNodeA;
        }


        private void print(int index, String listNodeName, ListNode node) {
            System.out.print(String.format("%d:%s=[", index, listNodeName));
            while (node != null) {
                System.out.print(String.format(" %s ", node.val));
                node = node.next;
            }
            System.out.println("]");
        }
    }
}
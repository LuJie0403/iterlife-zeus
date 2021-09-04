package com.iterlife.zeus.leetcode.offer;

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
         * 两个链表A和B相交，则 A+B 和 B+A 长度一致，如果分别遍历一遍，则最终他们将同时到达结束的位置
         * 结束位置前的交叉点则是 A 和 B 相交的地方
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode pNodeA = headA;
            ListNode pNodeB = headB;
            int counter = 0;
            while (pNodeA != pNodeB) {
                pNodeA = (pNodeA == null ? headB : pNodeA.next);
                pNodeB = (pNodeB == null ? headA : pNodeB.next);
                counter++;
                print(counter, "A", pNodeA);
                print(counter, "B", pNodeB);
            }
            System.out.println(String.format(" counter=%s", counter));
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
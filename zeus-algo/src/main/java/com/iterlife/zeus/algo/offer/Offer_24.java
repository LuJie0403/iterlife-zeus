package com.iterlife.zeus.algo.offer;

/**
 * @desc:https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/25 00:12
 **/
public class Offer_24 {
    public static void main(String agrs[]) {
    }
}


class Offer_24_Solution {

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

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode preNode = null, nextNode = null;
        printList(head);
        while (current != null) {
            nextNode = current.next;
            current.next = preNode;
            preNode = current;
            current = nextNode;
            printList(head);
        }
        return preNode;
    }

    public void printList(ListNode head) {
        System.out.println(" [ ");
        while (head != null) {
            System.out.print(String.format(" %s ", head.val));
            head = head.next;
        }
        System.out.println("]\n");
    }
}
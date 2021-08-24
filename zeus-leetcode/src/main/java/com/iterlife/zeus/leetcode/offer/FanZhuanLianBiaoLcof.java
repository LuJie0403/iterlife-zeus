package com.iterlife.zeus.leetcode.offer;

/**
 * @desc:https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/25 00:12
 **/
public class FanZhuanLianBiaoLcof {
    public static void main(String agrs[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        new FanZhuanLianBiaoLcofSolution().reverseList(head);
    }
}


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


class FanZhuanLianBiaoLcofSolution {


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
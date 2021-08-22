package com.iterlife.zeus.leetcode.list;

/**
 * @desc:https://leetcode-cn.com/problems/linked-list-cycle/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/26 19:33
 **/
public class LinkedListCycle {
    public static void main(String[] args) {
        new LinkedListCycleSolution().hasCycle(null);
    }
}


class LinkedListCycleSolution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fastPointer = head.next;
        ListNode slowPointer = head;
        while (fastPointer != slowPointer) {
            if (fastPointer == null || fastPointer.next == null) {
                return false;
            }
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

        }
        return true;
    }

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

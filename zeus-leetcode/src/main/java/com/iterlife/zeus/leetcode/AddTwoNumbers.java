package com.iterlife.zeus.leetcode;

/**
 * @author Lu Jie
 * @desc CPU 加法器实现原理 https://leetcode-cn.com/problems/add-two-numbers/
 * @date 2021-04-24 22:45:00
 * @tags Definition for singly-linked list.
 */


public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode l11 = new ListNode(7, null);
        ListNode l21 = new ListNode(5, null);

        ListNode resultNode = new AddTwoNumbersSolution().addTwoNumbers(l11, l21);
        while (resultNode != null) {
            System.out.print(resultNode.val + " ");
            resultNode = resultNode.next;
        }
    }
}

class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers3(l1, l2);
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        //头节点
        ListNode headNode = new ListNode(-1, null);
        //指向当前计算结果节点的位置执政
        ListNode pointer = headNode;
        //进位变量
        int overflow = 0;
        while (l1 != null || l2 != null || overflow > 0) {
            if (l1 != null) {
                overflow += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                overflow += l2.val;
                l2 = l2.next;
            }
            pointer.next = new ListNode(overflow % 10, null);
            pointer = pointer.next;
            overflow /= 10;
        }
        return headNode.next;
    }

    private ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int overflow = 0;
        ListNode headNode = new ListNode(-1, null);
        ListNode nextNode = headNode;
        while (l1 != null || l2 != null || overflow > 0) {
            if (l1 != null && l2 != null) {
                int val = l1.val + l2.val + overflow;
                nextNode.next = new ListNode(val % 10, null);
                overflow = val >= 10 ? 1 : 0;
                nextNode = nextNode.next;
                l1 = l1.next;
                l2 = l2.next;
                continue;
            }
            if (l1 != null) {
                int val = l1.val + overflow;
                nextNode.next = new ListNode(val % 10, null);
                overflow = val >= 10 ? 1 : 0;
                nextNode = nextNode.next;
                l1 = l1.next;
                continue;
            }
            if (l2 != null) {
                int val = l2.val + overflow;
                nextNode.next = new ListNode(val % 10, null);
                overflow = val >= 10 ? 1 : 0;
                nextNode = nextNode.next;
                l2 = l2.next;
                continue;
            }
            if (overflow > 0) {
                int val = overflow;
                nextNode.next = new ListNode(val % 10, null);
                overflow = val >= 10 ? 1 : 0;
                nextNode = nextNode.next;
            }
        }
        return headNode.next;
    }

    private ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int overflow = 1;
        int i1 = 0;
        int i2 = 0;
        int result = 0;
        while (l1 != null && l2 != null) {
            i1 = i1 + l1.val * overflow;
            i2 = i2 + l2.val * overflow;
            l1 = l1.next;
            l2 = l2.next;
            overflow *= 10;
        }
        while (l1 != null) {
            i1 = i1 + l1.val * overflow;
            l1 = l1.next;
            overflow *= 10;
        }
        while (l2 != null) {
            i2 = i2 + l2.val * overflow;
            l2 = l2.next;
            overflow *= 10;
        }
        result = i1 + i2;
        overflow = 10;


        ListNode preNode = new ListNode(result % 10, null);
        ListNode resultNode = preNode;
        result = result / overflow;
        while (result > 0.1) {
            ListNode tempNode = new ListNode(result % overflow, null);
            preNode.next = tempNode;
            preNode = preNode.next;
            result = result / overflow;
        }
        return resultNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

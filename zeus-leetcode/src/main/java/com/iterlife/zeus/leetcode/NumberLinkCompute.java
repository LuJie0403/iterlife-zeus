package com.iterlife.zeus.leetcode;

import org.w3c.dom.NodeList;

import java.util.*;

/**
 * @author Lu Jie
 * @desc https://leetcode-cn.com/problems/add-two-numbers/
 * @date 2021-04-24 22:45:00
 * @tags Definition for singly-linked list.
 */


public class NumberLinkCompute {
    public static void main(String[] args) {

        ListNode l11 = new ListNode(9, null);

        ListNode l210 = new ListNode(9, null);
        ListNode l29 = new ListNode(9, l210);
        ListNode l28 = new ListNode(9, l29);
        ListNode l27 = new ListNode(9, l28);
        ListNode l26 = new ListNode(9, l27);
        ListNode l25 = new ListNode(9, l26);
        ListNode l24 = new ListNode(9, l25);
        ListNode l23 = new ListNode(9, l24);
        ListNode l22 = new ListNode(9, l23);
        ListNode l21 = new ListNode(1, l22);

        ListNode resultNode = new Solution().addTwoNumbers(l11, l21);
        while (resultNode != null) {
            System.out.print(resultNode.val + " ");
            resultNode = resultNode.next;
        }

    }


}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

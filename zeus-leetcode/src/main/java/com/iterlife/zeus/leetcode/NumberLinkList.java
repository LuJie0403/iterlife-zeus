package com.iterlife.zeus.leetcode;

/**
 * @desc https://leetcode-cn.com/problems/add-two-numbers/
 *   @author Lu Jie
 *   @date 2021-04-24 22:45:00
 *   @tags
 * */
public class NumberLinkList {

    public static void main(String[] args){
        ListNode node13=new ListNode(3);
        ListNode node12=new ListNode(4,node13);
        ListNode node11=new ListNode(2,node12);

        ListNode node23=new ListNode(5);
        ListNode node22=new ListNode(6,node23);
        ListNode node21=new ListNode(4,node22);

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    }
}




   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

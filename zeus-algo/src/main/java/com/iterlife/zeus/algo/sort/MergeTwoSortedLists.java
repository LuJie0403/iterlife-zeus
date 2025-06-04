package com.iterlife.zeus.algo.sort;

/**
 * <p>
 * Copyright (C) 2025 Shanghai Shuhe.Co.Ltd. All rights reserved.
 * create date: 2025/6/4 21:07
 * <p>
 *
 * @author lujie
 * @version V1.0.0
 * @desc https://leetcode.cn/problems/merge-two-sorted-lists/
 * @datetime 2025/6/4 21:07
 **/
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        ListNode resultList = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
        while (resultList != null) {
            System.out.println(resultList.val);
            resultList = resultList.next;
        }
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode();
        ListNode result = temp;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return result.next;
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


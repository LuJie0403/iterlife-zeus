package com.iterlife.zeus.leetcode;

/**
 * @desc:https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/5/27 09:32
 **/
public class ConvertBinaryNumberInALinkedListToInteger {
    public static void main(String[] args) {

    }
}

/**
 * Definition for singly-linked list.
 **/
class BinaryNumber {
    int val;
    BinaryNumber next;

    BinaryNumber(int x) {
        val = x;
    }
}

class ConvertBinaryNumberInALinkedListToIntegerSolution {

    public int getDecimalValue(BinaryNumber head) {
        if (head == null) {
            return 0;
        }

        Integer value = new Integer(head.val);
        while (head.next != null) {
            value *= 2;
            value += head.next.val;
            head = head.next;
        }
        return value;
    }
}
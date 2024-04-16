package com.iterlife.zeus.leetcode.offer;



import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @desc:https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/19 13:25
 **/
public class Offer_31 {
}

class Offer_31_Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>(pushed.length);
        int index = 0;
        for (int i = 0; i < pushed.length; ++i) {
            stack.push(pushed[i]);
            while (index < popped.length && !stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return index < popped.length;
    }
}
package com.iterlife.zeus.leetcode.offer1;

import java.util.LinkedList;

/**
 * @desc:https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/25 23:48
 **/
public class YongLiangGeZhanShiXianDuiLieLcof {
    public static void main(String args[]) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(1);
        print(" stack.add(1)", stack);
        stack.push(20);
        print(" stack.push(20)", stack);
        stack.add(2);
        print(" stack.add(2)", stack);
        stack.push(30);
        print(" stack.push(30)", stack);
        stack.add(3);
        print(" stack.add(3)", stack);
        stack.pop();
        print(" stack.pop()", stack);
        stack.add(7);
        print(" stack.add(7)", stack);
        stack.add(8);
        print(" stack.add(8)", stack);
        stack.add(9);
        print(" stack.add(8)", stack);
        stack.poll();
        print(" stack.poll()", stack);
        stack.peek();
        print(" stack.peek()", stack);
        stack.add(4);
        print(" stack.add(4)", stack);
        stack.pop();
        print(" stack.pop()", stack);
        stack.add(5);
        print(" stack.add(5)", stack);
        stack.poll();
        print(" stack.poll()", stack);
        stack.add(6);
        print(" stack.add(6)", stack);
        stack.peek();
        print(" stack.peek()", stack);
    }


    public static void print(String tag, LinkedList<Integer> stack) {
        System.out.print(String.format("%s:[", tag));
        stack.stream().forEach(item -> {
            System.out.print(String.format(" %s  ", item));
        });
        System.out.println("]");
    }

}

class CQueue {

    LinkedList<Integer> linkedList1 = null;
    LinkedList<Integer> linkedList2 = null;

    public CQueue() {
        linkedList1 = new LinkedList<>();
        linkedList2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        linkedList1.add(value);
    }

    public int deleteHead() {
        if (!linkedList2.isEmpty()) {
            return linkedList2.pop();
        }
        if (linkedList1.isEmpty()) {
            return -1;
        }
        while (!linkedList1.isEmpty()) {
            linkedList2.add(linkedList1.pop());
        }
        return linkedList2.pop();

    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
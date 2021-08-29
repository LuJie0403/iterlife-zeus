package com.iterlife.zeus.leetcode.offer1;

/**
 * @desc:https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/23 22:31
 **/
public class BaoHanMinHanShuDeZhanLcof {
    public static void main(String args[]) {


        MinStack minStack = new MinStack();

        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);

        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}


class MinStack {

    Node head;//模拟栈数据节点


    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            print();
            head = new Node(x, Math.min(head.min, x), head);
        }

    }

    public void pop() {
        print();
        head = head.next;
    }

    public int top() {
        print();
        return head.value;
    }

    public int min() {
        print();
        return head.min;
    }

    public void print() {
        Node tHead = head;
        while (tHead != null) {
            System.out.print(String.format("%s ", tHead.toString()));
            tHead = tHead.next;
        }
    }

    private class Node {
        private int value;
        private int min;
        private Node next;

        public Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", min=" + min +
                    '}';
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

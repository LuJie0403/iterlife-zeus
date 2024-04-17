package com.iterlife.zeus.algo.offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @desc:https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/9/20 12:22
 **/
public class Offer_59_II {
    public static void main(String args[]) {
        MaxQueue queue = new MaxQueue();
        queue.push_back(46);
        queue.pop_front();
        queue.max_value();
        queue.pop_front();
        queue.max_value();
        queue.pop_front();
        queue.push_back(15);
    }
}


class MaxQueue {

    Queue<Integer> queue;
    int maxElem = -1, size = 0;

    public MaxQueue() {
        queue = new ArrayDeque<Integer>();
    }

    public int max_value() {
        return maxElem;
    }

    public void push_back(int value) {
        queue.offer(value);
        if (value > maxElem) {
            this.maxElem = value;
        }
        size++;
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int elem = queue.poll();
        //删除的是最大的元素，则需要给最大的元素重新赋值
        if (elem >= this.maxElem) {
            this.maxElem = -1;
            for (int i = 0; i < queue.size(); ++i) {
                int tValue = queue.poll();
                this.maxElem = this.maxElem < tValue ? tValue : this.maxElem;
                queue.offer(tValue);
            }
        }
        size--;
        return elem;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
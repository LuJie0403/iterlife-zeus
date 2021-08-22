package com.iterlife.zeus.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @desc:https://leetcode-cn.com/problems/print-in-order/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/4/25 17:40
 **/
public class PrintInOrder {
    public static void main(String[] args) {

    }
}

class Foo {

    private volatile AtomicInteger semaphore = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore.set(2);

    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (semaphore.get() != 2) ;
        printSecond.run();
        semaphore.set(3);

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (semaphore.get() != 3) ;
        printThird.run();
    }
}

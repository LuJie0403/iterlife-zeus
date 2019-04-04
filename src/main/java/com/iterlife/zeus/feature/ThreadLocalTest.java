package com.iterlife.zeus.feature;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalTest {

    private static ThreadLocal mThreadLocal = new ThreadLocal();
    private static ThreadLocal nThreadLocal = new ThreadLocal();

    public static void main(String args[]) {
    }

    public static void doTest() {
        mThreadLocal.set("test");
        List list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("thread");
        mThreadLocal.set(list);
        System.out.println(mThreadLocal.get());
        System.out.println(nThreadLocal.get());
    }

}

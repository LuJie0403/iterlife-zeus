package com.iterlife.zeus.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    private static ThreadLocal mThreadLocal = new ThreadLocal();

    public static void main(String args[]) {
        ThreadPoolExecutor linkedBlockTaskPool = new ThreadPoolExecutor(5, 10,
                60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 5; ++i) {
            int k = i;
            linkedBlockTaskPool.execute(new Runnable() {
                @Override
                public void run() {
                    List list = new ArrayList();
                    list.add("one");
                    if (k % 2 == 0) {
                        list.add("two");
                    }
                    mThreadLocal.set(list);
                    System.out.println(String.format("i=%s,threadId=%s,context=%s", String.valueOf(k), Thread.currentThread().getId(), mThreadLocal.get()));
                }
            });

        }
    }


}

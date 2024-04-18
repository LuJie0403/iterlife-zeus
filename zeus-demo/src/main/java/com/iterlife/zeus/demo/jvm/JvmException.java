package com.iterlife.zeus.demo.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class JvmException {

    public static void main(String[] args) {
        /**
         -Xms32m
         -Xmx64m
         -Xss16m
         -XX:PermSize=4m
         -XX:MaxPermSize=8m
         -XX:MetaspaceSize=1m
         -XX:MaxMetaspaceSize=8m
         -XX:+HeapDumpOnOutOfMemoryError
         -XX:HeapDumpPath=G:\IterLife_Java1.8.x_WorkSpace\zeus\dump\hprof\gc.hprof
         */
        testHeapOOM();
        testStackSOF();
        testRuntimeConstantPoolOOM();
        testMethodAreaOOM();

    }

    /** 堆内存溢出 */
    static class HeapOOM {
        byte byteArray1[] = new byte[8 * 1024];
    }

    /**栈深度不足*/
    static class StackSOF {
        private int stackLength = 1;

        private void stackLeak() {
            stackLength++;
            stackLeak();

        }
    }

    /**运行时常量池内存溢出*/
    static class RuntimeConstantPoolOOM {

    }

    /**运行时方法区*/
    static class MethodAreaOOM {

        public void sayHello() {
            System.out.println("Hello World!");
        }
    }

    private static void testHeapOOM() {
        List<HeapOOM> list = new ArrayList<HeapOOM>();
        try {
            while (true) {
                list.add(new HeapOOM());
            }
        } catch (Throwable e) {
            System.out.println("testHeapOOM:" + list.size() + "\t" + e);
        }

    }

    private static void testStackSOF() {
        StackSOF stackSOF = new StackSOF();
        try {
            stackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("testStackSOF:" + stackSOF.stackLength + "\t" + e);
        }
    }

    private static void testRuntimeConstantPoolOOM() {
        List<String> list = new ArrayList<String>();
        AtomicInteger aInt = new AtomicInteger(0);
        try {
            while (true) {
                list.add(String.valueOf(aInt.getAndAdd(1)).intern());
            }
        } catch (Throwable e) {
            System.out.println("testRuntimeConstantPoolOOM:" + aInt.get() + "\t" + e);
        }

    }

    private static void testMethodAreaOOM() {
        AtomicInteger aCounter = new AtomicInteger(0);
        try {
            while (true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(MethodAreaOOM.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {

                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
                                                                                                        throws Throwable {

                        return proxy.invokeSuper(obj, args);
                    }
                });
                enhancer.create();
                aCounter.getAndAdd(1);
            }
        } catch (Throwable e) {
            System.out.println("testMethodAreaOOM:" + aCounter.get() + "\t" + e);
            e.printStackTrace();
        }
    }
}

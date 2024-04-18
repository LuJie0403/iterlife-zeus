package com.iterlife.zeus.demo.jvm;

/**
 * 加载
 * 连接
 * ** 验证
 * **** 源格式验证：保证进入方法区的代码不会对 JVM 造成灾难，可以被正确解析
 * **** 元数据验证：即语义校验，满足语法规定
 * **** 字节码验证
 * **** 软引用验证
 * ** 准备
 * ** 解析
 * 初始化
 * 使用卸载
 */
public class PassiveReference {

    public static void main(String[] args) {
        /**常量传播优化*/
        System.out.println(SubClass.f_HelloWorld);
        /**被动引用的例子*/
        System.out.println(SubClass.helloWorld);
    }
}


class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static String helloWorld = "HelloWorld1";
    public final static String f_HelloWorld = "HelloWorld2";
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}

package com.iterlife.zeus.demo.jdk;

import com.iterlife.zeus.demo.web.service.impl.ByeServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Cglib动态代理测试类，实现了MethodInterceptor接口，用于创建ByeServiceImpl的动态代理。
 */
public class CglibDynamicProxy implements MethodInterceptor {
    private final ByeServiceImpl byeService;

    /**
     * 构造函数，初始化被代理的服务对象。
     *
     * @param byeService 被代理的ByeServiceImpl实例
     */
    public CglibDynamicProxy(ByeServiceImpl byeService) {
        this.byeService = byeService;
    }

    /**
     * 通过Cglib动态代理拦截方法调用。
     *
     * @param arg0       代理对象
     * @param arg1       被调用的方法
     * @param arg2       被调用方法的参数数组
     * @param arg3       方法代理
     * @return           拦截器不返回任何内容
     * @throws Throwable 抛出任何异常
     */
    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        // 打印代理调用信息
        System.out.println("Invoked by CglibDynamicProxy start.\nProxyName=" + arg0.getClass().getCanonicalName() + "\nMethodName=" + arg1.getName() + "\nArgs=" + Arrays.toString(arg2) + "\nMethodProxy=" + arg3);
        arg1.setAccessible(true); // 设置方法可访问
        arg1.invoke(this.byeService, arg2); // 调用实际方法
        // 打印代理调用结束信息
        System.out.println("Invoked by CglibDynamicProxy end.");
        return null;
    }

    /**
     * 应用的主入口函数。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 设置Cglib生成的临时类文件的输出目录
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "G:\\IterLife_Java1.8.x_WorkSpace\\zeus\\target\\output");
        Enhancer enhancer = new Enhancer(); // 创建Enhancer对象
        enhancer.setSuperclass(ByeServiceImpl.class); // 设置代理的超类
        // 设置回调方法，使用当前类的实例作为拦截器
        enhancer.setCallback(new CglibDynamicProxy(new ByeServiceImpl()));

        Object proxyObj = enhancer.create(); // 创建代理对象
        if (proxyObj instanceof ByeServiceImpl) {
            // 使用代理对象调用方法
            ((ByeServiceImpl) proxyObj).bye("Lu Jie");
        }
    }
}


package com.iterlife.zeus.xspring.aop.advice.proxy;

/**
 * AOP代理对象，其实现方式由JDK动态代理和CGLIB代理两种
 **/
public interface AopProxy {

	Object getProxy();

	Object getProxy(ClassLoader classLoader);
}

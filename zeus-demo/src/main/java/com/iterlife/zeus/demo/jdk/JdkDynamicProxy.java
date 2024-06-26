package com.iterlife.zeus.demo.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.iterlife.zeus.demo.web.service.HelloService;
import com.iterlife.zeus.demo.web.service.impl.HelloServiceImp;

/**
 * @author iter_1024
 */
public class JdkDynamicProxy implements InvocationHandler {

	private final HelloService helloService;

	public JdkDynamicProxy(HelloService helloService) {
		this.helloService = helloService;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Invoked by JdkDynamicProxy start.\nProxyName="
				+ proxy.getClass().getCanonicalName() + "\nMethodName="
				+ method.getName() + "\nArgs=" + Arrays.toString(args));
		method.setAccessible(true);
		method.invoke(this.helloService, args);
		System.out.println("Invoked by JdkDynamicProxy end.");
		return null;
	}

	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",
				"true");
		Object proxyObj = Proxy.newProxyInstance(
				HelloService.class.getClassLoader(),
				new Class<?>[]{HelloService.class},
				new JdkDynamicProxy(new HelloServiceImp()));
		if (proxyObj instanceof HelloService) {
			((HelloService) proxyObj).say("Lu Jie");
		}

	}
}

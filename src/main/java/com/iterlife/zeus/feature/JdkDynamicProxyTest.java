package com.iterlife.zeus.feature;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.iterlife.zeus.service.HelloService;
import com.iterlife.zeus.service.impl.HelloServiceImp;

public class JdkDynamicProxyTest implements InvocationHandler {

	private HelloService helloService;

	public JdkDynamicProxyTest(HelloService helloService) {
		this.helloService = helloService;
	}

	@Override
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

	public static void main(String args[]) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles",
				"true");
		Object proxyObj = Proxy.newProxyInstance(
				HelloService.class.getClassLoader(),
				new Class<?>[]{HelloService.class},
				new JdkDynamicProxyTest(new HelloServiceImp()));
		if (proxyObj instanceof HelloService) {
			((HelloService) proxyObj).say("Lu Jie");
		}

	}
}

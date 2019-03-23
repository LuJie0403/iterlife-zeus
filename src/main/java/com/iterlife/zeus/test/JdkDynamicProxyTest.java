package com.iterlife.zeus.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.iterlife.zeus.test.service.HelloServce;
import com.iterlife.zeus.test.service.impl.HelloServceImp;

public class JdkDynamicProxyTest implements InvocationHandler {

	private HelloServce helloServce;

	public JdkDynamicProxyTest(HelloServce helloServce) {
		this.helloServce = helloServce;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Invoked by JdkDynamicProxy start.\nProxyName="
				+ proxy.getClass().getCanonicalName() + "\nMethodName="
				+ method.getName() + "\nArgs=" + Arrays.toString(args));
		method.setAccessible(true);
		method.invoke(this.helloServce, args);
		System.out.println("Invoked by JdkDynamicProxy end.");
		return null;
	}

	public static void main(String args[]) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
		Object proxyObj = Proxy.newProxyInstance(
				HelloServce.class.getClassLoader(),
				new Class<?>[] { HelloServce.class }, new JdkDynamicProxyTest(
						new HelloServceImp()));
		if (proxyObj instanceof HelloServce) {
			((HelloServce) proxyObj).say("Lu Jie");
		}

	}
}

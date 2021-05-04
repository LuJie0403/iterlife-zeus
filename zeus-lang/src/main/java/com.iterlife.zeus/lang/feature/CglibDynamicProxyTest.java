package com.iterlife.zeus.lang.feature;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.iterlife.zeus.demo.service.impl.ByeServiceImpl;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDynamicProxyTest implements MethodInterceptor {
	private final ByeServiceImpl byeService;

	public CglibDynamicProxyTest(ByeServiceImpl byeService) {
		this.byeService = byeService;
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("Invoked by CglibDynamicProxy start.\nProxyName="
				+ arg0.getClass().getCanonicalName() + "\nMethodName="
				+ arg1.getName() + "\nArgs=" + Arrays.toString(arg2)
				+ "\nMethodProxy=" + arg3);
		arg1.setAccessible(true);
		arg1.invoke(this.byeService, arg2);
		System.out.println("Invoked by CglibDynamicProxy end.");
		return null;
	}

	public static void main(String[] args) {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
				"G:\\IterLife_Java1.8.x_WorkSpace\\zeus\\target\\output");
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(ByeServiceImpl.class);
		enhancer.setCallback(new CglibDynamicProxyTest(new ByeServiceImpl()));

		Object proxyObj = enhancer.create();
		if (proxyObj instanceof ByeServiceImpl) {
			((ByeServiceImpl) proxyObj).bye("Lu Jie");
		}
	}
}

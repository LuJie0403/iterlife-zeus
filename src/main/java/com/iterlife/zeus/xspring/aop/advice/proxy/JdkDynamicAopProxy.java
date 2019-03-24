package com.iterlife.zeus.xspring.aop.advice.proxy;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkDynamicAopProxy
		implements
			AopProxy,
			InvocationHandler,
			Serializable {

	private static final long serialVersionUID = 2737581733139251568L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 * java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.aop.advice.proxy.AopProxy#getProxy()
	 */
	@Override
	public Object getProxy() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.aop.advice.proxy.AopProxy#getProxy(java.lang.
	 * ClassLoader)
	 */
	@Override
	public Object getProxy(ClassLoader classLoader) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.iterlife.zeus.xspring.aop.matcher;

import java.lang.reflect.Method;

public class StaticMethodMatcher implements MethodMatcher{

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object[] args) {
		// TODO Auto-generated method stub
		return false;
	}

}

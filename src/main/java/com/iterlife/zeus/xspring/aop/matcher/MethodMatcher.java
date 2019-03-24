package com.iterlife.zeus.xspring.aop.matcher;

import java.lang.reflect.Method;

public interface MethodMatcher {

	boolean matches(Method method, Class<?> targetClass);

	boolean matches(Method method, Class<?> targetClass, Object[] args);

}

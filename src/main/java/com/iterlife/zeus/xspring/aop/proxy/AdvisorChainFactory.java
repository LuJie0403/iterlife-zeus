package com.iterlife.zeus.xspring.aop.proxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 拦截器链工厂类
 **/
public interface AdvisorChainFactory {
	List<Object> getInterceptorsAndDynamicInterceptionAdvice(
			TargetClassAware config, Method method, Class<?> targetClass);;
}

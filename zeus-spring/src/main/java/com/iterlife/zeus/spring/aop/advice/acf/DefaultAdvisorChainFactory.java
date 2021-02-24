package com.iterlife.zeus.spring.aop.advice.acf;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

import com.iterlife.zeus.spring.aop.proxy.AdvisorChainFactory;
import com.iterlife.zeus.spring.aop.proxy.TargetClassAware;

public class DefaultAdvisorChainFactory
		implements
			AdvisorChainFactory,
			Serializable {

	private static final long serialVersionUID = 3934573824890724536L;

	@Override
	public List<Object> getInterceptorsAndDynamicInterceptionAdvice(
			TargetClassAware config, Method method, Class<?> targetClass) {
		// TODO Auto-generated method stub
		return null;
	}

}

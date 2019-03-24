package com.iterlife.zeus.xspring.aop.proxy;
import org.aopalliance.aop.Advice;

import com.iterlife.zeus.xspring.aop.advisor.Advisor;

/** 定义AOP代理类工厂配置信息的类必须实现的接口 **/
public interface Advised extends TargetClassAware {

	boolean isFrozen();

	boolean isProxyTargetClass();

	Class<?>[] getProxiedInterfaces();

	boolean isInterfaceProxied(Class<?> inft);

	void setTargetSource(TargetSource targetSource);

	TargetSource getTargetSource();
	
	void setExposeProxy(boolean exposeProxy);

	boolean isExposeProxy();

	void setPreFiltered(Boolean preFiltered);

	boolean isPreFiltered();

	Advisor[] getAdvisors();

	void addAdvisor(Advisor advisor) throws AopConfigException;

	void addAdvisor(int pos, Advisor advisor) throws AopConfigException;

	boolean removeAdvisor(Advisor advisor);

	void removeAdvisor(int index) throws AopConfigException;

	boolean replaceAdvisor(Advisor a, Advisor b) throws AopConfigException;

	void addAdvice(Advice advice) throws AopConfigException;

	void addAdvice(int pos, Advice advice) throws AopConfigException;

	void removeAdvice(Advice advice);

	int indexof(Advice advice);

	String toProxyConfigString();

}

package com.iterlife.zeus.xspring.aop.advisor;

import java.io.Serializable;

import org.aopalliance.aop.Advice;

import com.iterlife.zeus.xspring.aop.pointcut.Pointcut;
import com.iterlife.zeus.xspring.aop.pointcut.StaticMethodMatcherPointcut;
import com.iterlife.zeus.xspring.core.Ordered;

public abstract class StaticMethodMatcherPointcutAdvisor extends
		StaticMethodMatcherPointcut implements PointcutAdvisor, Ordered,
		Serializable {
	private static final long serialVersionUID = -2952147246021515064L;

	private int order = Integer.MAX_VALUE;

	private Advice advice;

	public StaticMethodMatcherPointcutAdvisor() {

	}

	public StaticMethodMatcherPointcutAdvisor(Advice advice) {
		this.advice = advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	@Override
	public Advice getAdvice() {
		return this.advice;
	}

	public Pointcut getPointCut() {
		return this;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return this.order;
	}
}

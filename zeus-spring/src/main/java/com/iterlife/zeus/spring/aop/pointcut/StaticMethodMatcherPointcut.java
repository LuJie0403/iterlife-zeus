package com.iterlife.zeus.spring.aop.pointcut;

import com.iterlife.zeus.spring.aop.filter.ClassFilter;
import com.iterlife.zeus.spring.aop.matcher.MethodMatcher;
import com.iterlife.zeus.spring.aop.matcher.StaticMethodMatcher;

public abstract class StaticMethodMatcherPointcut extends StaticMethodMatcher
		implements Pointcut {

	private ClassFilter classFilter;

	public void setClassFilter(ClassFilter classFilter) {
		this.classFilter = classFilter;
	}

	public ClassFilter getClassFilter() {
		return this.classFilter;
	}

	@Override
	public MethodMatcher getMethodMatcher() {
		return this;
	}

}

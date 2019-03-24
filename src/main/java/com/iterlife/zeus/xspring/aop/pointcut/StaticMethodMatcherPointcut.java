package com.iterlife.zeus.xspring.aop.pointcut;

import com.iterlife.zeus.xspring.aop.filter.ClassFilter;
import com.iterlife.zeus.xspring.aop.matcher.MethodMatcher;
import com.iterlife.zeus.xspring.aop.matcher.StaticMethodMatcher;

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

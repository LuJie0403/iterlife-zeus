package com.iterlife.zeus.spring.aop.advice.ts;

import java.io.Serializable;

import com.iterlife.zeus.spring.aop.proxy.TargetSource;

public class EmptyTargetSource implements TargetSource, Serializable {

	private static final long serialVersionUID = -3343013689087596250L;

	public static final EmptyTargetSource INSTANCE = new EmptyTargetSource(null,
			true);

	private final Class<?> targetClass;
	private final boolean isStatic;

	public EmptyTargetSource(Class<?> targetClass, boolean isStatic) {
		this.targetClass = targetClass;
		this.isStatic = isStatic;
	}

	public static EmptyTargetSource forClass(Class<?> targetClass) {
		return forClass(targetClass, true);
	}

	public static EmptyTargetSource forClass(Class<?> targetClass,
			boolean isStatic) {
		return (targetClass == null && isStatic
				? INSTANCE
				: new EmptyTargetSource(targetClass, isStatic));
	}

	@Override
	public Class<?> getTargetClass() {
		return this.targetClass;
	}

	@Override
	public boolean isStatic() {
		return this.isStatic;
	}

	@Override
	public Object getTarget() throws Exception {
		return null;
	}

	@Override
	public void releaseTarget(Object target) throws Exception {

	}

	private Object readResolve() {
		return (this.targetClass == null && this.isStatic ? INSTANCE : this);
	}

	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof EmptyTargetSource))
			return false;
		EmptyTargetSource ets = (EmptyTargetSource) other;
		return (this.targetClass == ets.targetClass)
				&& (this.isStatic == ets.isStatic);
	}

	public int hashCode() {
		return EmptyTargetSource.class.hashCode();
	}

	public String toString() {
		return getClass().getName();
	}
}

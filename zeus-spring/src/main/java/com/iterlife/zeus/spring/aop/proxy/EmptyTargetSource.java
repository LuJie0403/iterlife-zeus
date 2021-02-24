package com.iterlife.zeus.spring.aop.proxy;

public class EmptyTargetSource implements TargetSource {

	public EmptyTargetSource() {

	}

	public EmptyTargetSource(Class<?> targetClass) {

	}

	@Override
	public Class<?> getTargetClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isStatic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getTarget() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void releaseTarget(Object target) throws Exception {
		// TODO Auto-generated method stub

	}

}

package com.iterlife.zeus.xspring.aop.advice;

import java.lang.reflect.Method;

/**
 *MethodAfterAdvice�ȼ���SpringԴ���е�AfterReturningAdvice 
 **/
public interface MethodAfterAdvice extends AfterAdvice {

    void afterReturning(Object returnValue, Method method, Object[] args, Object target)
                                                                                        throws Throwable;
}

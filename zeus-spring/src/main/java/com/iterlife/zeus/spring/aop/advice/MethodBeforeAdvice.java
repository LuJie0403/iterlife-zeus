package com.iterlife.zeus.spring.aop.advice;

import java.lang.reflect.Method;

public interface MethodBeforeAdvice extends BeforeAdvice {
    /**
     * @param Method:Ŀ�귽���ķ������
     * @param Object[] Ŀ�귽�������
     * @param target Ŀ�����
     * **/
    void before(Method method, Object[] args, Object target);
}

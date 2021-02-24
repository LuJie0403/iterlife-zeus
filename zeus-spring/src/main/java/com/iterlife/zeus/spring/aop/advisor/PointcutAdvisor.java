package com.iterlife.zeus.spring.aop.advisor;

import com.iterlife.zeus.spring.aop.pointcut.Pointcut;

public interface PointcutAdvisor extends Advisor {
    Pointcut getPointCut();
}

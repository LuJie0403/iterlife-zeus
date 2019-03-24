package com.iterlife.zeus.xspring.aop.advisor;

import com.iterlife.zeus.xspring.aop.pointcut.Pointcut;

public interface PointcutAdvisor extends Advisor {
    Pointcut getPointCut();
}

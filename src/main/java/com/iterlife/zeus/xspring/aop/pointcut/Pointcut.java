package com.iterlife.zeus.xspring.aop.pointcut;

import com.iterlife.zeus.xspring.aop.filter.ClassFilter;
import com.iterlife.zeus.xspring.aop.matcher.MethodMatcher;

public interface Pointcut {
    //target interface need to be weave(enhance)
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}

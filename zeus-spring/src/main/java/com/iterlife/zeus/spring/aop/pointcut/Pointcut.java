package com.iterlife.zeus.spring.aop.pointcut;

import com.iterlife.zeus.spring.aop.filter.ClassFilter;
import com.iterlife.zeus.spring.aop.matcher.MethodMatcher;

public interface Pointcut {
    //target interface need to be weave(enhance)
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}

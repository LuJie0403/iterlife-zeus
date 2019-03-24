package com.iterlife.zeus.xspring.aop.pointcut;

import java.util.regex.Pattern;

public class JdkRegexpMethodPointcut extends AbstractRegexpMethodPointcut {

    Pattern sPattern;
    Pattern cPattern;

    public void initPatterns(String sPattern, String cPattern) {
        this.sPattern = compilePattern(sPattern);
        this.cPattern = compilePattern(cPattern);
    }

    protected boolean sMatches(String pattern) {
        return this.sPattern.matcher(pattern).matches();
    }

    protected boolean cMatches(String pattern) {
        return this.cPattern.matcher(pattern).matches();
    }

    public Pattern compilePattern(String source) {
        return Pattern.compile(source);
    }
}

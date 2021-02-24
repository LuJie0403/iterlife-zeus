package com.iterlife.zeus.spring.exception;
public class NoSuchBeanDefinitionException extends BeanException {

    private static final long serialVersionUID = -3508763662969080979L;

    private String            beanName;
    private Class<?>             beanType;

    public NoSuchBeanDefinitionException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public NoSuchBeanDefinitionException(String beanName) {
        super("No unique bean of name [" + beanName + "] is defined");
        this.beanName = beanName;
    }

    public NoSuchBeanDefinitionException(Class<?> beanType) {
        super("No unique bean of type [" + beanType.getName() + "] is defined");
        this.beanType = beanType;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class<?> getBeanType() {
        return beanType;
    }

    public void setBeanType(Class<?> beanType) {
        this.beanType = beanType;
    }
}

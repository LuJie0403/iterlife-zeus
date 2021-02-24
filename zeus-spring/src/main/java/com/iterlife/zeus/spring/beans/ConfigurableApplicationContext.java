package com.iterlife.zeus.spring.beans;

import com.iterlife.zeus.spring.beans.config.BeanFactoryPostProcessor;
import com.iterlife.zeus.spring.context.ApplicationListener;
import com.iterlife.zeus.spring.exception.BeanException;

public interface ConfigurableApplicationContext extends ApplicationContext {
    void setId(String id);

    void setParent(ApplicationContext parent);

    void addBeanFactoryPostProcessor(BeanFactoryPostProcessor processor);

    void addApplicationListener(ApplicationListener listener);

    void refresh() throws BeanException, IllegalStateException;

    void close();

    boolean isActive();
}

package com.iterlife.zeus.xspring.beans;

import com.iterlife.zeus.xspring.beans.config.BeanFactoryPostProcessor;
import com.iterlife.zeus.xspring.context.ApplicationListener;
import com.iterlife.zeus.xspring.exception.BeanException;

public interface ConfigurableApplicationContext extends ApplicationContext {
    void setId(String id);

    void setParent(ApplicationContext parent);

    void addBeanFactoryPostProcessor(BeanFactoryPostProcessor processor);

    void addApplicationListener(ApplicationListener listener);

    void refresh() throws BeanException, IllegalStateException;

    void close();

    boolean isActive();
}

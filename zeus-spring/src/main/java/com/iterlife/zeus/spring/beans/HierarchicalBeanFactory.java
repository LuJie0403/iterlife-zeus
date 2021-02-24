package com.iterlife.zeus.spring.beans;

public interface HierarchicalBeanFactory extends BeanFactory {

    /**��ȡ��BeanFactory**/
    BeanFactory getParentFactory();
}

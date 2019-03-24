package com.iterlife.zeus.xspring.beans;

public interface HierarchicalBeanFactory extends BeanFactory {

    /**��ȡ��BeanFactory**/
    BeanFactory getParentFactory();
}

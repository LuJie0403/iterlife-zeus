package com.iterlife.zeus.xspring.beans;

import com.iterlife.zeus.xspring.beans.config.BeanPostProcessor;
import com.iterlife.zeus.xspring.exception.NoSuchBeanDefinitionException;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {
    public final static String SCOPE_SINGLETON = "signleton";
    public final static String SCOPE_PROTOTYPE = "prototype";

    void setParentBeanFactory(BeanFactory beanFactory);

    void setBeanClassLoader(ClassLoader classLoader);

    ClassLoader getBeanClassLoader();

    /**�Ȳ���Ŀ���**/
    void setCacheBeanMetadata(boolean cacheBeanMetadata);

    boolean isCacheBeanMetadata();

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    int getBeanPostProcessorCount();

    boolean isFactoryBean() throws NoSuchBeanDefinitionException;

    void registerDependentBean(String beanName, String dependentBeanName);

    String getDependentBeans(String beanName);

    String getDependenciesForBean(String beanName);

    void destroyBean(String beanName, Object beanInstance);

    /**���ٵ�ǰ������Χ��ָ��beanName��Bean**/
    void destroyScopeBean(String beanName);

    void destroySingleton();

}

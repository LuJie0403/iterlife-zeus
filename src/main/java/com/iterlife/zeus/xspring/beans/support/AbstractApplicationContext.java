package com.iterlife.zeus.xspring.beans.support;

import java.io.IOException;

import com.iterlife.zeus.xspring.beans.ApplicationContext;
import com.iterlife.zeus.xspring.beans.BeanFactory;
import com.iterlife.zeus.xspring.beans.ConfigurableApplicationContext;
import com.iterlife.zeus.xspring.beans.DisposableBean;
import com.iterlife.zeus.xspring.beans.config.BeanFactoryPostProcessor;
import com.iterlife.zeus.xspring.context.ApplicationEvent;
import com.iterlife.zeus.xspring.core.DefaultResourceLoader;
import com.iterlife.zeus.xspring.core.Resource;
import com.iterlife.zeus.xspring.exception.BeanException;
import com.iterlife.zeus.xspring.exception.NoSuchBeanDefinitionException;

public abstract class AbstractApplicationContext extends DefaultResourceLoader
                                                                              implements
                                                                              ConfigurableApplicationContext,
                                                                              DisposableBean {
    private ApplicationContext parent;
    //�����ļ���ַ��������web.xml��
    private String[]           configLocations;

    public AbstractApplicationContext() {

    }

    public AbstractApplicationContext(ApplicationContext parent) {
        this.parent = parent;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDisplayName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getStartupDate() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ApplicationContext getParentApplicationContext() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setParentBeanFactory(BeanFactory beanFactory) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        // TODO Auto-generated method stub

    }

    @Override
    public ClassLoader getBeanClassLoader() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCacheBeanMetadata(boolean cacheBeanMetadata) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isCacheBeanMetadata() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getBeanPostProcessorCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isFactoryBean() throws NoSuchBeanDefinitionException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void registerDependentBean(String beanName, String dependentBeanName) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getDependentBeans(String beanName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDependenciesForBean(String beanName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void destroyBean(String beanName, Object beanInstance) {
        // TODO Auto-generated method stub

    }

    @Override
    public void destroyScopeBean(String beanName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void destroySingleton() {
        // TODO Auto-generated method stub

    }

    @Override
    public BeanFactory getParentFactory() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getBean(String beanKey) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getBeanByName(String beanName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getBeanById(String beanId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getBeanByAlias(String[] beanAlias) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T getBean(String beanName, Class<T> requiredType) throws BeanException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean containBean(String beanName) throws NoSuchBeanDefinitionException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isSingleton(String beanName) throws NoSuchBeanDefinitionException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isProtoType(String beanName) throws NoSuchBeanDefinitionException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isTypeMatched(String beanName, Class<?> beanType)
                                                                 throws NoSuchBeanDefinitionException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getBeanType(String beanName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String[] getBeanAlias(String beanName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String[] getCodes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String[] getArguments() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDefaultMessage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void publishEvent(ApplicationEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public Resource[] getResources(String locationPattern) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Resource getResource(String location) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setId(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setParent(ApplicationContext parent) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addBeanFactoryPostProcessor(BeanFactoryPostProcessor processor) {
        // TODO Auto-generated method stub

    }


    @Override
    public void refresh() throws BeanException, IllegalStateException {
        // TODO Auto-generated method stub

    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    public void setConfigLocations(String[] locations) {
        if (locations != null) {
            this.configLocations = new String[locations.length];
            for (int i = 0; i < locations.length; ++i) {
                //�˴�Ӧ�ý���·����ַ�Ľ�������ͬ�Ĳ���ϵͳ���ַ�ı�ʾ���������
                this.configLocations[i] = locations[i];
            }
        } else {
            this.configLocations = locations;
        }
    }

    public String[] getConfigLocations() {
        return this.configLocations;
    }

    @Override
    public boolean isActive() {
        // TODO Auto-generated method stub
        return false;
    }

    public ApplicationContext getParent() {
        return parent;
    }

    @Override
    public void destroy() throws Exception {
        // TODO Auto-generated method stub

    }
}

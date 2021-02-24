package com.iterlife.zeus.spring.beans.support;

import com.iterlife.zeus.spring.beans.BeanFactory;
import com.iterlife.zeus.spring.beans.ConfigurableBeanFactory;
import com.iterlife.zeus.spring.beans.config.BeanPostProcessor;
import com.iterlife.zeus.spring.beans.util.BeanFactoryUtils;
import com.iterlife.zeus.spring.exception.BeanException;
import com.iterlife.zeus.spring.exception.NoSuchBeanDefinitionException;
import com.iterlife.zeus.spring.util.ClassUtils;

@SuppressWarnings("unused")
public abstract class AbstractBeanFactory implements ConfigurableBeanFactory {

	private BeanFactory parentBeanFactory;

	private ClassLoader beanClassLoader = ClassUtils.getClassLoader();
	private boolean cacheBeanMetadata = true;

	public AbstractBeanFactory() {

	}

	public AbstractBeanFactory(BeanFactory parentBeanFactory) {
		this.parentBeanFactory = parentBeanFactory;
	}

	@SuppressWarnings("unchecked")
	protected <T> T doGetBean(final String name, final Class<T> requiredType,
			final Object[] args, boolean typeCheckOnly) {
		// ͨ���˷������˺��BeanNameֻ�ܻ�ȡFactoryBean�����Ķ��󣬶��޷���ȡFactoryBean����
		String beanName = BeanFactoryUtils.transformedBeanName(name);
		Object bean = null;

		return (T) bean;
	}

	@Override
	public BeanFactory getParentFactory() {
		return this.parentBeanFactory;
	}

	@Override
	public Object getBean(String beanKey) {
		Object bean = getBeanByName(beanKey);
		if (bean == null) {
			bean = getBeanById(beanKey);
		}
		if (bean == null) {
			bean = getBeanByAlias(new String[] { beanKey });
		}
		if (bean == null) {
		}
		return bean;
	}

	@Override
	public Object getBeanByName(String beanName) {
		return doGetBean(beanName, null, null, false);
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
	public <T> T getBean(String beanName, Class<T> requiredType)
			throws BeanException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containBean(String beanName)
			throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSingleton(String beanName)
			throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProtoType(String beanName)
			throws NoSuchBeanDefinitionException {
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
	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
		// TODO Auto-generated method stub

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

}

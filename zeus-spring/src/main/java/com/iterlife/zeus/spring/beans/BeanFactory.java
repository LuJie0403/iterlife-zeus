/**
 * 
 */
package com.iterlife.zeus.spring.beans;

import com.iterlife.zeus.spring.exception.BeanException;
import com.iterlife.zeus.spring.exception.NoSuchBeanDefinitionException;

/**
 * @description Spring���������ӿ�
 * @author jie.lu
 */
public interface BeanFactory {
	/**
	 * ͨ��ΪbeanName���ǰ��ת���"&"�õ�FactoryBean����,����ʹ��beanName�õ�����FactoryBean�����Ķ���
	 **/
	String FACTORY_BEAN_PREFIX = "&";

	/**
	 * ͨ��Bean��ʶ(beanKey)��ȡBean����,beanKey����beanName,beanId,beanAlia(���մ˹̶����ȼ�)
	 **/
	Object getBean(String beanKey);

	Object getBeanByName(String beanName);

	Object getBeanById(String beanId);

	Object getBeanByAlias(String[] beanAlias);

	/**
	 * ��ȡָ�����ơ�ָ�����͵�Bean
	 **/
	<T> T getBean(String beanName, Class<T> requiredType) throws BeanException;

	/** �Ƿ����ָ�����Ƶ�Bean **/
	boolean containBean(String beanName) throws NoSuchBeanDefinitionException;

	/** ָ�����Ƶ�Bean�Ƿ�ΪSingleton **/
	boolean isSingleton(String beanName) throws NoSuchBeanDefinitionException;

	/** ָ�����Ƶ�Bean�Ƿ�ΪProtoType **/
	boolean isProtoType(String beanName) throws NoSuchBeanDefinitionException;

	boolean isTypeMatched(String beanName, Class<?> beanType)
			throws NoSuchBeanDefinitionException;

	/** ��ȡָ������Bean������beanType. **/
	String getBeanType(String beanName);

	/** ��ȡָ������Bean�ı���BeanAlias **/
	String[] getBeanAlias(String beanName);
}

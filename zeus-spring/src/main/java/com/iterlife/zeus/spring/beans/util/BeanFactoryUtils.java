package com.iterlife.zeus.spring.beans.util;

import com.iterlife.zeus.spring.beans.BeanFactory;

public class BeanFactoryUtils {
	public static String transformedBeanName(String name) {
		String beanName = name;
		while (beanName.startsWith(BeanFactory.FACTORY_BEAN_PREFIX)) {
			beanName = beanName
					.substring(BeanFactory.FACTORY_BEAN_PREFIX.length());
		}
		return beanName;
	}
}

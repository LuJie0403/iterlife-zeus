package com.iterlife.zeus.spring.beans;

import com.iterlife.zeus.spring.context.ApplicationEventPublisher;
import com.iterlife.zeus.spring.context.MessageSourceResolvable;
import com.iterlife.zeus.spring.core.ResourcePatternResolver;

public interface ApplicationContext
		extends
			ConfigurableBeanFactory,
			MessageSourceResolvable,
			ApplicationEventPublisher,
			ResourcePatternResolver {

	/** Application��Ψһ��ʶ **/
	String getId();

	String getDisplayName();

	/** ��ȡ����ʱ���ʱ��� **/
	long getStartupDate();

	ApplicationContext getParentApplicationContext();
}

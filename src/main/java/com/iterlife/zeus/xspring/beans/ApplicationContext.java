package com.iterlife.zeus.xspring.beans;

import com.iterlife.zeus.xspring.context.ApplicationEventPublisher;
import com.iterlife.zeus.xspring.context.MessageSourceResolvable;
import com.iterlife.zeus.xspring.core.ResourcePatternResolver;

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

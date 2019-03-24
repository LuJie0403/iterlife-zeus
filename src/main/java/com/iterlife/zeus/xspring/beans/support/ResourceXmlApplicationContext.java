package com.iterlife.zeus.xspring.beans.support;

import com.iterlife.zeus.xspring.beans.config.BeanPostProcessor;
import com.iterlife.zeus.xspring.context.ApplicationListener;

public class ResourceXmlApplicationContext extends AbstractApplicationContext {

    @Override
    public void destroy() throws Exception {
        // TODO Auto-generated method stub
        
    }

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.beans.ConfigurableApplicationContext#addApplicationListener(com.iterlife.zeus.xspring.context.ApplicationListener)
	 */
	@Override
	public void addApplicationListener(ApplicationListener listener) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.beans.ConfigurableBeanFactory#addBeanPostProcessor(com.iterlife.zeus.xspring.beans.config.BeanPostProcessor)
	 */
	@Override
	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
		// TODO Auto-generated method stub
		
	}

}

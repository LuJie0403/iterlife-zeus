package com.iterlife.zeus.spring.beans.support;

/**
 *一锟街简单碉拷ApplicationContext实锟斤拷 
 * 
 **/
import com.iterlife.zeus.spring.beans.ApplicationContext;
import com.iterlife.zeus.spring.beans.config.BeanPostProcessor;
import com.iterlife.zeus.spring.context.ApplicationListener;
import com.iterlife.zeus.spring.core.FileSystemResource;
import com.iterlife.zeus.spring.core.Resource;

public class FileSystemXmlApplicationContext
		extends
			AbstractApplicationContext {

	public FileSystemXmlApplicationContext() {
		// TODO Auto-generated constructor stub
	}

	public FileSystemXmlApplicationContext(ApplicationContext parent) {
		super(parent);
	}

	public FileSystemXmlApplicationContext(String configLocations) {
		this(new String[]{configLocations}, true, null);
	}

	public FileSystemXmlApplicationContext(String... configLocations) {
		this(configLocations, true, null);
	}

	public FileSystemXmlApplicationContext(String[] configLocations,
			ApplicationContext parent) {
		this(configLocations, true, parent);
	}

	public FileSystemXmlApplicationContext(String[] configLocations,
			boolean refresh) {
		this(configLocations, refresh, null);
	}

	public FileSystemXmlApplicationContext(String[] configLocations,
			boolean refresh, ApplicationContext parent) {
		super(parent);
		setConfigLocations(configLocations);
		if (refresh) {
			// 锟斤拷锟斤拷IoC锟斤拷锟斤拷锟斤拷锟斤拷诜锟斤拷锟�
			refresh();
		}
	}

	@Override
	public Resource getResource(String path) {
		if (path != null && path.startsWith("/")) {
			path = path.substring(1);
		}
		return new FileSystemResource(path);
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

/**
 *
 * @project iterlife-xspring
 * @file com.iterlife.xspring.servlet.XServletContextListener.java
 * @version 1.0.0
 * Copyright 2019 - 2019 for Lu Jie
 * https://www.iterlife.com
 *
 **/
package com.iterlife.zeus.spring.servlet;


/**
 *
 * @desc
 * @author Lu Jie
 * @date 2019 2019年2月6日 下午1:04:40
 * @tags
 */
public interface XServletContextListener {
	/**
	 ** Notification that the web application initialization process is starting.
	 * All ServletContextListeners are notified of context initialization before
	 * any filter or servlet in the web application is initialized.
	 */
	public void contextInitialized(XServletContextEvent sce);

	/**
	 ** Notification that the servlet context is about to be shut down. All
	 * servlets and filters have been destroy()ed before any
	 * ServletContextListeners are notified of context destruction.
	 */
	public void contextDestroyed(XServletContextEvent sce);
}

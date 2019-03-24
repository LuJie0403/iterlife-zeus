/**
 *
 * @project iterlife-xspring
 * @file com.iterlife.xspring.servlet.XServletContextEvent.java
 * @version 1.0.0
 * Copyright 2019 - 2019 for Lu Jie
 * https://www.iterlife.com
 *
 **/
package com.iterlife.zeus.xspring.servlet;

import java.util.EventObject;

/**
 *
 * @desc
 * @author Lu Jie
 * @date 2019 2019年2月6日 下午1:02:32
 * @tags
 */
public class XServletContextEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5882511221050123953L;
	/**
	 * 
	 */

	/**
	 * @param source
	 */
	public XServletContextEvent(XServletContext source) {
		super(source);
	}


	/**
	 * Return the ServletContext that changed.
	 *
	 * @return the ServletContext that sent the event.
	 */
	public XServletContext getServletContext() {
		return (XServletContext) super.getSource();
	}

}

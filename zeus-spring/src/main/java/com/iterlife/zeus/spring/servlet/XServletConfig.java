/**
 *
 * @project iterlife-xspring
 * @file com.iterlife.xspring.servlet.XServletConfig.java
 * @version 1.0.0
 * Copyright 2019 - 2019 for Lu Jie
 * https://www.iterlife.com
 *
 **/
package com.iterlife.zeus.spring.servlet;

import java.util.Enumeration;

/**
 *
 * @desc
 * @author Lu Jie
 * @date 2019 2019年2月6日 下午12:20:28
 * @tags
 */
public interface XServletConfig {

	/**
	 * Returns the name of this servlet instance. The name may be provided via
	 * server administration, assigned in the web application deployment
	 * descriptor, or for an unregistered (and thus unnamed) servlet instance it
	 * will be the servlet's class name.
	 *
	 * @return the name of the servlet instance
	 *
	 *
	 *
	 */

	public String getServletName();

	/**
	 * Returns a reference to the {@link ServletContext} in which the caller is
	 * executing.
	 *
	 *
	 * @return a {@link ServletContext} object, used by the caller to interact
	 *         with its servlet container
	 * 
	 * @see ServletContext
	 *
	 */

	public XServletContext getServletContext();

	/**
	 * Returns a <code>String</code> containing the value of the named
	 * initialization parameter, or <code>null</code> if the parameter does not
	 * exist.
	 *
	 * @param name
	 *            a <code>String</code> specifying the name of the
	 *            initialization parameter
	 *
	 * @return a <code>String</code> containing the value of the initialization
	 *         parameter
	 *
	 */

	public String getInitParameter(String name);

	/**
	 * Returns the names of the servlet's initialization parameters as an
	 * <code>Enumeration</code> of <code>String</code> objects, or an empty
	 * <code>Enumeration</code> if the servlet has no initialization parameters.
	 *
	 * @return an <code>Enumeration</code> of <code>String</code> objects
	 *         containing the names of the servlet's initialization parameters
	 *
	 *
	 *
	 */

	public Enumeration<?> getInitParameterNames();

}

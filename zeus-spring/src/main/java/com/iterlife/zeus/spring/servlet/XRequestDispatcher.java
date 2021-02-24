/**
 *
 * @project iterlife-xspring
 * @file com.iterlife.xspring.servlet.XRequestDispatcher.java
 * @version 1.0.0
 * Copyright 2019 - 2019 for Lu Jie
 * https://www.iterlife.com
 *
 **/
package com.iterlife.zeus.spring.servlet;

import java.io.IOException;

/**
 *
 * @desc
 * @author Lu Jie
 * @date 2019 2019年2月6日 下午12:03:19
 * @tags
 */
public interface XRequestDispatcher {
	public void forward(XServletRequest request, XServletResponse response)
			throws XServletException, IOException;

	public void include(XServletRequest request, XServletResponse response)
			throws XServletException, IOException;
}

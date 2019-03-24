/**
 *
 * @project iterlife-xspring
 * @file com.iterlife.xspring.servlet.XServletRequestWrapper.java
 * @version 1.0.0
 * Copyright 2019 - 2019 for Lu Jie
 * https://www.iterlife.com
 *
 **/
package com.iterlife.zeus.xspring.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @desc
 * @author Lu Jie
 * @date 2019 2019年2月6日 下午1:17:29
 * @tags
 */
public class XServletRequestWrapper {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getLocales()
	 */
	public Enumeration<?> getLocales() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getRealPath(java.lang.String)
	 */
	public String getRealPath(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iterlife.xspring.servlet.XServletRequest#getAttribute(java.lang.String
	 * )
	 */
	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getAttributeNames()
	 */
	public Enumeration<?> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getCharacterEncoding()
	 */
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iterlife.xspring.servlet.XServletRequest#setCharacterEncoding(java
	 * .lang.String)
	 */
	public void setCharacterEncoding(String env)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getContentLength()
	 */
	public int getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getContentType()
	 */

	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getInputStream()
	 */
	public XServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iterlife.xspring.servlet.XServletRequest#getParameter(java.lang.String
	 * )
	 */

	public String getParameter(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getParameterNames()
	 */

	public Enumeration<?> getParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iterlife.xspring.servlet.XServletRequest#getParameterValues(java.
	 * lang.String)
	 */

	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getParameterMap()
	 */

	public Map<?, ?> getParameterMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getProtocol()
	 */

	public String getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getScheme()
	 */

	public String getScheme() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getServerName()
	 */

	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getServerPort()
	 */

	public int getServerPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getReader()
	 */

	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getRemoteAddr()
	 */

	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getRemoteHost()
	 */

	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iterlife.xspring.servlet.XServletRequest#setAttribute(java.lang.String
	 * , java.lang.Object)
	 */

	public void setAttribute(String name, Object o) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iterlife.xspring.servlet.XServletRequest#removeAttribute(java.lang
	 * .String)
	 */

	public void removeAttribute(String name) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getLocale()
	 */

	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#isSecure()
	 */

	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.iterlife.xspring.servlet.XServletRequest#getRequestDispatcher(java
	 * .lang.String)
	 */

	public XRequestDispatcher getRequestDispatcher(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getRemotePort()
	 */

	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getLocalName()
	 */

	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getLocalAddr()
	 */

	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.iterlife.xspring.servlet.XServletRequest#getLocalPort()
	 */

	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}

}

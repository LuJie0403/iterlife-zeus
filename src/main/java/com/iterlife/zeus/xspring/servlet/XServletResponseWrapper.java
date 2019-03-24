/**
 *
 * @project iterlife-xspring
 * @file com.iterlife.xspring.servlet.XServletResponseWrapper.java
 * @version 1.0.0
 * Copyright 2019 - 2019 for Lu Jie
 * https://www.iterlife.com
 *
 **/
package com.iterlife.zeus.xspring.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 *
 * @desc 
 * @author Lu Jie
 * @date 2019 2019年2月6日 下午1:18:31
 * @tags 
 */
public class XServletResponseWrapper implements XServletResponse {

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#getCharacterEncoding()
	 */
	
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#getContentType()
	 */
	
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#getOutputStream()
	 */
	
	public XServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#getWriter()
	 */
	
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#setCharacterEncoding(java.lang.String)
	 */
	
	public void setCharacterEncoding(String charset) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#setContentLength(int)
	 */
	
	public void setContentLength(int len) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#setContentType(java.lang.String)
	 */
	
	public void setContentType(String type) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#setBufferSize(int)
	 */
	
	public void setBufferSize(int size) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#getBufferSize()
	 */
	
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#flushBuffer()
	 */
	
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#resetBuffer()
	 */
	
	public void resetBuffer() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#isCommitted()
	 */
	
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#reset()
	 */
	
	public void reset() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#setLocale(java.util.Locale)
	 */
	
	public void setLocale(Locale loc) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.iterlife.xspring.servlet.XServletResponse#getLocale()
	 */
	
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

}

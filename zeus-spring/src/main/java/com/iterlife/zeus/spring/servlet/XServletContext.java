/**
 * 
 */
package com.iterlife.zeus.spring.servlet;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

/**
 * A context set defined by Web server container,it was initialized when Web
 * server starts to provides a servlet.
 * 
 * @author Lu Jie
 *
 */
public interface XServletContext {
	public String getContextPath();

	public XServletContext getContext(String uripath);

	public int getMajorVersion();

	public int getMinorVersion();

	public String getMimeType(String file);

	public Set<String> getResourcePaths(String path);

	public URL getResource(String path) throws MalformedURLException;

	public InputStream getResourceAsStream(String path);

	public XRequestDispatcher getRequestDispatcher(String path);

	public XRequestDispatcher getNamedDispatcher(String name);

	public void log(String msg);

	public void log(String message, Throwable throwable);

	public String getRealPath(String path);

	public String getServerInfo();

	public String getInitParameter(String name);

	public Enumeration<?> getInitParameterNames();

	public Object getAttribute(String name);

	public Enumeration<?> getAttributeNames();

	public void setAttribute(String name, Object object);

	public void removeAttribute(String name);

	public String getServletContextName();
}

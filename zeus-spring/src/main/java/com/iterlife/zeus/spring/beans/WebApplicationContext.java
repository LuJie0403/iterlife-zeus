package com.iterlife.zeus.spring.beans;

import javax.servlet.ServletContext;

public interface WebApplicationContext extends ApplicationContext {
    String ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE = WebApplicationContext.class.getName() + ".ROOT";

    String SCOPE_REQUEST                          = "request";
    String SCOPE_SESSION                          = "session";
    String SCOPER_GLOBAL_SESSION                  = "globalSession";
    String SCOPER_APPLICATION                     = "application";
    String SERVLET_CONTEXT_BEAN_NAME              = "servletContext";
    String CONTEXT_PARAMETERS_BEAN_NAME           = "contextParameters";
    String CONTEXT_ATTRIBUTE_BEAN_NAME            = "contextAttribute";

    ServletContext getServletContext();
}

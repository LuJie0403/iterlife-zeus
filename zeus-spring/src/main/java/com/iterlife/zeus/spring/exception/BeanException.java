package com.iterlife.zeus.spring.exception;

/**
 * IoC��������Bean����ʱException�������
 **/
public class BeanException extends XSpringRuntimeException {

	private static final long serialVersionUID = -6579211116513978966L;

	public BeanException(String msg) {
		super(msg);
	}

	public BeanException(String msg, Throwable cause) {
		super(msg, cause);
	}

}

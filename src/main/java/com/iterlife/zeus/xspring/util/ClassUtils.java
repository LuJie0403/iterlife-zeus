package com.iterlife.zeus.xspring.util;

public abstract class ClassUtils {

	public static ClassLoader getClassLoader() {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread().getContextClassLoader();
		} catch (Throwable ex) {
		} finally {
			if (cl == null) {
				cl = ClassUtils.class.getClassLoader();
			}
		}
		return cl;
	}
}

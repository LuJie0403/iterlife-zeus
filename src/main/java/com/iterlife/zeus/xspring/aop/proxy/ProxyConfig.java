package com.iterlife.zeus.xspring.aop.proxy;
import java.io.Serializable;

/**
 * 创建代理对象的配置类
 **/
public class ProxyConfig implements Serializable {

	private static final long serialVersionUID = -3253138265860336478L;

	/**
	 * 是否可以 代理目标类(class)，默认false false:使用JDK动态代理进行指定接口(interface)的代理实现
	 * true:使用CGLIB代理进行指定类(class)的代理实现
	 **/
	private boolean proxyTargetClass = false;
	/**
	 * 是否需要对代理对象进行优化
	 **/
	private boolean optimize = false;

	/**
	 * 通过当前配置生成的代理对象是否可以转换为Advisor
	 **/
	boolean opaque = false;

	/**
	 * 代理对象是否可以通过暴漏给AOP框架进而被纳入框架统一的回收机制
	 **/
	boolean exposeProxy = false;

	/**
	 * 当前类是否被冻结，优化时使用
	 **/
	private boolean frozen = false;

	public boolean isProxyTargetClass() {
		return proxyTargetClass;
	}

	public void setProxyTargetClass(boolean proxyTargetClass) {
		this.proxyTargetClass = proxyTargetClass;
	}

	public boolean isOptimize() {
		return optimize;
	}

	public void setOptimize(boolean optimize) {
		this.optimize = optimize;
	}

	public boolean isOpaque() {
		return opaque;
	}

	public void setOpaque(boolean opaque) {
		this.opaque = opaque;
	}

	public boolean isExposeProxy() {
		return exposeProxy;
	}

	public void setExposeProxy(boolean exposeProxy) {
		this.exposeProxy = exposeProxy;
	}

	public boolean isFrozen() {
		return frozen;
	}

	public void setFrozen(boolean frozen) {
		this.frozen = frozen;
	}

	public void copyFrom(ProxyConfig other) {
		this.setProxyTargetClass(other.isProxyTargetClass());
		this.setFrozen(other.isFrozen());
		this.setOpaque(other.isOpaque());
		this.setOptimize(other.isOptimize());
		this.setExposeProxy(other.isExposeProxy());
	}
}

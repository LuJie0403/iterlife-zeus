package com.iterlife.zeus.xspring.aop.proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.aopalliance.aop.Advice;

import com.iterlife.zeus.xspring.aop.advisor.Advisor;

public class AdvisedSupport<MethodCacheKey> extends ProxyConfig implements Advised {

	private static final long serialVersionUID = 1L;

	TargetSource targetSource = new EmptyTargetSource();

	private boolean preFiltered = false;

	AdvisorChainFactory advisorChainFactory = new DefaultAdvisorChainFactory();

	private transient Map<MethodCacheKey, List<Object>> methodCache;

	private List<Class<?>> interfaces = new ArrayList<Class<?>>();

	public AdvisedSupport() {
		this.methodCache = new ConcurrentHashMap<MethodCacheKey, List<Object>>(
				32);
	}

	public AdvisedSupport(Class<?>[] interfaces) {
		this();
		setInterfaces(interfaces);
	}

	public void setTarget(Object target) {
		setTargetSource(new SingletonTargetSource(target));
	}

	@Override
	public void setTargetSource(TargetSource targetSource) {
		this.targetSource = targetSource;
	}

	@Override
	public TargetSource getTargetSource() {
		return this.targetSource;
	}

	public void setTargetSource(Class<?> targetClass) {
		this.targetSource = new EmptyTargetSource(targetClass);
	}

	/*
	 * public Class<?> getTargetClass() { return
	 * this.targetSource.getTargetClass(); }
	 */

	@Override
	public Class<?>[] getProxiedInterfaces() {
		return this.interfaces.toArray(new Class[this.interfaces.size()]);
	}

	@Override
	public boolean isInterfaceProxied(Class<?> inft) {
		for (Class<?> proxyIntf : this.interfaces) {
			if (inft.isAssignableFrom(proxyIntf)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void setPreFiltered(Boolean preFiltered) {
		this.preFiltered = preFiltered;

	}

	@Override
	public boolean isPreFiltered() {
		return this.preFiltered;
	}

	public AdvisorChainFactory getAdvisorChainFactory() {
		return advisorChainFactory;
	}

	public void setAdvisorChainFactory(
			AdvisorChainFactory advisorChainFactory) {
		this.advisorChainFactory = advisorChainFactory;
	}

	public void setInterfaces(Class<?>[] interfaces) {
		for (Class<?> intf : interfaces) {
			addInterface(intf);
		}
	}

	public void addInterface(Class<?> intf) {
		if (!intf.isInterface()) {
			throw new IllegalArgumentException(
					"[" + intf.getName() + "] is not an interface");
		}
		if (!this.interfaces.contains(intf)) {
			this.interfaces.add(intf);
			this.methodCache.clear();
		}
	}

	public boolean removeInterface(Class<?> intf) {
		return this.interfaces.remove(intf);
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.aop.proxy.TargetClassAware#getTargetClass()
	 */
	@Override
	public Class<?> getTargetClass() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.aop.proxy.Advised#getAdvisors()
	 */
	@Override
	public Advisor[] getAdvisors() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.aop.proxy.Advised#addAdvisor(com.iterlife.zeus.xspring.aop.advisor.Advisor)
	 */
	@Override
	public void addAdvisor(Advisor advisor) throws AopConfigException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.aop.proxy.Advised#addAdvisor(int, com.iterlife.zeus.xspring.aop.advisor.Advisor)
	 */
	@Override
	public void addAdvisor(int pos, Advisor advisor) throws AopConfigException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.aop.proxy.Advised#removeAdvisor(com.iterlife.zeus.xspring.aop.advisor.Advisor)
	 */
	@Override
	public boolean removeAdvisor(Advisor advisor) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.aop.proxy.Advised#removeAdvisor(int)
	 */
	@Override
	public void removeAdvisor(int index) throws AopConfigException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.aop.proxy.Advised#replaceAdvisor(com.iterlife.zeus.xspring.aop.advisor.Advisor, com.iterlife.zeus.xspring.aop.advisor.Advisor)
	 */
	@Override
	public boolean replaceAdvisor(Advisor a, Advisor b)
			throws AopConfigException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.aop.proxy.Advised#addAdvice(org.aopalliance.aop.Advice)
	 */
	@Override
	public void addAdvice(Advice advice) throws AopConfigException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.aop.proxy.Advised#addAdvice(int, org.aopalliance.aop.Advice)
	 */
	@Override
	public void addAdvice(int pos, Advice advice) throws AopConfigException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.aop.proxy.Advised#removeAdvice(org.aopalliance.aop.Advice)
	 */
	@Override
	public void removeAdvice(Advice advice) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.aop.proxy.Advised#indexof(org.aopalliance.aop.Advice)
	 */
	@Override
	public int indexof(Advice advice) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.iterlife.zeus.xspring.aop.proxy.Advised#toProxyConfigString()
	 */
	@Override
	public String toProxyConfigString() {
		// TODO Auto-generated method stub
		return null;
	}

}

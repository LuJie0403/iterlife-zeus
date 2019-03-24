package com.iterlife.zeus.xspring.aop.advisor;

import java.io.Serializable;

import com.iterlife.zeus.xspring.core.Ordered;

public abstract class AbstractPointcutAdvisor
		implements
			PointcutAdvisor,
			Ordered,
			Serializable {

	private static final long serialVersionUID = 539473043194434792L;
	private Integer order;

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return this.order;
	}
}

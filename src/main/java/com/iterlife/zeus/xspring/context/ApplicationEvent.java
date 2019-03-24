package com.iterlife.zeus.xspring.context;

import java.util.EventObject;

public abstract class ApplicationEvent extends EventObject {
	private final long timestamp;

	public ApplicationEvent(Object source) {
		super(source);
		this.timestamp = System.currentTimeMillis();
	}

	private static final long serialVersionUID = -4135153826258898288L;

	public final long getTimestamp() {
		return this.timestamp;
	}
}

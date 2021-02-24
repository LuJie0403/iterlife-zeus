package com.iterlife.zeus.spring.exception;

public abstract class XSpringRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1167447242014664442L;

    public XSpringRuntimeException(String msg) {
        super(msg);
    }

    public XSpringRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

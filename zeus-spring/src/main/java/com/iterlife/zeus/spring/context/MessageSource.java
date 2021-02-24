package com.iterlife.zeus.spring.context;

import java.util.Locale;

public interface MessageSource {

    String getMessage(String code, Object[] args, String defaultMessage, Locale locale);

    String getMessage(String code, Object[] args, Locale locale);

    String getMessage(MessageSourceResolvable resolver, Locale locale);
}

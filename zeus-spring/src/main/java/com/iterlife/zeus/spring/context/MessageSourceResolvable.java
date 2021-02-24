package com.iterlife.zeus.spring.context;

public interface MessageSourceResolvable {

    String[] getCodes();

    String[] getArguments();

    String getDefaultMessage();
}

package com.iterlife.zeus.xspring.context;

public interface MessageSourceResolvable {

    String[] getCodes();

    String[] getArguments();

    String getDefaultMessage();
}

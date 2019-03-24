package com.iterlife.zeus.xspring.core;


public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}

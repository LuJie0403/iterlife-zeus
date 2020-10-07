package com.iterlife.zeus.test;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2020/10/7 14:49
 **/
@Service("iterFactoryBean")
public class IterFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}

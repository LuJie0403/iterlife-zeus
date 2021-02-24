package com.iterlife.zeus.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lujie
 * @Desc Bean 属性配置
 * @Version 1.0.0
 * @since 2020-05-30 18:58
 */
@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "com.iterlife.spring.boot")
public class BeanPropertyConfig {
    public String name = "BeanProperty";
    public String version = "1.0.0";
}

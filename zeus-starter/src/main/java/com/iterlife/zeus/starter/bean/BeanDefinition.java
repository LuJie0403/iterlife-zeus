package com.iterlife.zeus.starter.bean;

import com.iterlife.spring.boot.starter.config.BeanPropertyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iterlife.spring.boot.starter.service.BeanPropertyPrintService;

/**
 * @author lujie
 * @Desc Bean 实例化自动注解
 * @Version 1.0.0
 * @since 2020-05-30 18:58
 */
@Configuration
@EnableConfigurationProperties(BeanPropertyConfig.class)
public class BeanDefinition {
    @Autowired
    private BeanPropertyConfig beanPropertyConfig;

    @Bean
    @ConditionalOnMissingBean(BeanPropertyPrintService.class)
    public BeanPropertyPrintService initBeanPropertyPrintService() {
        BeanPropertyPrintService beanPropertyPrintService =
            new BeanPropertyPrintService(beanPropertyConfig.getName(), beanPropertyConfig.getVersion());
        beanPropertyPrintService.printMessage();
        return beanPropertyPrintService;
    }
}

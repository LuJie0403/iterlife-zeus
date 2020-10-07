package com.iterlife.zeus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

/**
 * @author Lu Jie
 * @desc Hello World
 * @date 2019 2019年2月13日 上午11:43:51
 * @tags
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Configuration
@ComponentScan(basePackages = {
        "com.iterlife.zeus"}, useDefaultFilters = false, includeFilters = @Filter(type = FilterType.ANNOTATION))
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
    }

}
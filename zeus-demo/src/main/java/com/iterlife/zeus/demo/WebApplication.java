package com.iterlife.zeus.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lujie
 * @Desc 启动类
 * @Version 1.0.0
 * @since 2020-05-30 18:58
 */
@SpringBootApplication
@Slf4j
public class WebApplication {

    private final static String WELCOME_MSG = "Welcome to IterLife World";

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(WebApplication.class);
        application.run(args);
        log.info(String.format("%s", WELCOME_MSG));
    }
}

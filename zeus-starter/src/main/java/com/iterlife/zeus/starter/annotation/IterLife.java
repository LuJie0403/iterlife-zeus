package com.iterlife.zeus.starter.annotation;

import java.lang.annotation.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author lujie
 * @Desc 自定义IterBean注解
 * @Version 1.0.0
 * @since 2020-05-30 20:15
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Component
public @interface IterLife {

    String id() default "iterlife-id";

    String name() default "iterlife-name";

    String value() default "iterlife-value";

    String desc() default "iterlife-desc";
}

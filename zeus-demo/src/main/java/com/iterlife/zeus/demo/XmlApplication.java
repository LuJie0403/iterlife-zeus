package com.iterlife.zeus.demo;

import com.iterlife.zeus.demo.web.entity.User2;
import com.iterlife.zeus.demo.web.factory.UserFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lujie
 * @Desc 启动类
 * @Version 1.0.0
 * @since 2020-05-30 18:58
 */
@SpringBootApplication
@Slf4j
public class XmlApplication {

    public static void main(String[] args) throws Exception {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        log.info(applicationContext.getBean("user2").toString());
        log.info(applicationContext.getBean("userFactoryBean2").toString());
        log.info(applicationContext.getBean("&userFactoryBean2").toString());
        log.info(((UserFactoryBean) applicationContext.getBean("&userFactoryBean2")).getObject().toString());

        ((User2) applicationContext.getBean("user2")).printAnnotation();
        ((User2) ((UserFactoryBean) applicationContext.getBean("&userFactoryBean2")).getObject()).printAnnotation();
    }

}

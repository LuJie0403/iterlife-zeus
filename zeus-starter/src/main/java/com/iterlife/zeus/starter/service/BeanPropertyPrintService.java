package com.iterlife.zeus.starter.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author lujie
 * @Desc Bean 属性信息输出类（测试）
 * @Version 1.0.0
 * @since 2020-05-30 18:58
 */
@Getter
@Setter
@Slf4j
@NoArgsConstructor
public class BeanPropertyPrintService {
    public String name;
    public String version;

    public BeanPropertyPrintService(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public void printMessage() {
        log.info(String.format("read bean property configuration success:name=[ %s ],version=[ %s ]", this.name,
                this.version));
    }
}

package com.iterlife.zeus.demo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @desc:
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2020/10/8 20:05
 **/

@RestController
@RequestMapping("/iterlife")
public class ZeusController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "Welcome to Iterlife Spring Boot! " + LocalDateTime.now();
    }
}

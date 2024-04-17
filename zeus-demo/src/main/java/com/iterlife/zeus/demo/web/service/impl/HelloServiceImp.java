package com.iterlife.zeus.demo.web.service.impl;

import com.iterlife.zeus.demo.web.service.HelloService;

public class HelloServiceImp implements HelloService {

	@Override
	public void say(String name) {
		System.out.println("Say hello:" + name);

	}
	

}

package com.iterlife.zeus.service.impl;

import com.iterlife.zeus.service.HelloService;

public class HelloServiceImp implements HelloService {

	@Override
	public void say(String name) {
		System.out.println("Say hello:" + name);

	}
	

}

package com.iterlife.zeus.test.service.impl;

import com.iterlife.zeus.test.service.HelloServce;


public class HelloServceImp implements HelloServce {

	@Override
	public void say(String name) {
		System.out.println("Say hello:" + name);

	}
	

}

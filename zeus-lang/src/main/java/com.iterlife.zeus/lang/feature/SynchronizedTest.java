/**
 *
 * @project zeus
 * @file com.iterlife.zeus.test.SynchronizedTest.java
 * @version 1.0.0
 * Copyright 2019 - 2019 for Lu Jie
 * https://www.iterlife.com
 *
 **/
package com.iterlife.zeus.lang.feature;

/**
 *
 * @desc
 * @author Lu Jie
 * @date 2019 2019年1月25日 上午10:13:47
 * @tags
 */

public class SynchronizedTest implements Runnable {

	int b = 100;

	synchronized void m1() throws InterruptedException {
		b = 1000;
		Thread.sleep(500);
		System.out.println("b=" + b);
	}

	synchronized void m2() throws InterruptedException {
		Thread.sleep(250);
		b = 2000;
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizedTest tt = new SynchronizedTest();
		Thread t = new Thread(tt);
		t.start();
		tt.m2();
		System.out.println("main thread b=" + tt.b);

	}

	@Override
	public void run() {
		try {
			m1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

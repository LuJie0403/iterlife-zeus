package com.iterlife.zeus.demo.jdk;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorTest {

	private static final AtomicInteger taskId = new AtomicInteger(1);
	private static final AtomicInteger threadId = new AtomicInteger(1);

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			run();
		}
	}

	public static void run() throws InterruptedException {
		System.out.println("LinkedBlockingQueue和LinkedBlockingDeque\n"
				+ "两个都是队列，前者只能一端出一端入，后者则可以两端同时出入，并且都是结构改变线程安全的队列\n"
				+ "1.链表结构（动态数组）\n"
				+ "2.通过ReentrantLock实现锁\n3.利用Condition实现队列的阻塞等待和唤醒\n");
		Runnable task = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.currentThread()
							.setName("Task-" + taskId.getAndAdd(1));
					Thread.sleep(2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		testThreadPoolExecuter(task);

	}

	/**
	 * @param task
	 */
	private static void testThreadPoolExecuter(Runnable task) {
		ThreadPoolExecutor linkedBlockTaskPool1 = new ThreadPoolExecutor(5, 10,
				60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		linkedBlockTaskPool1
				.setRejectedExecutionHandler(new RejectedExecutionHandler() {

					@Override
					public void rejectedExecution(Runnable r,
							ThreadPoolExecutor executor) {
						System.out.println("LinkedBlockingDeque队列已满，抛弃当前任务:"
								+ r.getClass().getName());

					}
				});
		System.out.println("核心线程数\t最大线程数\t活跃线程数\t最大任务数\t当前任务数\t排队任务数");
		System.out.println("CSize\tMPSize\tACount\tLPSize\tPSize\tQSize");

		for (int i = 0; i < 20; ++i) {
			linkedBlockTaskPool1.execute(task);
			System.out.println(+linkedBlockTaskPool1.getCorePoolSize() + "\t"
					+ linkedBlockTaskPool1.getMaximumPoolSize() + "\t"
					+ linkedBlockTaskPool1.getActiveCount() + "\t"
					+ linkedBlockTaskPool1.getLargestPoolSize() + "\t"
					+ linkedBlockTaskPool1.getPoolSize() + "\t"
					+ linkedBlockTaskPool1.getQueue().size());
		}
		System.out.println(
				"-------------------------------------------------------");
		ThreadPoolExecutor linkedBlockTaskPool2 = new ThreadPoolExecutor(5, 10,
				60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(8));
		linkedBlockTaskPool2
				.setRejectedExecutionHandler(new RejectedExecutionHandler() {

					@Override
					public void rejectedExecution(Runnable r,
							ThreadPoolExecutor executor) {
						System.out.println("LinkedBlockingDeque队列已满，抛弃当前任务:"
								+ r.getClass().getName());

					}
				});
		for (int i = 0; i < 20; ++i) {
			linkedBlockTaskPool2.execute(task);
			System.out.println(+linkedBlockTaskPool2.getCorePoolSize() + "\t"
					+ linkedBlockTaskPool2.getMaximumPoolSize() + "\t"
					+ linkedBlockTaskPool2.getActiveCount() + "\t"
					+ linkedBlockTaskPool2.getLargestPoolSize() + "\t"
					+ linkedBlockTaskPool2.getPoolSize() + "\t"
					+ linkedBlockTaskPool2.getQueue().size());
		}
		System.out.println(
				"-------------------------------------------------------");

		ThreadPoolExecutor linkedBlockTaskPool3 = new ThreadPoolExecutor(5, 10,
				60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(true));
		linkedBlockTaskPool3
				.setRejectedExecutionHandler(new RejectedExecutionHandler() {

					@Override
					public void rejectedExecution(Runnable r,
							ThreadPoolExecutor executor) {
						System.out.println("SynchronousQueue队列已满，抛弃当前任务:"
								+ r.getClass().getName());

					}
				});
		for (int i = 0; i < 20; ++i) {
			linkedBlockTaskPool3.execute(task);
			System.out.println(+linkedBlockTaskPool3.getCorePoolSize() + "\t"
					+ linkedBlockTaskPool3.getMaximumPoolSize() + "\t"
					+ linkedBlockTaskPool3.getActiveCount() + "\t"
					+ linkedBlockTaskPool3.getLargestPoolSize() + "\t"
					+ linkedBlockTaskPool3.getPoolSize() + "\t"
					+ linkedBlockTaskPool3.getQueue().size());
		}
		System.out.println(
				"-------------------------------------------------------");
		ThreadPoolExecutor linkedBlockTaskPool4 = new ThreadPoolExecutor(5, 10,
				60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		linkedBlockTaskPool4
				.setRejectedExecutionHandler(new RejectedExecutionHandler() {

					@Override
					public void rejectedExecution(Runnable r,
							ThreadPoolExecutor executor) {
						System.out.println("LinkedBlockingQueue队列已满，抛弃当前任务:"
								+ r.getClass().getName());

					}
				});
		for (int i = 0; i < 20; ++i) {
			linkedBlockTaskPool4.execute(task);
			System.out.println(+linkedBlockTaskPool4.getCorePoolSize() + "\t"
					+ linkedBlockTaskPool4.getMaximumPoolSize() + "\t"
					+ linkedBlockTaskPool4.getActiveCount() + "\t"
					+ linkedBlockTaskPool4.getLargestPoolSize() + "\t"
					+ linkedBlockTaskPool4.getPoolSize() + "\t"
					+ linkedBlockTaskPool4.getQueue().size());
		}
		System.out.println(
				"-------------------------------------------------------");

		ThreadPoolExecutor linkedBlockTaskPool5 = new ThreadPoolExecutor(5, 10,
				60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(8));
		linkedBlockTaskPool5
				.setRejectedExecutionHandler(new RejectedExecutionHandler() {

					@Override
					public void rejectedExecution(Runnable r,
							ThreadPoolExecutor executor) {
						System.out.println("LinkedBlockingQueue队列已满，抛弃当前任务:"
								+ r.getClass().getName());

					}
				});
		for (int i = 0; i < 20; ++i) {
			linkedBlockTaskPool5.execute(task);
			System.out.println(+linkedBlockTaskPool5.getCorePoolSize() + "\t"
					+ linkedBlockTaskPool5.getMaximumPoolSize() + "\t"
					+ linkedBlockTaskPool5.getActiveCount() + "\t"
					+ linkedBlockTaskPool5.getLargestPoolSize() + "\t"
					+ linkedBlockTaskPool5.getPoolSize() + "\t"
					+ linkedBlockTaskPool5.getQueue().size());
		}
		System.out.println(
				"-------------------------------------------------------");

		ThreadPoolExecutor linkedBlockTaskPool6 = new ThreadPoolExecutor(5, 10,
				60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(8),
				new ThreadFactory() {

					@Override
					public Thread newThread(Runnable r) {
						Thread thread = new Thread(
								"Thread-" + threadId.getAndAdd(1));
						System.out.println("新建处理线程:" + thread.getName());
						return thread;
					}
				}, new RejectedExecutionHandler() {

					@Override
					public void rejectedExecution(Runnable r,
							ThreadPoolExecutor executor) {
						System.out.println("LinkedBlockingQueue队列已满，抛弃当前任务:"
								+ r.getClass().getName());

					}
				});

		for (int i = 0; i < 20; ++i) {
			linkedBlockTaskPool6.execute(task);
			System.out.println(+linkedBlockTaskPool6.getCorePoolSize() + "\t"
					+ linkedBlockTaskPool6.getMaximumPoolSize() + "\t"
					+ linkedBlockTaskPool6.getActiveCount() + "\t"
					+ linkedBlockTaskPool6.getLargestPoolSize() + "\t"
					+ linkedBlockTaskPool6.getPoolSize() + "\t"
					+ linkedBlockTaskPool6.getQueue().size());
		}
		System.out.println(
				"-------------------------------------------------------");
	}
}

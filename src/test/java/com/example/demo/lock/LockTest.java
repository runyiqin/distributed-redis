package com.example.demo.lock;

import com.example.demo.lock.model.User;
import com.example.demo.lock.util.LockThread;
import com.example.demo.lock.util.RedisThread;
import com.example.demo.lock.util.SynchronizedThread;

public class LockTest {

	public static void main(String[] args) {
		User user = new User("测试", 1000);
		for (int i = 0; i < 30; i++) {
			RedisThread redisThread = new RedisThread(user, 100);
			redisThread.start();
		}
	}

	public static void testLock() {
		User user = new User("测试", 1000);
		for (int i = 0; i < 30; i++) {
			LockThread lockThread = new LockThread(user, 100);
			lockThread.start();
		}
	}

	public static void testSync() {
		User user = new User("测试", 1000);
		for (int i = 0; i < 30; i++) {
			SynchronizedThread synchronizedThread = new SynchronizedThread(user, 100);
			synchronizedThread.start();
		}
	}
}

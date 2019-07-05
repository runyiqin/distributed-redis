package com.example.demo.lock.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import com.example.demo.lock.model.User;

public class LockThread extends Thread {
	private User user;

	private long delnum;

	private static ReentrantLock lock = new ReentrantLock();

	public LockThread(User user, long delnum) {
		super();
		this.user = user;
		this.delnum = delnum;
	}

	@Override
	public void run() { 
		try {
			if (lock.tryLock(1, TimeUnit.SECONDS)) {
				if (user.getMoney() > 0) {
					user.setMoney(user.getMoney() - delnum);
				}
				System.out.println(getName() + "===del===" + user.getMoney());
				lock.unlock();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	private void tryLock() {
		if (lock.tryLock()) {
			if (user.getMoney() > 0) {
				user.setMoney(user.getMoney() - delnum);
			}
			System.out.println(getName() + "===del===" + user.getMoney());
			lock.unlock();
		}
	}

	private void lockTest() {
		lock.lock();
		if (user.getMoney() > 0) {
			user.setMoney(user.getMoney() - delnum);
		}
		System.out.println(getName() + "===del===" + user.getMoney());
		lock.unlock();
	}
}

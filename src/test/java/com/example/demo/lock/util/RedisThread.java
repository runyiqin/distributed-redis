package com.example.demo.lock.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.config.RedisLockImpl;
import com.example.demo.lock.model.User;
import com.example.demo.model.Lock;

public class RedisThread extends Thread{
	
	private User user;

	private long delnum;
	 
	public RedisThread(User user, long delnum) {
		super();
		this.user = user;
		this.delnum = delnum;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		RedisLockImpl redisLockImpl = new RedisLockImpl();
		Lock lock = new Lock("redislock",getName());
 		if(redisLockImpl.tryLock(lock)) {
			if (user.getMoney() > 0) {
				user.setMoney(user.getMoney() - delnum);
			}
			System.out.println(getName() + "===del===" + user.getMoney());
			redisLockImpl.unLock(lock);
		}
	}
}

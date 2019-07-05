package com.example.demo.lock.util;

import com.example.demo.lock.model.User;

public class SynchronizedThread extends Thread{
	
	private User user;
	
	private long delnum; 
	
	public SynchronizedThread(User user, long delnum) {
		super();
		this.user = user;
		this.delnum = delnum;
	}
 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (user) {
			if(user.getMoney()>0) {
				user.setMoney(user.getMoney()-delnum);			
			}
			System.out.println(getName()+"===del==="+user.getMoney());
		}
	}
	
}

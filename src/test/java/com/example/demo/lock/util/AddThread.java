package com.example.demo.lock.util;

import com.example.demo.lock.model.User;

public class AddThread extends Thread{

	private User user;
	
	private long addnum; 
	
	public AddThread(User user, long addnum) {
		super();
		this.user = user;
		this.addnum = addnum;
	}
 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		user.setMoney(user.getMoney()+addnum);
		System.out.println("add==="+user.getMoney());
	}
}

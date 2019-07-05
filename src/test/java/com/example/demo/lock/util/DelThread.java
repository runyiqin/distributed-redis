package com.example.demo.lock.util;

import com.example.demo.lock.model.User;

public class DelThread extends Thread{

	private User user;
	
	private long delnum; 
	
	public DelThread(User user, long delnum) {
		super();
		this.user = user;
		this.delnum = delnum;
	}
 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		user.setMoney(user.getMoney()-delnum);
		System.out.println("add==="+user.getMoney());
	}
}
